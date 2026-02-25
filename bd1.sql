CREATE
DATABASE IF NOT EXISTS bd_vuelos
DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE bd_vuelos;

CREATE TABLE companias
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE aviones
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    modelo      VARCHAR(50),
    id_compania INT,
    FOREIGN KEY (id_compania) REFERENCES companias (id)
) ENGINE=InnoDB;

CREATE TABLE aeropuertos
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    ciudad VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE terminales
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    numero        INT,
    id_aeropuerto INT,
    FOREIGN KEY (id_aeropuerto) REFERENCES aeropuertos (id)
) ENGINE=InnoDB;

CREATE TABLE puertas
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    codigo      VARCHAR(10),
    id_terminal INT,
    FOREIGN KEY (id_terminal) REFERENCES terminales (id)
) ENGINE=InnoDB;

CREATE TABLE vuelos
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    codigo_vuelo VARCHAR(10),
    id_avion     INT,
    id_origen    INT,
    id_destino   INT,
    id_puerta    INT,
    hora_salida  DATETIME,
    hora_llegada DATETIME,
    FOREIGN KEY (id_avion) REFERENCES aviones (id),
    FOREIGN KEY (id_origen) REFERENCES aeropuertos (id),
    FOREIGN KEY (id_destino) REFERENCES aeropuertos (id),
    FOREIGN KEY (id_puerta) REFERENCES puertas (id)
) ENGINE=InnoDB;

INSERT INTO companias (nombre)
VALUES ('Iberia'),
       ('Ryanair'),
       ('Lufthansa'),
       ('Vueling'),
       ('Air France');

INSERT INTO aviones (modelo, id_compania)
VALUES ('Airbus A320', 1),
       ('Boeing 737', 2),
       ('A350-900', 3),
       ('Airbus A320neo', 4),
       ('Boeing 777', 5);

INSERT INTO aeropuertos (nombre, ciudad)
VALUES ('Barajas', 'Madrid'),
       ('El Prat', 'Barcelona'),
       ('Charles de Gaulle', 'Paris'),
       ('Frankfurt Airport', 'Frankfurt'),
       ('Heathrow', 'Londres');

INSERT INTO terminales (numero, id_aeropuerto)
VALUES (4, 1),
       (1, 2),
       (2, 3),
       (1, 4),
       (5, 5);

INSERT INTO puertas (codigo, id_terminal)
VALUES ('H12', 1),
       ('B23', 2),
       ('F01', 3),
       ('A10', 4),
       ('C55', 5);

INSERT INTO vuelos (codigo_vuelo, id_avion, id_origen, id_destino, id_puerta, hora_salida, hora_llegada)
VALUES ('LH1122', 3, 4, 1, 4, '2026-03-02 08:30:00', '2026-03-02 11:00:00'),
       ('VY2540', 4, 2, 3, 2, '2026-03-02 14:15:00', '2026-03-02 16:20:00'),
       ('AF4455', 5, 3, 2, 3, '2026-03-02 19:00:00', '2026-03-02 21:10:00'),
       ('IB500', 1, 1, 5, 1, '2026-03-03 07:00:00', '2026-03-03 09:30:00'),
       ('BA202', 2, 5, 2, 5, '2026-03-03 12:45:00', '2026-03-03 14:55:00'),
       ('IB3012', 1, 1, 2, 1, '2026-03-01 10:00:00', '2026-03-01 11:15:00'),
       ('RY8899', 2, 2, 1, 2, '2026-03-01 18:30:00', '2026-03-01 19:45:00');

CREATE VIEW vista_vuelos AS
SELECT v.id     AS id_vuelo,
       v.codigo_vuelo,
       c.nombre AS compania,
       a.modelo AS avion,
       o.ciudad AS ciudad_origen,
       d.ciudad AS ciudad_destino,
       t.numero AS terminal,
       p.codigo AS puerta,
       v.hora_salida,
       v.hora_llegada
FROM vuelos v
         JOIN aviones a ON v.id_avion = a.id
         JOIN companias c ON a.id_compania = c.id
         JOIN aeropuertos o ON v.id_origen = o.id
         JOIN aeropuertos d ON v.id_destino = d.id
         JOIN puertas p ON v.id_puerta = p.id
         JOIN terminales t ON p.id_terminal = t.id;