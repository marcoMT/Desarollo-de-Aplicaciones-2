<%-- 
    Document   : creador
    Created on : 23/09/2016, 11:05:06 AM
    Author     : Marco Antonio Mendiola Torres  markochiva@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creador</title>
    </head>
    <body>
        <form action="CreadorController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>
                
                <div>
                <label for="idCreador">Id Creador:</label>
                <input type="text" name="idCreador" value="${creador.idCreador}" 
                       readonly="readonly" placeholder="Id del creador" /> 
                </div>
                
                <div>
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre" value="${creador.nombre}" 
                       placeholder="Nombre del creador" /> 
                </div>
                
                <div>
                <label for="apellido">Apellido:</label>
                <input type="text" name="apellido" value="${creador.apellido}" 
                       placeholder="Apellido del creador" /> 
                </div>
                       
                <div>
                <label for="filiacion">Filiación:</label>
                <input type="text" name="filiacion" value="${creador.filiacion}" 
                       placeholder="Filiación" /> 
                </div>
                       
                <div>
                <label for="area_actualizacion">Área Actualización:</label>
                <input type="text" name="area_actualizacion" value="${creador.area_actualizacion}" 
                       placeholder="Area Áctualización" /> 
                </div>
                       
                       <input type="submit" value="Guardar"/>
                       
            </fieldset>
            
        </form>
    </body>
</html>
