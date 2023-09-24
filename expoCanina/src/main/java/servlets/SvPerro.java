/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.umariana.mundo.Perro;
import com.umariana.mundo.ExposicionPerros;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David Noguera
 */
@WebServlet(name = "SvPerro", urlPatterns = {"/SvPerro"})
public class SvPerro extends HttpServlet {

    ArrayList<Perro> darPerros = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        // Obtener el ServletContext correctamente
        ServletContext servletContext = getServletContext();

        // Cargar los videos serializados al iniciar la aplicación
        darPerros = ExposicionPerros.cargarPerros(servletContext);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
