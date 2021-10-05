/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var xhr;

function init_ajax(){
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }   
    
}


function filtrar() {

    init_ajax();
    
    var url = "/ProyectoFinal/articulos/filtro";
    xhr.open("POST", url, true);
    xhr.onreadystatechange = articulosFiltrados;

    var categoria = document.getElementById("categoria");
    var codpost = document.getElementById("codpostal");
    var pmenor = document.getElementById("pmenor");
    var pmayor = document.getElementById("pmayor");
    
    var datos = "categoria=" + encodeURIComponent(categoria.value) +
            "&codpostal"+encodeURIComponent(codpost.value)+
            "&pmenor=" + encodeURIComponent(pmenor.value) +
            "&pmayor=" + encodeURIComponent(pmayor.value);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(datos);

}

function articulosFiltrados() {
    if (xhr.readyState == 4) {
        if (xhr.status == 200) {
            document.getElementById("respuesta").innerHTML = xhr.responseText;
        }
    }

}


function validarArticulo()
{

    var nombre = document.getElementById("spanNombre");
    var categoria = document.getElementById("spanCategoria");
    var estado = document.getElementById("spanEstado");
    var precio = document.getElementById("spanPrecio");

    nombre.innerHTML = "";
    categoria.innerHTML = "";
    estado.innerHTML = "";
    precio.innerHTML = "";

    var msgForm = document.getElementById("msgForm");
    msgForm.innerHTML = "";
    let p = document.createElement("p");
    let tp = document.createTextNode("Inserte correctamente la siguiente información: ");
    p.appendChild(tp);
    let ul = document.createElement("ul");
    var ok = "true";

    var f = document.getElementById("f");
    if (f.nombre.value === "") {
        ok = false;
        nombre.innerHTML = "Nombre Requerido: Inserte Nombre";
        let li1 = document.createElement("li");
        let tl1 = document.createTextNode("Nombre");
        li1.appendChild(tl1);
        ul.appendChild(li1);
    };
    if (f.categoria.value === "") {
        ok = false;
        categoria.innerHTML = "Categoria Requerida: Inserte Categoria";
        let li2 = document.createElement("li");
        let tl2 = document.createTextNode("Categoria");
        li1.appendChild(tl2);
        ul.appendChild(li2);
    };
    if (f.estado.value === "") {
        ok = false;
        estado.innerHTML = "Estado Requerido: Inserte Estado";
        let li3 = document.createElement("li");
        let tl3 = document.createTextNode("Estado");
        li1.appendChild(tl3);
        ul.appendChild(li3);
    };
    if (f.precio.value === "") {
        ok = false;
        precio.innerHTML = "Precio Requerido: Inserte Precio";
        let li4 = document.createElement("li");
        let tl4 = document.createTextNode("Precio");
        li1.appendChild(tl4);
        ul.appendChild(li4);
    };
    if (!ok) {
        let msg = document.getElementById("msgForm");
        msg.appendChild(p);
        msg.appendChild(ul);
        msgForm.style.display = "block";
    };
    return ok;
}

function validarUsuario()
{
    var nombre = document.getElementById("spanNombre");
    var correo = document.getElementById("spanCorreo");
    var clave = document.getElementById("spanClave");
    var clave2 = document.getElementById("spanClave2");
    var codpostal = document.getElementById("spancodPostal");

    nombre.innerHTML = "";
    correo.innerHTML = "";
    clave.innerHTML = "";
    clave2.innerHTML = "";
    codpostal.innerHTML = "";

    var msgForm = document.getElementById("msgForm");
    msgForm.innerHTML = "";
    let p = document.createElement("p");
    let tp = document.createTextNode("Inserte correctamente la siguiente información: ");
    p.appendChild(tp);
    let ul = document.createElement("ul");
    var ok = "true";

    var f2 = document.getElementById("f2");
    if (f2.nombre.value === "") {
        ok = false;
        nombre.innerHTML = "Nombre Requerido: Inserte Nombre";
        let li1 = document.createElement("li");
        let tl1 = document.createTextNode("Nombre");
        li1.appendChild(tl1);
        ul.appendChild(li1);
    };
    if (f2.correo.value === "") {
        ok = false;
        correo.innerHTML = "Email Requerido: Inserte Email";
        let li2 = document.createElement("li");
        let tl2 = document.createTextNode("Correo");
        li1.appendChild(tl2);
        ul.appendChild(li2);
    };
    if (f2.clave.value === "") {
        ok = false;
        clave.innerHTML = "Clave Requerido: Inserte Clave";
        let li3 = document.createElement("li");
        let tl3 = document.createTextNode("Clave");
        li1.appendChild(tl3);
        ul.appendChild(li3);
    };
    if (f2.clave2.value === "") {
        ok = false;
        clave2.innerHTML = "Reetir CLvae Requerido: Inserte Clave";
        let li4 = document.createElement("li");
        let tl4 = document.createTextNode("Clave");
        li1.appendChild(tl4);
        ul.appendChild(li4);
    };

    if (f2.codpostal.value === "") {
        ok = false;
        codpostal.innerHTML = "Codigo postal Requerido: Inserte Codigo postal";
        let li5 = document.createElement("li");
        let tl5 = document.createTextNode("Codigo postal");
        li1.appendChild(tl5);
        ul.appendChild(li5);
    };

    if (f2.clave.value !== f2.clave2.value) {
        ok = false;
        clave.innerHTML = "Las claves no coinciden. Repita las claves";
        let li6 = document.createElement("li");
        let tl6 = document.createTextNode("Clave");
        li1.appendChild(tl6);
        ul.appendChild(li6);
    };

    if (!ok) {
        let msg = document.getElementById("msgForm");
        msg.appendChild(p);
        msg.appendChild(ul);
        msgForm.style.display = "block";
    };
    return ok;
}



function validarValoracion()
{
    var valoracion = document.getElementById("spanValoracion");

    valoracion.innerHTML="";
    
    var msgForm = document.getElementById("msgForm");
    msgForm.innerHTML = "";
    let p = document.createElement("p");
    let tp = document.createTextNode("Inserte correctamente la siguiente información: ");
    p.appendChild(tp);
    let ul = document.createElement("ul");
    var ok = "true";
    
    var f10 = document.getElementById("f10");
    if (f10.valoracion.value === "") {
        ok = false;
        valoracion.innerHTML = "Valoración Requerida: Inserte Valoración";
        let li1 = document.createElement("li");
        let tl1 = document.createTextNode("Valoración");
        li1.appendChild(tl1);
        ul.appendChild(li1);
    };
    
     if (f10.valoracion.value > 10 ||f10.valoracion.value <0) {
        ok = false;
        valoracion.innerHTML = "Valoración Requerida: Inserte Valoración Correctamente";
        let li1 = document.createElement("li");
        let tl1 = document.createTextNode("Valoración");
        li1.appendChild(tl1);
        ul.appendChild(li1);
    };
    
    if (!ok) {
        let msg = document.getElementById("msgForm");
        msg.appendChild(p);
        msg.appendChild(ul);
        msgForm.style.display = "block";
    };
    return ok;
    
}