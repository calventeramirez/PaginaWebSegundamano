<%-- 
    Document   : index
    Created on : 20-ene-2021, 17:32:56
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
                    <p>Bienvenido a la tienda de productos de Segunda Mano</p>
                    <p>En esta pagina encontraras un sinfin de articulos en el cual tú o cualquier persona puede comprar a otra persona.</p>
                    <p>Si tienes algo que no uses solo registrate y alguien que quiera tu producto te lo comprará.</p>
                </div>
                <c:choose>
                    <c:when test="${sessionScope.logueado!=null}">
                        <div class="login" style="text-align: center;">
                            <table>
                                <tr>
                                    <td>
                                        <c:if test="${requestScope.msg!=null}"><p>${requestScope.msg}</p></c:if>
                                        <c:if test="${sessionScope.logueado!=null}"> Hola ${sessionScope.logueado}</c:if>
                                            <br/><a href="/ProyectoFinal/usuario/logout">Desconectar</a>
                                        </td>
                                    </tr>
                                </table> 
                            </div>
                    </c:when>
                    <c:otherwise> 
                        <div class="login">

                            <table>
                                <p>Login</p>
                                <tr>
                                    <td>
                                        <c:if test="${requestScope.msg!=null}"><p>${requestScope.msg}</p></c:if>
                                            <form action="/ProyectoFinal/usuario/login" method="post">
                                                <label for="correo">Usuario: </label>
                                                <input id="correo" type="text" name="correo" required />
                                                <label for="clave">Contraseña: </label>
                                                <input id="clave" type="password" name="clave"  required />  
                                                <input type="submit" class="botonform" value="Login" />
                                                <a href="/ProyectoFinal/usuario/alta">Registrarse</a>
                                            </form>
                                        </td>
                                    </tr>
                                </table> 
                            </div>
                    </c:otherwise>
                </c:choose>
            </section>

            <footer id="pie">
                <c:choose>
                   <c:when test="${sessionScope.logueado!=null}">
                        <form id="f10" method ="POST" onsubmit="return validarValoracion();" action="/ProyectoFinal/valoracion/mandarInformacion">
                            <div id="msgForm"></div>
                            <label for="valoracion">Valoración(0-10): </label>
                            <input id="valoracion" type="text" name="valoracion" required />
                            <span id="spanValoracion"></span>
                            <br/>
                            <label for="diseno">¿Que te gusta mas sobre el diseño: </label>
                            <select name="diseno" required>
                                <option>Diseno</option>
                                <option>Funcionalidad</option>
                                <option>Idea</option>
                            </select>    
                            <br/>
                            <input type="submit" class="botonform" value="Enviar Valoracion" />
                        </form>
                    </c:when>
                </c:choose>
                &copy; Pablo Jesús Calvente Ramírez, 2020-2021.webmaster:pablojesus.calvente@alu.uhu.es
            </footer>
        </div>
        <script src="JS/JS.js" type="text/javascript"></script>
    </body>
</html>
