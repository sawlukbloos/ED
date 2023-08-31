<%-- 
    Document   : agregarvideo
    Created on : 29/08/2023, 5:45:41 p. m.
    Author     : Sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rockola</title>
    </head>
    <body>
        <h1>Sistema Reproductor de videos</h1>
        
        
        <form action="SvVideo" method="POST">
            
            <label for="idVideo">idvideo:</label>
            <input type="text" name="idVideo"><br>
            
            <label for="titulo">Titulo:</label>
            <input type="text" name="titulo"><br>
            
            <label for="autor">Autor:</label>
            <input type="text" name="autor"><br>
            
            <label for="anio">Año:</label>
            <input type="text" name="anio"><br>
            
            <label for="url">Url:</label>
            <input type="text" name="url"><br>
            
            <label for="categoria">Categoria:</label>
            <input type="text" name="categoria"><br>
            
            <label for="letra">Letra:</label>
            <textarea id="id" name="letra" rows="5" cols="10"></textarea>
            
            <input type="submit" value="Agregar video">
        </form>  
        <a href="index.jsp">Volver al menu</a>
    </body>
</html>
