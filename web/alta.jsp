<%-- 
    Document   : alta
    Created on : 20-ene-2021, 18:00:12
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
                <form id ="f2" action="/ProyectoFinal/usuario/crearUsuario" onsubmit="return validarUsuario();" method = "POST">
                    <div id ="msgForm"></div>
                    <fieldset>
                        <legend>Formulario</legend>
                        <fieldset>
                            <legend>Login</legend>
                            <!--Correo Electronico Requerido-->
                            <label for="correo">Correo Electronico:*</label>
                            <input type="email" id="correo" name="correo" required /> 
                            <span id="spanCorreo"></span>
                            <br />
                            <!--Contraseña (Obligatorio)-->
                            <label for="clave">Contraseña:*</label>
                            <input type="password" id="clave" name="clave"  required />
                            <span id="spanClave"></span>
                            <br />
                            <!--Repetir Clave(obligatorio)-->
                            <label for="clave2">Repetir Contraseña:*</label>
                            <input type="password" id="clave2" name="clave2"  required /> 
                            <span id="spanClave2"></span>
                            <br />
                        </fieldset>
                        <fieldset>
                            <legend>Datos Personales</legend>
                            <!--Nombre (obligatorio)-->
                            <label for="nombre">Nombre Completo:*</label>
                            <input type="text" id="nombre" name="nombre" required />
                            <span id="spamNombre"></span>
                            <br />
                            <!--Dirección-->
                            <label for="direccion">Dirección:</label>
                            <input type="text" id="direccion" name="direccion"  /> 
                            <br />
                            <!--Codigo Postal-->
                            <label for="codpostal">Codigo Postal:*</label>
                            <input type="text" id="codpostal" name="codpostal"  required /> 
                            <span id="spancodPostal"></span>
                            <br />                             
                            <!--Facebook-->
                            <label for="facebook">Facebook:</label>
                            <input type="url" name="facebook"  />
                            <br />
                            <!--Twitter-->
                            <label for="twitter">Twitter:</label>
                            <input type="url" name="twitter"  /> 
                            <br />
                            <!--Telefono de contacto-->
                            <label for="telefono">Telefono de Contacto:</label>
                            <input type="tel" id="telefono" name="telefono"   /> 
                            <br />
                        </fieldset> 
                    </fieldset>
                    <input class="botonform" type="submit" value="Enviar" />
                    <input class="botonform" type="reset" value="Borrar" /> 
                </form>
                <script src="JS/JS.js" type="text/javascript"></script>
            </section>
            <footer id="pie">
                &copy; Pablo Jesús Calvente Ramírez, 2020-2021.webmaster:pablojesus.calvente@alu.uhu.es
            </footer>
        </div>
    </body>
</html>
