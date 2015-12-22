CREATE  TABLE users (
  apellidos VARCHAR(45) NOT NULL ,
  cedula VARCHAR(45) NOT NULL ,
  contrasena VARCHAR(45) NOT NULL ,
  correoElectronico VARCHAR(45) NOT NULL ,
  direccion VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  nombre VARCHAR(45) NOT NULL ,
  puntos int,
  tarjetaDeCredito VARCHAR(45),
  telefono VARCHAR(45) NOT NULL ,
  PRIMARY KEY (cedula));

CREATE TABLE user_roles (
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY uni_username_role (role,username),
  FOREIGN KEY (username) REFERENCES users (cedula));

INSERT INTO users(apellidos,cedula,contrasena,correoElectronico,direccion,enabled,nombre,puntos,tarjetaDeCredito,telefono)
VALUES ('soto','1040743153', '123456', 'davidsoto17011@hotmail.com','cra45', true,'David',220,'000000','2780898');

INSERT INTO users(apellidos,cedula,contrasena,correoElectronico,direccion,enabled,nombre,telefono)
VALUES ('Otalvaro','1040743155', '123456', 'edwin@hotmail.com','cra48', true,'Edwin','2780988');

INSERT INTO users(apellidos,cedula,contrasena,correoElectronico,direccion,enabled,nombre,telefono)
VALUES ('Morales','1230743155', '123456', 'richard@hotmail.com','cra56', true,'Richard','2340988');

INSERT INTO user_roles (username, role)
VALUES ('1040743153', 'ROLE_SOCIO');
INSERT INTO user_roles (username, role)
VALUES ('1040743155', 'ROLE_OPERARIO');
INSERT INTO user_roles (username, role)
VALUES ('1230743155', 'ROLE_FUNCIONARIO');