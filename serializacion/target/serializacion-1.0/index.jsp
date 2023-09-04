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
        body {
            font-family: Arial, sans-serif;
            background-image: url('https://static.vecteezy.com/system/resources/previews/005/490/647/non_2x/bright-blue-wallpaper-for-website-banner-abstract-geometric-pattern-with-line-connection-and-light-particle-structure-of-energy-or-global-space-free-vector.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            padding: 0;
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
        }

        nav ul li {
            display: inline;
            margin: 0 20px;
        }

        nav ul li a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            font-size: 18px;
            transition: color 0.3s;
        }

        nav ul li a:hover {
            color: #ff6600;
        }

        footer {
            background-color: rgba(0, 0, 0, 0.7);
            color: #fff;
            text-align: center;
            padding: 10px 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>Sistema Reproductor de Videos</h1>
    </header>
    <nav>
        <ul>
            <li><a href="agregarVideo.jsp">Ingresar nuevo video</a></li>
            <li><a href="listarVideos.jsp">Listado de videos</a></li>
        </ul>
    </nav>
    <footer>
        <!-- No hay texto de derechos reservados aquí -->
    </footer>
</body>
</html>
