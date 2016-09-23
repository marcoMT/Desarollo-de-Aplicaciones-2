<%-- 
    Document   : lista_creadores
    Created on : 23/09/2016, 11:04:56 AM
    Author     : Marco Antonio Mendiola Torres  markochiva@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Creadores</title>
    </head>
    <body>
        <table>
            <thead>
            <tr>
                <th>Id de creador</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Filiación</th>
                <th>Área Actualización</th>
                
            </tr>
            </thead>
            
            <tbody>
                <c:forEach var="creador" items="${creadores}">
                    <tr>
                        <td>${creador.idCreador}</td>
                        <td>${creador.nombre}</td>
                        <td>${creador.apellido}</td>
                        <td>${creador.filiacion}</td>
                        <td>${creador.area_actualizacion}</td>
                        <td><a href="CreadorController?action=borrar&idCreador=${creador.idCreador}">Borrar</a></td>
                        <td><a href="CreadorController?action=cambiar&idCreador=${creador.idCreador}">Cambiar</a></td>
                        
                    </tr>
                    
                    
                </c:forEach>
                
            </tbody>
            
        </table>
        <p>
            <a href="CreadorController?action=agregar">
                Agregar creador
            </a>
        </p>
    </body>
</html>
