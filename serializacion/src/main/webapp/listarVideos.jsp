<%-- 
    Document   : listarVideos
    Created on : 31/08/2023, 10:30:45 a. m.
    Author     : Acer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.mundo.Video"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listar Videos</h1>
        
        <%
            
            // Obtener array list de la solicitud
            ArrayList<Video> misVideos = (ArrayList<Video>) request.getAttribute("misVideos");
            // Verificar si misVideos no es nulo antes de iterar sobre él
            
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
                out.print("No hay videos disponibles el servidor tuvo un error interno.");
            }
             
        %>
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
