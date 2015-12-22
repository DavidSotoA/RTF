
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />        

        <title>cineUdeA</title>

        <c:url var="home" value="/" scope="request" />

        <script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
        <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>
        <script type="text/javascript">

            $(document).ready(function () {              // crea un objeto jQuery en este documento y ejecuta la funcion cuando el documento este preparado

                $('#formulario').submit(function (e) {
                    $.ajax({
                    url: $("#formulario").attr("action"),
                            type: "post",
                            cache: false,
                            data: 'id=' + $("#idProg").val() + "&sala;=" + $("#sal").val() + "&pelicula;=" + $("#peli").val() + "&hora;=" + $("#hor").val(),
                            success: function (response) {
                                $('#Success').html("holi");
                                /*
                                 var obj = JSON.parse(response);
                                 $('#Success').html("id:- " + obj.id + "</br>sala:- " + obj.sala + "</br>pelicula- " + obj.pelicula + "</br>hora- " + obj.hora);*/
                            },
                            error: function () {
                                alert('Error while request..');
                            });
                });
            });

        </script>

    </head>
    <body>


    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" <a href="<c:url value="/home"/>">Inicio</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${user == 'anonymousUser'}">
                        <li><a href="<c:url value="/iniciarSesion" />">Iniciar sesion</a></li>
                        <li><a href="<c:url value="/registrarse" />">Registrarse</a></li>

                    </c:if>
                    <c:if test="${user != 'anonymousUser'}">
                        <li> <p class="navbar-text">${info.nombre}</p></li>
                        <li><a href="<c:url value="/logout" />">Cerrar sesion</a></li>
                        </c:if>
                </ul>

                <ul class="nav navbar-nav">
                    <li><a href="<c:url value="/cartelera" />">Cartelera</a></li>
                    <li><a href="<c:url value="/confiteria" />">Confiteria</a></li>
                    <li><a href="<c:url value="/estrenos" />">Estrenos</a></li>

                    <c:if test="${(rol == 'ROLE_SOCIO')}">
                        <li><a href="<c:url value="/socio/comprarBoletos" />">Comprar boletas</a></li>
                        </c:if>

                    <c:if test="${(rol == 'ROLE_SOCIO') || (rol == 'ROLE_OPERARIO')}">
                        <li><a href="<c:url value="/redimir" />">Redimir puntos</a></li>
                        </c:if>

                    <c:if test="${(rol == 'ROLE_OPERARIO')}">
                        <li><a href="<c:url value="/operario/venderBoletos" />">Vender boletas</a></li>
                        <li><a href="<c:url value="/operario/emitirTarjetas" />">Emitir tarjetas de membresia</a></li>
                        <li><a href="<c:url value="/operario/cancelarTarjetas" />">Cancelar tarjetas de membresia</a></li>
                        </c:if>

                    <c:if test="${(rol == 'ROLE_FUNCIONARIO')}">
                        <li><a href="<c:url value="/funcionario/gestionarSalas" />">Gestion de salas</a></li>
                        <li><a href="<c:url value="/funcionario/gestionarEventos" />">Gestion de eventos</a></li>
                        <li><a href="<c:url value="/funcionario/consultarBoletas" />">Consultar reserva de boletas</a></li>
                        <li><a href="<c:url value="/funcionario/encuestas" />">Encuestas</a></li>
                        <li><a href="<c:url value="/funcionario/gestionar_cartelera" />">Programacion</a></li>            
                        </c:if>
                </ul>
            </div>
        </div>

    </nav>

    <form:form    id="formulario" action="${pageContext.request.contextPath}/funcionario/gestionar_cartelera/nuevaProgramacion" modelAttribute="programacion" method="post"> >
        <div class ="row">               
            <div class="col-md-6">
                <table class="table">

                    <tbody>

                        <%--<form:hidden path="idProgramacion"/>--%> 


                        <tr>                
                            <td>id:</td>       
                            <td><font color="black"> 
                                    <form:input id="idProg" path="idProgramacion"  type="text" required="true"/>
                                </font></td>
                        </tr>

                        <tr>
                            <td>Sala:</td>       
                            <td><font color="black">
                                    <form:input  id="sal" path="sala"  type="text" required="true"/>
                                </font></td>
                        </tr>

                        <tr>
                            <td>Pelicula:</td>       
                            <td><font color="black"> 
                                    <form:input id="peli" path="pelicula" type="text" required="true"/>
                                </font></td>
                        </tr>

                        <tr>
                            <td>Hora:</td>      
                            <td><font color="black">
                                    <form:input id="hor" path="hora" type="text" required="true"/>
                                </font></td>
                        </tr>

                        <tr>
                            <td colspan="2" align="center"><button type="submit" class="btn btn-default">Guardar</button>
                        </tr>
                    <tbody>    
                </table>
            </div>
        </div>        
    </form:form>
    <div id="Success"></div>  
</body>
</html>
