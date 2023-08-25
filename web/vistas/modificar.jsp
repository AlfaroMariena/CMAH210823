<%-- 
    Document   : modificar
    Created on : 08-24-2023, 03:03:21 PM
    Author     : Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
    </head>
    <body>
         <h1>Modificar Registros</h1>
 
        <form action="LibrosController?accion=actualizar" method="POST" autocomplete="off">
            
           <input type="hidden" id="id" name="id" value="<c:out value="${libros.id}" />" />

            <p>
                Titulo: <input type="text" id="titulo" name="titulo" value="<c:out value="${libros.titulo}" />" required />
            </p>

            <p>
                Autor: <input type="text" id="autor" name="autor" value="<c:out value="${libros.autor}" />" required />
            </p>

            <p>
                Fecha Publicacion: <input type="text" id="fechaPublicacion" name="fechaPublicacion" value="<c:out value="${libros.fechaPublicacion}" />" required />
            </p>

            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
           
            
        </form>
    </body>
</html>
