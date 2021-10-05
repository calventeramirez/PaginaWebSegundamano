<%-- 
    Document   : valoraciones
    Created on : 05-feb-2021, 11:42:25
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
                    <p>Media de valoraciones: ${media}</p>
                    <br/><br/>
                    
                    <p>Lo que más a gustado ha sido:</p>
                    <br/><br/>
                    <p>El diseño: ${diseno}</p>
                    
                    <br/>
                    <p>La funcionalidad: ${funcionalidad}</p>
                    
                    <br/>
                    <p>La idea: ${idea} </p>
                    
                    <br/><br/>
                </div>
                
            </section>

            <footer id="pie">        
                &copy; Pablo Jesús Calvente Ramírez, 2020-2021.webmaster:pablojesus.calvente@alu.uhu.es
            </footer>
        </div>
        <script src="JS/JS.js" type="text/javascript"></script>
    </body>
</html>
