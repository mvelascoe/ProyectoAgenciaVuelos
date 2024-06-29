CREATE DATABASE Vuelos_globales;
USE Vuelos_globales;

CREATE TABLE flightconnection(
    id_trayectoria  INT AUTO_INCREMENT,
    trayectoria_numero VARCHAR(20) NOT NULL,
    id_trip INT,
    id_avion INT,
    id_aeropuerto VARCHAR(5), 
    PRIMARY KEY(id_trayectoria)
);

CREATE TABLE airport(
    id_aeropuerto VARCHAR(5) NOT NULL,
    nombre_aeropuerto VARCHAR(50) NOT NULL,
    id_ciudad VARCHAR(5),
    PRIMARY KEY(id_aeropuerto)
);

CREATE TABLE cities(
    id_ciudad VARCHAR(5) NOT NULL,
    nombre_ciudad VARCHAR(30),
    id_pais VARCHAR(5),
    PRIMARY KEY(id_ciudad)
);

CREATE TABLE country(
    id_pais VARCHAR(5) NOT NULL,
    nombre_pais VARCHAR(30)NOT NULL,
    PRIMARY KEY(id_pais)
);

CREATE TABLE gates(
    id_puerta INT AUTO_INCREMENT,
    numero_puerta INT NOT NULL,
    id_aeropuerto VARCHAR(5),
    PRIMARY KEY(id_puerta)
);

CREATE TABLE planes(
    id_avion INT AUTO_INCREMENT,
    matricula VARCHAR(30) NOT NULL,
    capacidad INT NOT NULL,
    fecha_fabricacion DATE NOT NULL,
    id_estado INT,
    id_modelo INT,
    PRIMARY KEY(id_avion)
);

CREATE TABLE models(
    id_modelo INT AUTO_INCREMENT,
    nombre_modelo VARCHAR(30),
    id_manufactura INT,
    PRIMARY KEY(id_modelo)
);

CREATE TABLE manufacturer(
    id_manufactura INT AUTO_INCREMENT,
    nombre_manufactura VARCHAR(40),
    PRIMARY KEY(id_manufactura)
);

CREATE TABLE statusA(
    id_estado INT AUTO_INCREMENT,
    nombre_estado VARCHAR(30) NOT NULL,
    PRIMARY KEY(id_estado)
);

CREATE TABLE revisions(
    id_revision INT AUTO_INCREMENT,
    fecha_revision DATE NOT NULL,
    id_avion INT,
    detalle text,
    PRIMARY KEY(id_revision)
);

CREATE TABLE revemployee(
    id_revi_empleado INT AUTO_INCREMENT,
    id_empleado VARCHAR(20),
    id_revision INT,
    id_revision_detalles INT,
    PRIMARY KEY(id_revi_empleado)
);


CREATE TABLE employee(
    id_empleado VARCHAR(20) NOT NULL,
    nombre_empleado VARCHAR(40),
    id_rol INT,
    fecha_ingreso DATE,
    id_aerolinea INT,
    id_aeropuerto VARCHAR(5),
    PRIMARY KEY(id_empleado)    
);

CREATE TABLE tripulation(
    id_tripulacion INT NOT NULL AUTO_INCREMENT,
    id_empleado VARCHAR(20),
    id_trayectoria INT,
    PRIMARY KEY(id_tripulacion)
);

CREATE TABLE rols(
    id_rol INT NOT NULL AUTO_INCREMENT,
    nombre_rol VARCHAR(40),
    PRIMARY KEY(id_rol)
);

CREATE TABLE airline(
    id_aerolinea INT NOT NULL AUTO_INCREMENT,
    nombre_aerolinea VARCHAR(40),
    PRIMARY KEY(id_aerolinea)
);

CREATE TABLE trip(
    id_trip INT NOT NULL AUTO_INCREMENT,
    precio DOUBLE,
    lugar_ida VARCHAR(50),
    lugar_llegada VARCHAR(50),
    PRIMARY KEY(id_trip)
);

