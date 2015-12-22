
-- CREATE TABLE sala(
-- idSala INT(10) AUTO_INCREMENT PRIMARY KEY,
-- nombreSala VARCHAR(45)
-- );

CREATE TABLE programacion(
idProgramacion INT(10) AUTO_INCREMENT,
sala VARCHAR(45) NOT NULL REFERENCES sala(nombreSala),
pelicula VARCHAR(45) NOT NULL REFERENCES pelicula(nombre),
hora VARCHAR(45),
PRIMARY KEY (idProgramacion,sala,pelicula) 
);

-- CREATE TABLE pelicula(
-- idPelicula INT(10) AUTO_INCREMENT PRIMARY KEY,
-- nombre VARCHAR(45)
-- );
-- 
-- INSERT INTO sala (nombreSala) VALUES ('sala_01');
-- INSERT INTO sala (nombreSala) VALUES ('sala_02');
-- 
-- INSERT INTO pelicula (nombre) VALUES ('Charlie_countryman');
-- INSERT INTO pelicula (nombre) VALUES ('Ghost_in_the_shell');
-- INSERT INTO pelicula (nombre) VALUES ('Oblivion');

-- INSERT INTO programacion (sala, pelicula, hora) VALUES ('sala_01','Charlie_countryman', '12:00_am');
-- INSERT INTO programacion (sala, pelicula, hora) VALUES ('sala_01','Ghost_in_the_shell', '10:00_pm');
-- INSERT INTO programacion (sala, pelicula, hora) VALUES ('sala_02','Charlie_countryman', '10:00_pm');
INSERT INTO programacion (sala, pelicula, hora) VALUES ('sala_02','Oblivion', '08:00_pm');
