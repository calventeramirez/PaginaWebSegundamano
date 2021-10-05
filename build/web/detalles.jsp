<%-- 
    Document   : detalles
    Created on : 24-ene-2021, 20:03:34
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

                <h1>Detalles del Artículo</h1>
                <p>Id: ${requestScope["articulo"].id}</p>
                <p>Nombre: ${requestScope["articulo"].nombre}</p>
                <p>Categoria: ${requestScope["articulo"].categoria}</p>
                <p>Descripcion: ${requestScope["articulo"].descripcion}</p>
                <p>Estado: ${requestScope["articulo"].estado}</p>
                <p>Fecha: ${requestScope["articulo"].fecha}</p>
                <p>Precio: ${requestScope["articulo"].precio}</p>

                <br/>
                <br/>
                <br/>
                <c:choose>
                    <c:when test="${sessionScope.logueado!=null}">
                        <form action="/ProyectoFinal/comentarios/comentar" method="POST">    
                            <textarea name="texto" row="10" cols="40" />Escribe aquí tu comentario</textarea> <br />
                            <select name="visibilidad" required>
                                <option disabled selected value> -- Seleccione una opción -- </option>
                                <option>Publico</option>
                                <option>Privado</option>
                                <option>Vendedor</option>
                            </select><br />
                            <label for="id">Referencia del Articulo</label>
                            <input name="id" id="id" type="text" value="${requestScope["articulo"].id}" readonly>
                            <input class="botonform" type="submit" value="Enviar" />
                        </form>
                    </c:when>
                </c:choose>
                <br/>
                <br/>
                <c:choose>
                    <c:when test="${sessionScope.logueado!=null}">
                        <!--Aqui los comentarios privados y de vendedor-->

                        <c:choose>
                            <c:when test="${!empty requestScope.listaPrivada}">
                                <table>
                                    <tr>
                                        <th>Codigo del Usuario</th>
                                        <th>Nombre</th>
                                        <th>Comentario</th>
                                        <th>Tipo de Comentario</th>
                                    </tr>
                                    <c:forEach var="cpriv" items="${requestScope.listaPrivada}">
                                        <tr>
                                            <td>${cpriv.user.getId()}</td> 
                                            <td>${cpriv.user.getNombre()}</td>
                                            <td>${cpriv.texto}</td>   
                                            <td>${cpriv.visibilidad}</td> 
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${!empty requestScope.listaVendedor}">
                                <table>
                                    <tr>
                                        <th>Codigo del Usuario</th>
                                        <th>Nombre</th>
                                        <th>Comentario</th>
                                        <th>Tipo de Comentario</th>
                                    </tr>
                                    <c:forEach var="cvend" items="${requestScope.listaVendedor}">
                                        <tr>
                                            <td>${cvend.user.getId()}</td>
                                            <td>${cvend.user.getNombre()}</td>
                                            <td>${cvend.texto}</td>  
                                            <td>${cvend.visibilidad}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${!empty requestScope.listaPublica}">
                                <table>
                                    <tr>
                                        <th>Codigo del Usuario</th>
                                        <th>Nombre</th>
                                        <th>Comentario</th>
                                        <th>Tipo de Comentario</th>
                                    </tr>
                                    <c:forEach var="cpub" items="${requestScope.listaPublica}">
                                        <tr>
                                            <td>${cpub.user.getId()}</td>
                                            <td>${cpub.user.getNombre()}</td>
                                            <td>${cpub.texto}</td>   
                                            <td>${cpub.visibilidad}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:when>
                            <c:otherwise>
                                <p>No hay Comentarios</p>
                            </c:otherwise>
                        </c:choose>
                    </c:when>

                    <c:otherwise> 
                        <c:choose>
                            <c:when test="${!empty requestScope.listaPublica}">
                                <table>
                                    <tr>
                                        <th>Codigo del Usuario</th>
                                        <th>Nombre</th>
                                        <th>Comentario</th>
                                        <th>Tipo de Comentario</th>
                                    </tr>
                                    <c:forEach var="cpub" items="${requestScope.listaPublica}">
                                        <tr>
                                            <td>${cpub.user.getId()}</td>
                                            <td>${cpub.user.getNombre()}</td>
                                            <td>${cpub.texto}</td>   
                                            <td>${cpub.visibilidad}</td>      
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:when>
                            <c:otherwise>
                                <p>No hay Comentarios</p>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </section>
            <footer id="pie">
                &copy; Pablo Jesús Calvente Ramírez, 2020-2021.webmaster:pablojesus.calvente@alu.uhu.es
            </footer>
        </div>
        <script src="JS/JS.js" type="text/javascript"></script>
    </body>
</html>