CREATE TABLE tripboooking(
    id_trip_booking INT NOT NULL AUTO_INCREMENT,
    fecha_ticket DATE,
    id_trip INT,
    PRIMARY KEY(id_trip_booking)
);

CREATE TABLE tripbookingdetails(
    id_trip_booking_details INT AUTO_INCREMENT,
    id_trip_booking INT,
    id_cliente VARCHAR(20),
    id_tarifa INT,
    PRIMARY KEY(id_trip_booking_details)
);

CREATE TABLE flightfare(
    id_tarifa INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(20),
    detalles text,
    valor DOUBLE(7,3),
    PRIMARY KEY(id_tarifa)
);

CREATE TABLE costumer(
    id_cliente VARCHAR(20) not null,
    nombre_cliente VARCHAR(40),
    edad_cliente INT,
    id_documento INT,
    PRIMARY KEY(id_cliente)
);

CREATE TABLE documenttype(
    id_documento INT NOT NULL AUTO_INCREMENT,
    nombre_documento VARCHAR(40),
    PRIMARY KEY(id_documento)
);

CREATE TABLE flight_booking_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_trip INT,
    id_cliente VARCHAR(20),
    id_asiento INT,
    FOREIGN KEY (id_trip) REFERENCES trip(id_trip),
    FOREIGN KEY (id_cliente) REFERENCES costumer(id_cliente)
);


ALTER TABLE flightconnection
ADD CONSTRAINT fk_trayectoria_trip FOREIGN KEY (id_trip) REFERENCES trip(id_trip),
ADD CONSTRAINT fk_trayectoria_avion FOREIGN KEY (id_avion) REFERENCES planes(id_avion),
ADD CONSTRAINT fk_trayectoria_aeropuerto FOREIGN KEY (id_aeropuerto) REFERENCES airport(id_aeropuerto) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE cities
ADD CONSTRAINT fk_ciudad_pais FOREIGN KEY (id_pais) REFERENCES country(id_pais);

ALTER TABLE planes
ADD CONSTRAINT fk_aviones_estado FOREIGN KEY (id_estado) REFERENCES statusA(id_estado),
ADD CONSTRAINT fk_aviones_modelo FOREIGN KEY (id_modelo) REFERENCES models(id_modelo);

ALTER TABLE revisions
ADD CONSTRAINT fk_revisiones_avion FOREIGN KEY (id_avion) REFERENCES planes(id_avion);

ALTER TABLE revemployee
ADD CONSTRAINT fk_rev_empleado_empleado FOREIGN KEY (id_empleado) REFERENCES employee(id_empleado),
ADD CONSTRAINT fk_rev_empleado_revision FOREIGN KEY (id_revision) REFERENCES revisions(id_revision);


ALTER TABLE employee
ADD CONSTRAINT fk_empleado_rol FOREIGN KEY (id_rol) REFERENCES rols(id_rol),
ADD CONSTRAINT fk_empleado_aerolinea FOREIGN KEY (id_aerolinea) REFERENCES airline(id_aerolinea),
ADD CONSTRAINT fk_empleado_aeropuerto FOREIGN KEY (id_aeropuerto) REFERENCES airport(id_aeropuerto) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE tripulation
ADD CONSTRAINT fk_tripulacion_empleado FOREIGN KEY (id_empleado) REFERENCES employee(id_empleado),
ADD CONSTRAINT fk_tripulacion_trayectoria FOREIGN KEY (id_trayectoria) REFERENCES flightconnection(id_trayectoria);

ALTER TABLE tripboooking
ADD CONSTRAINT fk_tripbooking_ticket FOREIGN KEY (id_trip) REFERENCES trip(id_trip);

ALTER TABLE tripbookingdetails
ADD CONSTRAINT fk_tripbookingdetails_tripbooking FOREIGN KEY (id_trip_booking) REFERENCES tripboooking(id_trip_booking),
ADD CONSTRAINT fk_tripbookingdetails_cliente FOREIGN KEY (id_cliente) REFERENCES costumer(id_cliente),
ADD CONSTRAINT fk_tripbookingdetails_tarifa FOREIGN KEY (id_tarifa) REFERENCES flightfare(id_tarifa);


