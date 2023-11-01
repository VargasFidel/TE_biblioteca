<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <body>
        <h1>
            <c:if test="${categorias.id == 0}">Nuevo</c:if>
            <c:if test="${categorias.id != 0}">Editar</c:if>
        </h1>
        <form action="Inicio" method="post">
            <input type="hidden" name="id" value="${categorias.id}" />
            <table>
                    <td>Categoria:</td>
                    <td><input type="text" name="categoria" value="${categorias.categoria}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
