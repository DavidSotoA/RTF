
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        
    
    
    
        
    <form:form action="guardarProgramacion" method="post" modelAttribute="programacion">
        <div class ="row">               
            <div class="col-md-6">
                <table class="table">
                    <tbody>

                        <form:hidden path="idProgramacion"/>
                        <form:hidden path="sala"/>
                        <form:hidden path="pelicula"/>

                        <tr>
                            <td>hora:</td>       <!-- se podrian meter mas campos -->
                            <td><font color="black"> <form:input path="hora" /></font></td>
                        </tr>

                        <tr>
                    <td colspan="2" align="center"><button type="submit" class="btn btn-default">Guardar</button>
                    </tr>
                    <tbody>    

                </table>
            </div>
        </div>        
    </form:form>
    
</body>


</html>