ALTER TABLE costumer
ADD CONSTRAINT fk_cliente_documento FOREIGN KEY (id_documento) REFERENCES documenttype(id_documento);

ALTER TABLE gates 
ADD CONSTRAINT FK_gatesairport 
FOREIGN KEY (id_aeropuerto) REFERENCES airport(id_aeropuerto) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE models
ADD CONSTRAINT FK_modelsmanufacturer
FOREIGN KEY(id_manufactura) REFERENCES manufacturer(id_manufactura);

ALTER TABLE airport ADD CONSTRAINT fk_aeropuerto_ciudad FOREIGN KEY (id_ciudad) REFERENCES cities(id_ciudad) ON DELETE RESTRICT ON UPDATE CASCADE;

INSERT INTO country (id_pais,nombre_pais) VALUES 
("P001","Estados Unidos"),
("P002","Canadá"),
("P003","Brasil"),
("P004","Reino Unido"),
("P005","Francia"),
("P006","Alemania"),
("P007","Japón"),
("P008","Australia"),
("P009","México"),
("P010","India");

INSERT INTO cities (id_ciudad,nombre_ciudad,id_pais) VALUES
("C001","Nueva York","P001"),
("C002","Los Ángeles","P001"),
("C003","Toronto","P002"),
("C004","Montreal","P002"),
("C005","São Paulo","P003"),
("C006","Río de Janeiro","P003"),
("C007","Londres","P004"),
("C008","Manchester","P004"),
("C009","París","P005"),
("C010","Marsella","P005"),
("C011","Berlín","P006"),
("C012","Múnich","P006"),
("C013","Tokio","P007"),
("C014","Osaka","P007"),
("C015","Sídney","P008"),
("C016","Melbourne","P008"),
("C017","Ciudad de México", "P009"),
("C018","Guadalajara","P009"),
("C019","Mumbai","P010"),
("C020","Nueva Delhi","P010");

INSERT INTO trip (id_trip, precio, lugar_ida, lugar_llegada) VALUES
(1, 250.00, 'Nueva York', 'Los Ángeles'),
(2, 300.00, 'Toronto', 'Montreal'),
(3, 150.00, 'São Paulo', 'Río de Janeiro'),
(4, 400.00, 'Londres', 'Manchester'),
(5, 200.00, 'París', 'Marsella'),
(6, 500.00, 'Berlín', 'Múnich'),
(7, 600.00, 'Tokio', 'Osaka'),
(8, 350.00, 'Sídney', 'Melbourne'),
(9, 180.00, 'Ciudad de México', 'Guadalajara'),
(10, 280.00, 'Mumbai', 'Nueva Delhi');

INSERT INTO statusA (id_estado, nombre_estado)
VALUES
    (1, 'Activo'),
    (2, 'En mantenimiento'),
    (3, 'En reparación'),
    (4, 'Fuera de servicio');

INSERT INTO manufacturer (id_manufactura, nombre_manufactura)
VALUES
    (1, 'Boeing'),
    (2, 'Airbus'),
    (3, 'Embraer'),
    (4, 'Bombardier');


INSERT INTO models (id_modelo, nombre_modelo, id_manufactura)
VALUES
    (101, 'Boeing 737', 1),
    (102, 'Airbus A320', 2),
    (103, 'Embraer E190', 3),
    (104, 'Bombardier CRJ900', 4);

INSERT INTO planes (id_avion,matricula, capacidad, fecha_fabricacion, id_estado, id_modelo)
VALUES
    (901,'ABC123', 180, '2015-10-15', 1, 101),
    (902,'DEF456', 220, '2018-04-25', 2, 102),
    (903,'GHI789', 100, '2017-12-03', 3, 103),
    (905,'JKL012', 150, '2016-08-20', 4, 104);

INSERT INTO revisions (fecha_revision, id_avion, detalle) VALUES 
    ('2023-01-10', 901, 'Revisión de mantenimiento programada'),
    ('2023-03-15', 901, 'Inspección de seguridad realizada'),
    ('2023-05-20', 905, 'Actualización de componentes internos');