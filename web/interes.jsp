<%-- 
    Document   : interes
    Created on : 21-ene-2021, 1:12:28
    Author     : Pablo
--%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SegundaMano</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/ProyectoFinal/CSS/estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/png" href="/ProyectoFinal/IMG/Logos e Iconos/icono.png">
    </head>
    <body>
        <div id="contenedor">
            <header id="cabecera">
                <center><h1>Tienda de segunda mano</h1>
                    <a title="SegundaMano" href="/ProyectoFinal/controlador/home"><img src="/ProyectoFinal/IMG/Logos e Iconos/logo.jpg" width="20%" height="50%"alt=""/></a>
                </center>
            </header>
            <%@include file="WEB-INF/menu.jspf"%>
            <section id="principal">
                <h1>Favoritos </h1>
                <c:choose>
                    <c:when test="${!empty sessionScope.lart}">
                        <table>
                            <tr>
                                <th>REFERENCIA</th>
                                <th>NOMBRE</th>
                                <th>PRECIO</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                            <c:set var="i" value="-1" />
                            <c:forEach var="art" items="${sessionScope.lart}">
                                <tr>
                                    <td>${art.id}</td>
                                    <td>${art.nombre}</td>
                                    <td>${art.precio}</td>
                                    <td><a href="delFavorito?id=${i=i+1}">(-)</a></td>
                                    <td><a href="detalles?id=${art.id}">Detalles</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <p>
                            <a href="invalidar">Borrar Todo</a>
                        </p>
                    </c:when>
                    <c:otherwise>
                        <p>No hay Artículos en favoritos</p>
                    </c:otherwise>
                </c:choose>
                <br />
            </section>
            <footer id="pie">
                &copy; Pablo Jesús Calvente Ramírez, 2020.webmaster:pablojesus.calvente@alu.uhu.es
            </footer>
        </div>
        <script src="JS/JS.js" type="text/javascript"></script>
    </body>
</html>
