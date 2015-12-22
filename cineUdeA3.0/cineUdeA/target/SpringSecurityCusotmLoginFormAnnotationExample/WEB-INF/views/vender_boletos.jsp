<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>cineUdeA</title>
        <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
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
                            <li> <p class="navbar-text">Registrarse</p></li>

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
                             </c:if>
                    </ul>
                </div>
            </div>
        </nav>
	<strong><font color="red">ZONA PARA OPERARIOS</font></strong>
</body>
</html>