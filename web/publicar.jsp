<%-- 
    Document   : publicar
    Created on : 21-ene-2021, 1:11:14
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
                <form id ="f" action="/ProyectoFinal/articulos/publicar" onsubmit="return validarUsuario();" method = "POST" >
                    <fieldset>
                        <legend>Formulario</legend>
                        <fieldset>
                            <div id="msgForm"></div>
                            <legend>Articulo</legend>
                            <!--Nombre Articulo Requerido-->
                            <label for="nombre">Nombre del Articulo:*</label>
                            <input type="text" id="nombre" name="nombre" required /> 
                            <span id="spanNombre"></span>
                            <br />
                            <!--Categoria Requerido-->
                            <label for="categoria">Categoria:*</label>
                            <select name="categoria" required>
                                <option>Electronica</option>
                                <option>Lectura</option>
                                <option>Juegos</option>
                                <option>Otros</option>
                            </select>                           
                            <span id="spanCategoria"></span>
                            <br />
                            <!--Descripción-->
                            <label for="descripcion">Descripción:</label><br />
                            <textarea id="decripcion" name="descripcion" rows="10" cols="100" style="width: 853px; height: 130px;" ></textarea> <br />
                            <!--Estado-->
                            <label for="estado">Estado:*</label>
                            <select name="estado" required>
                                <option>Nuevo</option>
                                <option>Seminuevo</option>
                                <option>Deteriorado</option>
                                <option>Antiguo</option>
                            </select> 
                            <span id="spanEstado"></span>
                            <br />
                            <!--Año de la Adquisicion-->
                            <label for="fecha">Año de la adquisición:</label>
                            <input type="date" id="fecha" name="fecha">
                            <br/>
                            <!-- Precio de venta Requerido -->
                            <label for="precio">Precio del Articulo:*</label>
                            <input type="text" id="precio" name="precio" required />
                            <span id="spanPrecio"></span>
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
