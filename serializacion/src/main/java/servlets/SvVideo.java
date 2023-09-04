
package servlets;

import com.umariana.mundo.Video;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvVideo", urlPatterns = {"/SvVideo"})
public class SvVideo extends HttpServlet {
    
     @Override
     public void init() throws ServletException {
        super.init();
        // Asegúrate de obtener el ServletContext correctamente
        ServletContext servletContext = getServletContext();
        
        // Cargar los videos serializados al iniciar la aplicación
        cargarVideosDesdeArchivo(servletContext);
    }
    
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
        
        try {
            int idVideoInt = Integer.parseInt(idVideo);
            // Ingresar datos al objeto
            Video miVideo = new Video(idVideoInt, titulo, autor, anio, categoria, url, letra);
            misVideos.add(miVideo);
        } catch (NumberFormatException e) {
            // Manejo de la excepción si idVideo no es un número válido
            e.printStackTrace();
            System.out.println("Error al convertir idVideo a entero: " + e.getMessage());
        }

        // Guardar la lista de videos en un archivo
        guardarVideosEnArchivo();
        
        // Establecer el ArrayList como un atributo de solicitud
        request.setAttribute("misVideos", misVideos);
        
        // Redirigir a la página JSP que muestra la lista de videos
        request.getRequestDispatcher("listarVideos.jsp").forward(request, response);
        
    }
    
    // Método para guardar la lista de videos en un archivo
    private void guardarVideosEnArchivo() {
        try {
            // Obtener la ruta real de la carpeta "data" en el proyecto web
            String dataPath = getServletContext().getRealPath("/data");

            // Verificar si la carpeta "data" existe, si no, crearla
            File dataFolder = new File(dataPath);
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }

            // Crear un archivo ".ser" para guardar la lista de videos serializada
            // Añadimos una excepcion para imprimir aviso en caso de algun error en guardar los datos 
            String filePath = dataPath + File.separator + "videos.ser";
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(misVideos);
            oos.close();
            System.out.println("Datos de videos guardados exitosamente en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos de videos: " + e.getMessage());
        }
    }
    
    // Método para cargar los videos desde el archivo
    public void cargarVideosDesdeArchivo(ServletContext servletContext) {
        try {
            // Obtener la ruta real del archivo de datos
            String dataPath = servletContext.getRealPath("/data/videos.ser");
            
            // Verificar si el archivo existe
            File archivo = new File(dataPath);
            if (archivo.exists()) {
                FileInputStream fis = new FileInputStream(dataPath);
                ObjectInputStream ois = new ObjectInputStream(fis);
                misVideos  = (ArrayList<Video>) ois.readObject();
                ois.close();
                System.out.println("Datos de videos cargados exitosamente desde: " + dataPath);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los datos de videos: " + e.getMessage());
        }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
