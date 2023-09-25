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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String raza = request.getParameter("raza");
        String imagen = request.getParameter("imagen");
        String puntosStr = request.getParameter("puntos");
        String edadStr = request.getParameter("edad");

        // Try n Catch para los datos ademas de un casteo para puntos y edad
        try {
            int puntos = Integer.parseInt(puntosStr);
            int edad = Integer.parseInt(edadStr);

            // Crear un Perro
            Perro miPerro = new Perro(nombre, raza, imagen, puntos, edad);

            // Obtener la lista actual de perros
            ArrayList<Perro> misPerros = ExposicionPerros.cargarPerros(getServletContext());

            // Agregar el nuevo perro a la lista
            misPerros.add(miPerro);

            // Guardar la lista actualizada de perros en el archivo.ser
            ExposicionPerros.guardarPerro(misPerros);

            // Agregar la lista de perros al objeto de solicitud
            request.setAttribute("misPerros", misPerros);

            // Redireccionar a la página web agregarPerro
            request.getRequestDispatcher("agregarPerro.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Manejo de la excepción si los valores de puntos o edad no son números válidos
            e.printStackTrace();
            System.out.println("Error al convertir puntos o edad a entero: " + e.getMessage());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
