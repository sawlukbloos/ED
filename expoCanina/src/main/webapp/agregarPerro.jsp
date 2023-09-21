<%-- 
    Document   : agregarPerro
    Created on : 20/09/2023, 4:50:03 p. m.
    Author     : Sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file= "templates/header.jsp" %>
        
        <div class = "container text-center">  <!-- clase contenedora --> 
            <h1>Exposicion Canina</h1>
            <div class = "row"  > <!-- clase row  -->
                <div class = "col"  >
                <div class = "card card-body"> <!-- targeta de trabajo -->
                   <form action="SvVideo" method="POST">         
            
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" class = "form-control"><br>

                    <label for="raza">Raza:</label>
                    <input type="text" name="raza" class = "form-control"><br>

                    <label for="imagen">Imagen:</label>
                    <input type="text" name="imagen" class = "form-control"><br>
                    
                    <label for="puntos">Puntos:</label>
                    <input type="text" name="puntos" class ="form-control"><br>

                    <label for="edad">Edad:</label>
                    <input type="text" name="edad" class ="form-control"><br>


                    <input type="submit" value="Agregar perro" class ="form-control">
                </form>  
                <a href="index.jsp">Volver al menu</a> 
                </div>
            </div>
            
                
                
            <div class = "col-md-8"  >
                <table class="table table-bordered">
                    <thead><!-- comment -->
                        <tr><!-- comment -->
                            <th> Nombre </th>
                            <th> Raza </th>
                            <th> Imagen </th>
                            <th> Puntos </th>
                            <th> Edad </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td> XD </td>
                            <td> Pequines  </td>
                            <td> Mas tarde </td>
                            <td> 5 </td>
                            <td> 7 </td>
                            
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
        
               
 <%@include file= "templates/fooder.jsp" %>