/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.umariana.mundo.Lista;
import com.umariana.mundo.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Acer
 */
@WebServlet(name = "SvTarea", urlPatterns = {"/SvTarea"})
public class SvTarea extends HttpServlet {
    
    private Lista listaTareas;
     
  @Override
  public void init() throws ServletException {
        // Inicializa la lista de tareas al cargar el servlet
        listaTareas = Lista.leerLista(getServletContext());
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

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
        //recibimos los datos de la tarea ingresados por el usuario
        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fechaV");
        String posicion = request.getParameter("posicion");
        String idAntesDe = request.getParameter("idAntesDe"); 
        String idDespuesDe = request.getParameter("idDespuesDe");
        
        //Convertimos o casteamos la fecha que es tipo String a Date para poder inicializarla en el constructor
        Date fechaV = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            fechaV = dateFormat.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Creamos un nuevo objeto de tipo tarea e inicializamos los atributos con los datos que ingreso el usuario
        Tarea nuevaTarea = new Tarea(Integer.parseInt(id), titulo, descripcion, fechaV);
        HttpSession session = request.getSession();
        Lista listaTareas = (Lista) session.getAttribute("listaTareas");

        if (listaTareas == null) {
            listaTareas = new Lista();
            // Guárdala en la sesión
            session.setAttribute("listaTareas", listaTareas);
        }
        
        //Un filtro para los id de las tareas, para que sea un dato unico en las tareas ingresadas
        if (listaTareas != null) {
        Lista.Nodo nodoActual = listaTareas.inicio;
        while (nodoActual != null) {
            if (nodoActual.tarea.getId() == Integer.parseInt(id)) {
                // Manejar el caso de ID duplicado, por ejemplo, redirigir a una página de error o mostrar un mensaje de error
                response.sendRedirect("Tareas.jsp?alert=error");
                return;
            }
            nodoActual = nodoActual.siguiente;
        }
    }

        // Redirige a la página Tareas.jsp
        response.sendRedirect("Tareas.jsp");
        //funciones de los radio buttons
        if("primero".equals(posicion)){
            //Agrega la tarea al inicio de la lista
            listaTareas.agregarTareaAlInicio(nuevaTarea);
        } else if ("ultimo".equals(posicion)) {
            // Agrega la tarea al final de la lista
            listaTareas.agregarTareaAlFinal(nuevaTarea);
        } else if ("antesDe".equals(posicion)) {
            if (idAntesDe != null && !idAntesDe.isEmpty()) {
                // Agrega la tarea antes de la tarea con la ID especificada
                listaTareas.agregarTareaAntesDe(Integer.parseInt(idAntesDe), nuevaTarea);
            } else {
                // Si no se proporciona una ID antes de la cual agregar, agregar al comienzo
                listaTareas.agregarTareaAlInicio(nuevaTarea);
            }
        } else if ("despuesDe".equals(posicion)) {
            if (idDespuesDe != null && !idDespuesDe.isEmpty()) {
                // Agregar la tarea después de la tarea con la ID especificada
                listaTareas.agregarTareaDespuesDe(Integer.parseInt(idDespuesDe), nuevaTarea);
            } else {
                // Si no se proporciona una ID después de la cual agregar, agregar al final
                listaTareas.agregarTareaAlFinal(nuevaTarea);
            }
        } else {
            // Si no se selecciona ninguno de los anteriores, la tarea se agregara al final de la lista
            listaTareas.agregarTareaAlFinal(nuevaTarea);
        }
        // Obtén el ID de la tarea a eliminar
    
        

        
}
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
