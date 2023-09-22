<%-- 
    Document   : agregarPerro
    Created on : 20/09/2023, 4:50:03 p. m.
    Author     : Sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file= "templates/header.jsp" %>

<!-- banner para esta pagina -->
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <img src="imagenes/banner.jpeg" width="1300" height="180" class="d-inline-block align-top" alt="">    
          </a>
</nav>

<div class="container p-4"> <!-- clase contenedora -->
    <div class="row">
        <div class="col-md-4"> <!-- clase de division por 4 columnas -->
            <div class="card card-body">

                <!-- tarjeta de trabajo -->

                <h3>Insertar nuevo perro</h3>        

                <div class="input-group mb-3">
                    <span class="input-group-text" for="nombre">Nombre:</span>
                    <input type="text" class="form-control" name ="nombre" >
                </div>                                            
                <!-- Input para la raza-->
                <div class="input-group mb-3">
                    <span class="input-group-text" for="raza">Raza:</span>
                    <input type="text" class="form-control" name="raza" >
                </div>
                <!-- Input para la foto-->
                <div class="input-group mb-3">
                    <span class="input-group-text" for="imagen">Imagen:</span>
                    <input type="text" class="form-control" name="imagen" >
                </div>
                <!-- input para los puntos -->
                <div class="input-group mb-3">
                    <span class="input-group-text" for="puntos">Puntos:</span>
                    <select class="form-select" name="puntos" >
                        <option selected>Selecione...</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>                          
                    </select>                  
                </div>
                <!-- Input para la edad-->
                <div class="input-group mb-3">
                    <span class="input-group-text" for="edad">Edad:</span>
                    <input type="text" class="form-control"  name="edad" >
                </div>
                </form><br>

                <!-- boton para agregar perro -->

                <button type="button" class="btn btn-success">Agregar perro</button>
                <a href="index.jsp">Volver al Index</a> 
            </div>    
        </div> 


        <!-- tabla para mostrar los datos registrados de los perros -->
        <div class="col-md-8">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Raza</th>
                        <th>Imagen</th>
                        <th>Puntos</th>
                        <th>Edad</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Pistacho </td>
                        <td>Pequinez</td>
                        <td>ft</td>
                        <td>5</td>
                        <td>20</td>
                        <td>xd</td>
                    </tr>
                </tbody> 
            </table>
        </div>
    </div>  
</div>    
</div>



<%@include file= "templates/fooder.jsp" %>