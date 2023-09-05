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
    <meta charset="UTF-8">
    <title>Listar Videos</title>
    <style>
        /* Estilos en CSS para la interfaz que muestra el listado de los videos */
        body {
            font-family: Arial, sans-serif;
            background-image: url('Imagen/img.jpg');/* imagen de fondo*/
            background-size: cover;
            background-repeat: no-repeat;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            color: #fff;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .video-info {
            margin-bottom: 20px;
        }

        .video-info h2 {
            font-size: 18px;
            margin-top: 10px;
            color: #333;
        }

        .video-info p {
            margin: 5px 0;
        }

        a {
            display: block;
            text-align: center;
            text-decoration: none;
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            margin-top: 20px;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Listar Videos</h1>
    <div class="container">
        <%
            ArrayList<Video> misVideos = null;
            // Obtener el path real del archivo de datos
            String dataPath = application.getRealPath("/data/videos.ser");

            // Verificar si el archivo existe y leerlo
            File archivo = new File(dataPath);
            if (archivo.exists()) {
                FileInputStream fis = new FileInputStream(dataPath);
                ObjectInputStream ois = new ObjectInputStream(fis);
                misVideos = (ArrayList<Video>) ois.readObject();
                ois.close();
                out.println("<div class='video-info'>");
                //Usamos un ciclo "If" para verificar si el el ArrayList esta vacio
                //En caso de estar vacio, se imprimen mensajes de aviso
                if (misVideos != null && !misVideos.isEmpty()) {
                    for (Video v : misVideos) {
                    //Imprimir los datos del ArrayList con salto de linea
                        out.println("<h2>Video #" + v.getIdVideo() + "</h2>");
                        out.println("<p><strong>Título:</strong> " + v.getTitulo() + "</p>");
                        out.println("<p><strong>Autor:</strong> " + v.getAutor() + "</p>");
                        out.println("<p><strong>Año:</strong> " + v.getAnio() + "</p>");
                        out.println("<p><strong>Categoría:</strong> " + v.getCategoria() + "</p>");
                        out.println("<p><strong>URL:</strong> " + v.getUrl() + "</p>");
                        out.println("<p><strong>Letra:</strong> " + v.getLetra() + "</p>");
                        out.println("<hr>");
                    }
                } else {
                    out.println("<p>No hay videos disponibles.</p>");
                }
                out.println("</div>");
            } else {
                out.println("<p>No se encontró el archivo de datos.</p>");
            }
        %>
        <a href="index.jsp">Volver al inicio</a>
    </div>
</body>
</html>
