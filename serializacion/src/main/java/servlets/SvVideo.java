
package servlets;

import com.umariana.mundo.Video;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvVideo", urlPatterns = {"/SvVideo"})
public class SvVideo extends HttpServlet {
    
    ArrayList<Video> misVideos = new ArrayList<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
                
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // aqui vienen los datos por POST
        
        String idVideo = request.getParameter("idVideo");
        System.out.println("idVideo: "+idVideo);
        
        String titulo = request.getParameter("titulo");
        System.out.println("Titulo: " + titulo);

        String autor = request.getParameter("autor");
        System.out.println("Autor: " + autor);

        String anio = request.getParameter("anio");
        System.out.println("Año: " + anio);

        String url = request.getParameter("url");
        System.out.println("URL: " + url);

        String categoria = request.getParameter("categoria");
        System.out.println("Categoria: " + categoria);

        String letra = request.getParameter("letra");
        System.out.println("Letra: " + letra);
        
        Video miVideo = new Video(Integer.parseInt(idVideo), titulo, autor, anio, categoria, url, letra);
        misVideos.add(miVideo);
        
        request.setAttribute("misVideos", misVideos);
        
        request.getRequestDispatcher("listarVideos.jsp").forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
