CREATE DATABASE prueba;
USE prueba;


CREATE TABLE usuarios (
    id_user INT(3) PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    contrasenia VARCHAR(50) NOT NULL
)  ENGINE=INNODB;

CREATE TABLE cartas (
    id_carta INT(5) PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) UNIQUE NOT NULL,
    tipo ENUM('tropa', 'estructura', 'hechizo'),
    calidad ENUM('comun', 'especial', 'epica', 'legendaria'),
    descripcion VARCHAR(100) NOT NULL
)  ENGINE=INNODB;

CREATE TABLE detalleCartas (
    id_user INT(3),
    id_carta INT(3),
    foto BLOB,
    elixir ENUM('1', '2', '3', '4', '5', '6', '7', '8', '9', '10'),
    hitpoints INT(5),
    velocidadAtaque INT(5),
    velocidadGeneracion INT(5),
    objetivo ENUM('tierra', 'aire', 'tierra y aire'),
    velocidad ENUM('baja', 'media', 'alta', 'muy alta'),
    alcance INT(5),
    CONSTRAINT fk_id FOREIGN KEY (id_user)
        REFERENCES usuarios (id_user)
)  ENGINE=INNODB;

CREATE TABLE desencriptacion (
    id_user INT(3) AUTO_INCREMENT,
    contrasenia_desen BLOB,
    CONSTRAINT fk_desen FOREIGN KEY (id_user)
        REFERENCES usuarios (id_user)
)  ENGINE=INNODB;


DELIMITER |
CREATE TRIGGER encriptar AFTER INSERT ON usuarios FOR EACH ROW
BEGIN

INSERT INTO desencriptacion VALUES(new.id_user,AES_ENCRYPT(new.contrasenia,'1234'));

END |
DELIMITER ;
