<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>libros</title>
    </head>
    <body>
        <h1>
            <c:if test="${libros.id == 0}">Nuevo</c:if>
            <c:if test="${libros.id != 0}">Editar</c:if>
        </h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value="${libros.id}" />
            <table>
                <tr>
                    <td>Titulo:</td>
                    <td><input type="text" name="titulo" value="${libros.titulo}" /></td>
                </tr>
                <tr>
                    <td>Autor:</td>
                    <td><input type="text" name="autor" value="${libros.autor}" /></td>
                </tr>
                <tr>
                    <td>Disponible:</td>
                    <td><input type="text" name="disponible" value="${libros.disponible}" /></td>
                </tr>
                <tr>
                    <td>Categoria:</td>
                    <td><input type="text" name="categoria" value="${libros.categoria}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
