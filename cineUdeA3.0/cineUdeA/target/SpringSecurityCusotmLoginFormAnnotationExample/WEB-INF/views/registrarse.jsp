<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        
        <strong><font color="red">ZONA PUBLICA PARA USUARIOS NO REGISTRADOS</font></strong>
            <div class="login-container">
                <div class="login-card">
                    <form role="form">
                        <div class="form-group">
                            <label for="nombre">Nombre*</label>
                            <input class="form-control" id="ejemplo_email_1" placeholder="escribe tu nombre">
                        </div>
                        <div class="form-group">
                            <label for="apellidos">Apellidos*</label>
                            <input class="form-control" id="ejemplo_password_1" placeholder="escribe tu apellido">
                        </div>

                        <div class="form-group">
                            <label for="cedula">Cedula*</label>
                            <input class="form-control" id="ejemplo_password_1" placeholder="escribe tu cedula">
                        </div>

                        <div class="form-group">
                            <label for="password">Contraseña*</label>
                            <input type="password" class="form-control" id="ejemplo_password_1" placeholder="escribe tu contraseña">
                        </div>

                        <div class="form-group">
                            <label for="confirmPassword">Repetir Contraseña*</label>
                            <input type="password" class="form-control" id="ejemplo_password_1" placeholder="Repite tu contraseña">
                        </div>

                        <div class="form-group">
                            <label for="email">Correo electronico*</label>
                            <input type="email" class="form-control" id="ejemplo_password_1" placeholder="escribe tu correo electronico">
                        </div>

                        <div class="form-group">
                            <label for="direccion">Direccion*</label>
                            <input class="form-control" id="ejemplo_password_1" placeholder="escirbe tu direccion ">
                        </div>

                        <div class="form-group">
                            <label for="telefono">Telefono*</label>
                            <input class="form-control" id="ejemplo_password_1" placeholder="escribe tu telefono ">
                        </div>

                        <div class="form-group">
                            <label for="tarjetaDeCredito">Tarjeta de credito</label>
                            <input class="form-control" id="ejemplo_password_1" placeholder="ingresa el numero de tu tarjeta de credito ">
                        </div>

                        <button type="submit" class="btn btn-default">Enviar</button>
                        
                    </form>
                </div>
            </div>
    </body>
</html>