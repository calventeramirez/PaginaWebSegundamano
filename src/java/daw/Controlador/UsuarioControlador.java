/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.Controlador;

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
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/usuario/*"})
public class UsuarioControlador extends HttpServlet {

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
        switch (accion) {
            case "/home":
                vista = "/index.jsp";
                break;
            case "/crearUsuario":
                String email = request.getParameter("correo");
                String clave2 = request.getParameter("clave");
                String nombre = request.getParameter("nombre");
                String direccion = request.getParameter("direccion");
                String codPostal = request.getParameter("codpostal");
                String facebook = request.getParameter("facebook");
                String twitter = request.getParameter("twitter");
                String telf = request.getParameter("telefono");

                Usuario u = new Usuario();
                u.setCorreo(email);
                u.setClave(clave2);
                u.setNombre(nombre);
                u.setDireccion(direccion);
                u.setCodPostal(codPostal);
                u.setFacebook(facebook);
                u.setTwitter(twitter);
                u.setTelefono(telf);

                persist(u);
                vista = "/index.jsp";
                break;
            case "/login":
                try {
                    String correo = request.getParameter("correo");
                    String clave = request.getParameter("clave");
                    
                    Query q = em.createNamedQuery("Usuario.login", Usuario.class);
                    q.setParameter("user", correo);
                    q.setParameter("pass", clave);
                    List<Usuario> resultado = q.getResultList();
                    if (!resultado.isEmpty()) {
                        Usuario user = resultado.get(0);
                        session.setAttribute("ID", user.getId());
                        session.setAttribute("logueado", user.getNombre());
                        request.setAttribute("msg", "Login Correcto");
                    } else {
                        request.setAttribute("msg", "Usuario o Password Incorrecto");
                    }
                }catch(Exception e){
                    System.err.println("e");
                    request.setAttribute("msg", "ERROR: Imposible Validar");
                }

                vista = "/index.jsp";
                break;
            case "/logout":
                session.setAttribute("ID", "0");
                session.setAttribute("logueado", "0");
                session.setAttribute("cont", "0");
                session.invalidate();
                request.setAttribute("msg", "Usuario Desconectado");
                vista = "/index.jsp";
                break;
            case "/alta":
                vista = "/alta.jsp";
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
            out.println("<title>Servlet controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador at " + request.getContextPath() + "</h1>");
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
