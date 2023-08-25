<%-- 
    Document   : nuevo
    Created on : 08-24-2023, 03:03:03 PM
    Author     : Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LIBROS</title>
    </head>
    <body>
        <h1>NUEVO REGISTRO</h1>
 
        <form action="LibrosController?accion=insertar" method="POST" autocomplete="off">
             <p>
                Titulo: <input type="text" id="titulo" name="titulo" required autofocus="true" />
            </p>

            <p>
                Autor: <input type="text" id="autor" name="autor" required />
            </p>

            <p>
                Fecha Publicacion: <input type="text" id="fechaPublicacion" name="fechaPublicacion" required />
            </p>

           

            <button id="guardar" name="guardar" type="submit">Guardar</button>
            
        </form>
    </body>
</html>
