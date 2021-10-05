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
@WebServlet(name = "ComentariosControlador", urlPatterns = {"/comentarios/*"})
public class ComentariosControlador extends HttpServlet {

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
        
        switch(accion){
            case "/comentar":             
                String texto = request.getParameter("texto");
                String visibilidad = request.getParameter("visibilidad");
                String idp = request.getParameter("id");
                Long idp_l = Long.parseLong(idp);
                Long id = (Long) session.getAttribute("ID");
                Query q = em.createNamedQuery("Usuario.findId", Usuario.class);
                q.setParameter("id", id);
                List<Usuario> lista = q.getResultList();
                Usuario user = lista.get(0);
                
                Query q1 = em.createNamedQuery("Articulos.findID", Articulos.class);
                q1.setParameter("id", idp_l);
                List<Articulos> listaArt = q1.getResultList();
                
                Comentarios c = new Comentarios();
                
                c.setTexto(texto);
                c.setVisibilidad(visibilidad);
                c.setUser(user);
                c.setArticulo(listaArt);
                persist(c);
                
                vista="/index.jsp";
                break;
            default:
                vista ="/index.jsp";
                break;
        }
        
        RequestDispatcher rd =request.getRequestDispatcher(vista);
        rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ComentariosControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComentariosControlador at " + request.getContextPath() + "</h1>");
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
