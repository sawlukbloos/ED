<%-- 
    Document   : agregarvideo
    Created on : 29/08/2023, 5:45:41 p. m.
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
        /* Estilos en css para mejorar la interfaz de la pagina */
        body {
            font-family: Arial, sans-serif; 
            background-image: url('Imagen/img.jpg');/* imagen de fondo*/
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            color: #fff;
        }

        .container {
            max-width: 400px; 
            margin: 0 auto;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            display: flex;
            flex-direction: column;
            align-items: center; 
            justify-content: center; 
        }

        label {
            display: block;
            font-weight: bold;
            margin-top: 10px;
            color: #333;
            text-align: center;
            font-size: 14px;
            width: 100%; 
        }

        input[type="text"],
        textarea {
            width: 95%; 
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin: 10px 0; 
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-top: 10px; 
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
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
    <h1>Sistema Reproductor de Videos</h1>
    <div class="container"> 
        <form action="SvVideo" method="POST">
            <label for="idVideo">Id Video:</label>
            <input type="text" name="idVideo">

            <label for="titulo">Título:</label>
            <input type="text" name="titulo">

            <label for="autor">Autor:</label>
            <input type="text" name="autor">

            <label for="anio">Año:</label>
            <input type="text" name="anio">

            <label for="url">URL:</label>
            <input type="text" name="url">

            <label for="categoria">Categoría:</label>
            <input type="text" name="categoria">

            <label for="letra">Letra:</label>
            <textarea id="letra" name="letra" rows="5" cols="10"></textarea>

            <input type="submit" value="Agregar video">
        </form>
        <a href="index.jsp">Volver al menú</a>
    </div>
</body>
</html>
