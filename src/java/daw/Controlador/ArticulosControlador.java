/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Controlador;

import daw.Beans.Articulos;
import daw.Beans.Comentarios;
import daw.Beans.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pablo
 */
@WebServlet(name = "ArticulosControlador", urlPatterns = {"/articulos/*"})
public class ArticulosControlador extends HttpServlet {
    
    @PersistenceContext(unitName = "ProyectoFinalPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion;
        accion = request.getPathInfo();
        String vista;
        HttpSession session = request.getSession();
        List<Articulos> interes;
        switch (accion) {
            case "/verArticulo":
                Query query = em.createNamedQuery("Articulos.all", Articulos.class);
                List<Articulos> lr = query.getResultList();
                request.setAttribute("articulos", lr);
                vista = "/verArticulo.jsp";
                break;
            case "/publicarArticulo":
                vista = "/publicar.jsp";
                break;
            case "/publicar":
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                String categoria = request.getParameter("categoria");
                String estado = request.getParameter("estado");
                String fecha = request.getParameter("fecha");
                double precio = Double.parseDouble(request.getParameter("precio"));
                
                Long idu = (Long) session.getAttribute("ID");
                Query q1 = em.createNamedQuery("Usuario.findId", Usuario.class);
                q1.setParameter("id", idu);
                List<Usuario> listus = q1.getResultList();
                Usuario user = listus.get(0);
                
                Articulos art = new Articulos();
                art.setNombre(nombre);
                art.setDescripcion(descripcion);
                art.setCategoria(categoria);
                art.setEstado(estado);
                art.setFecha(fecha);
                art.setPrecio(precio);
                art.setUser(user);
                persist(art);
                
                vista = "/index.jsp";
                break;
            case "/detalles":
                String idf = request.getParameter("id");
                //Query del producto (detalles)
                Query q = em.createNamedQuery("Articulos.findID", Articulos.class);
                q.setParameter("id", Integer.parseInt(idf));
                List<Articulos> la = q.getResultList();
                Articulos a = la.get(0);
                request.setAttribute("articulo", a);
                //Query del comentario
                Query qprivados = null,
                 qpublicos = null,
                 qvendedor = null,
                 qid;
                Long id = (Long) session.getAttribute("ID");
                qprivados = em.createNamedQuery("Comentarios.seleccionarComentarios", Comentarios.class);
                qprivados.setParameter("art", a);
                qprivados.setParameter("visibilidad", "Privado");
                
                qvendedor = em.createNamedQuery("Comentarios.seleccionarComentarios", Comentarios.class);
                qvendedor.setParameter("art", a);
                qvendedor.setParameter("visibilidad", "Vendedor");
                
                qpublicos = em.createNamedQuery("Comentarios.seleccionarComentarios", Comentarios.class);
                qpublicos.setParameter("art", a);
                qpublicos.setParameter("visibilidad", "Publico");
                
                List<Comentarios> listaprivada = qprivados.getResultList();
                System.out.println(listaprivada.size());
                request.setAttribute("listaPrivada", listaprivada);
                List<Comentarios> listavendedor = qvendedor.getResultList();
                request.setAttribute("listaVendedor", listavendedor);
                List<Comentarios> listapublica = qpublicos.getResultList();
                request.setAttribute("listaPublica", listapublica);
                vista = "/detalles.jsp";
                break;
            case "/addFavorito":
                String idf1 = request.getParameter("id");
                if (idf1 != null) {
                    Query q2 = em.createNamedQuery("Articulos.findID", Articulos.class);
                    q2.setParameter("id", Integer.parseInt(idf1));
                    List<Articulos> la2 = q2.getResultList();
                    if (la2 != null) {//existe articulo
                        interes = (List<Articulos>) session.getAttribute("lart");
                        if (interes == null) {
                            interes = new ArrayList<>();
                        }
                        Articulos a1 = la2.get(0);
                        interes.add(a1);
                        session.setAttribute("lart", interes);
                    }
                }
                vista = "/index.jsp";                
                break;
            case "/interes":
                vista = "/interes.jsp";
                break;
            case "/delFavorito":
                String idf2 = request.getParameter("id");
                int i = Integer.parseInt(idf2);
                interes = (List<Articulos>) session.getAttribute("lart");
                interes.remove(i);
                session.setAttribute("lart", interes);
                vista = "/interes.jsp";
                break;
            case "/invalidar":
                session.invalidate();
                vista = "/interes.jsp";
                break;
            case "/filtro":
                String where = null;
                boolean bcat = false,                
                 bmenor = false,
                 bmayor = false;
                
                String cat = request.getParameter("categoria"),
                 codpost = request.getParameter("codpostal"),
                 menor = request.getParameter("pmenor"),
                 mayor = request.getParameter("pmayor"),
                 opciones = request.getParameter("opciones");
                Query q3 = null;
                List<Articulos> la2 = null;
                switch(opciones){
                    case "categoria":
                        q3 = em.createNamedQuery("Articulos.findCategoria", Articulos.class);
                        q3.setParameter("categoria", cat);
                        la2=(List<Articulos>) q3.getResultList();
                        break;
                    case "precio minimo":
                        q3=em.createNamedQuery("Articulos.findPrecioMinimo",Articulos.class);
                        q3.setParameter("pmenor", menor);
                        la2=(List<Articulos>) q3.getResultList();
                        break;
                    case "precio mayor":
                        q3=em.createNamedQuery("Articulos.findPrecioMaximo",Articulos.class);
                        q3.setParameter("pmayor", mayor);
                        la2=(List<Articulos>) q3.getResultList();
                        break;
                    case "rango de precio":
                        q3=em.createNamedQuery("Articulos.findRangoPrecio",Articulos.class);
                        q3.setParameter("pmenor", menor);
                        q3.setParameter("pmayor", mayor);
                        la2=(List<Articulos>) q3.getResultList();
                        break;
                    case "codigo postal":
                        q3=em.createNamedQuery("Usuario.findCP", Usuario.class);
                        q3.setParameter("cp", codpost);
                        List<Usuario> luser = (List<Usuario>)q3.getResultList();
                        Usuario u = new Usuario();
                        for(int j=0; j<luser.size();j++){
                            u=luser.get(j);
                            for(int k=0; k<u.getProductos().size();k++){
                                la2=(List<Articulos>)u.getProductos().get(k);
                            }
                        }
                        break;
                    default:
                        request.setAttribute("msg", "Opcion no valida del filtro");
                        break;
                }
                request.setAttribute("articulos", la2);
                vista = "/verArticulos.jsp";
                break;
            default:
                vista = "/index.jsp";
                break;
        }
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ArticulosControlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ArticulosControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
}
