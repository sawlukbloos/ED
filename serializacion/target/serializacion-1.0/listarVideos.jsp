<%-- 
    Document   : listarVideos
    Created on : 31/08/2023, 10:30:45 a. m.
    Author     : Acer
--%>

<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.mundo.Video"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        h1 {
            text-align: center;
        }
    </style>                
    </head>
    <body>
        <h1>Listar Videos</h1>
        
        <%
            
            ArrayList<Video> misVideos = null;
            // Obtener la ruta real del archivo de datos
            String dataPath = application.getRealPath("/data/videos.ser");
            
            // Verificar si el archivo existe
            File archivo = new File(dataPath);
            if (archivo.exists()) {
                FileInputStream fis = new FileInputStream(dataPath);
                ObjectInputStream ois = new ObjectInputStream(fis);
                misVideos  = (ArrayList<Video>) ois.readObject();
                ois.close();
                System.out.println("Datos de videos cargados exitosamente desde: " + dataPath);
            }
            
            // Obtener array list de la solicitud
             if (misVideos != null) {
                System.out.println("Se cargaron " + misVideos.size() + " videos exitosamente.");
                for (Video v : misVideos) {
                    out.print("IdVideo:" + v.getIdVideo() + "<br>");
                    out.print("Titulo:" + v.getTitulo() + "<br>");
                    out.print("Autor;" + v.getAutor() + "<br>");
                    out.print("Anio:" + v.getAnio() + "<br>");
                    out.print("Categoria:" + v.getCategoria() + "<br>");
                    out.print("Url" + v.getUrl() + "<br>");
                    out.print("Letra:" + v.getLetra() + "<br>");
                    out.print("------------------------------------------------------------"+"<br>");
                }
            } else {
                out.print("No hay videos disponibles.");
            }
        %>
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
