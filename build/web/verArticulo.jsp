<%-- 
    Document   : verArticulo
    Created on : 21-ene-2021, 1:09:37
    Author     : Pablo
--%>
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
                    <a title="SegundaMano" href="/ProyectoFinal/usuario/home"><img src="/ProyectoFinal/IMG/Logos e Iconos/logo.jpg" width="20%" height="50%"alt=""/></a>
                </center>
            </header>
            <%@include file="WEB-INF/menu.jspf"%>
            <section id="principal">
                <div>
                    <h1>Listado de Artículos</h1>
                    <form>
                        <fieldset>                            
                            <legend>Filtro</legend>
                            <c:if test="${requestScope.msg!=null}"><p>${requestScope.msg}</p></c:if>
                                Seleccione el tipo de filtro:
                                <select name="opciones" required>
                                    <option>categoria</option>
                                    <option>precio minimo</option>
                                    <option>precio mayor</option>
                                    <option>rango de precio</option>
                                    <option>codigo postal</option>
                                </select>
                                <br />
                                Categoria:
                                <select name="categoria">
                                    <option>Electronica</option>
                                    <option>Lecturas</option>
                                    <option>Juegos</option>
                                    <option>Otros</option>
                                </select>
                                <br/>
                                Codigo Postal:
                                <input id="codpostal" type="text" name="codpostal" placeholder="Codigo Postal"/><br />
                                Precio: 
                                <input id="pmenor" type="text" name="pmenor" size="4" placeholder="Precio Menor"/> | <input id="pmayor" type="text" name="pmayor" size="4" placeholder="Precio Mayor"/> <br/>
                                <input type="button" class="botonform" value="Filtar" onclick="filtrar();"/>
                                <input type="reset" class="botonform" value="Borrar" />
                            </fieldset>
                        </form>

                    </div>
                    <div id="respuesta">
                    <c:choose>
                        <c:when test="${!empty requestScope.articulos}">
                            <table>
                                <tr>
                                    <th>REFERENCIA</th>                                  
                                    <th>NOMBRE</th>
                                    <th>PRECIO</th>
                                    <th colspan="2">Acciones</th>
                                </tr>
                                <c:forEach var="art" items="${requestScope.articulos}">
                                    <tr>
                                        <td>${art.id}</td>  
                                        <td>${art.nombre}</td>
                                        <td>${art.precio}</td>
                                        <td><a href="detalles?id=${art.id}">Detalles</a></td>
                                        <td><a href="addFavorito?id=${art.id}">+Favorito</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <p>No hay Artículos</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </section>
            <footer id="pie">
                &copy; Pablo Jesús Calvente Ramírez, 2020.webmaster:pablojesus.calvente@alu.uhu.es
            </footer>
        </div>
        <script src="ProyectoFinal/JS/JS.js" type="text/javascript"></script>
    </body>
</html>
