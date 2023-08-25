<%-- 
    Document   : index
    Created on : 08-24-2023, 03:02:51 PM
    Author     : Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros </title>
    </head>
    <body>
        <h1> Libros</h1>

        <a href="LibrosController?accion=nuevo">Registra tus libros</a>

        <br><br/>
        
        <table border="1" width="80%">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Titulo del Libro</th>
                    <th>Autor del Libro</th>
                    <th>Fecha de publicacion</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="libros" items="${lista}">
                    <tr>
                        <td><c:out value="${libros.id}"/></td>
                         <td><c:out value="${libros.titulo}"/></td>
                          <td><c:out value="${libros.autor}"/></td>
                           <td><c:out value="${libros.fechaPublicacion}"/></td>
                <td><a href="LibrosController?accion=modificar&id=<c:out value="${libros.id}" />">Modificar</a></td>
                    <td><a href="LibrosController?accion=eliminar&id=<c:out value="${libros.id}" />">Eliminar</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
