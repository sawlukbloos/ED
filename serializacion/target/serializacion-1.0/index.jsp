<%-- 
    Document   : index
    Created on : 29/08/2023, 5:34:51 p. m.
    Author     : Sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rockola - Reproductor de Videos</title>
    <style>
            /*Estilos en CSS para la pagina principal del programa */
        body {
            font-family: Arial, sans-serif;
            background-image: url('Imagen/img.jpg');/* imagen de fondo*/
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            padding: 0;
            display: flex; 
            flex-direction: column; 
            align-items: center; 
            justify-content: center; 
            height: 100vh; 
        }

        header {
            background-color: rgba(0, 0, 0, 0.7);
            color: #fff;
            text-align: center;
            padding: 20px 0;
        }

        h1 {
            font-size: 36px;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
            text-align: center;
            margin-top: 20px;
        }

        nav ul li {
            display: block;
            margin-bottom: 10px;
        }

        nav ul li a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            font-size: 18px;
            transition: color 0.3s;
            display: block;
            padding: 10px 0;
        }

        nav ul li a:hover {
            color: #ff6600;
        }

        
        nav ul li a i {
            margin-right: 5px;
        }

        footer {
            background-color: rgba(0, 0, 0, 0.7);
            color: #fff;
            text-align: center;
            padding: 10px 0;
            position: absolute;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <header>
        <h1>Sistema Reproductor de Videos</h1>
    </header>
    <nav>       
        <ul>
            <li><a href="agregarVideo.jsp"><i class="fas fa-plus"></i> Ingresar nuevo video</a></li>
            <li><a href="listarVideos.jsp"><i class="fas fa-list"></i> Listado de videos</a></li>            
        </ul>
    </nav>
</body>
</html></html>
