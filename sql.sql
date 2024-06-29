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

CREATE TABLE trayecto_empleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    trayecto_id INT NOT NULL,
    empleado_id VARCHAR(20) NOT NULL,
    FOREIGN KEY (trayecto_id) REFERENCES flightconnection(id_trayectoria),
    FOREIGN KEY (empleado_id) REFERENCES employee(id_empleado)
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

INSERT INTO country (id_pais, nombre_pais) VALUES ('USA', 'United States');
INSERT INTO country (id_pais, nombre_pais) VALUES ('MEX', 'Mexico');
INSERT INTO country (id_pais, nombre_pais) VALUES ('CAN', 'Canada');
INSERT INTO country (id_pais, nombre_pais) VALUES ('ARG', 'Argentina');
INSERT INTO country (id_pais, nombre_pais) VALUES ('BRA', 'Brazil');


INSERT INTO cities (id_ciudad, nombre_ciudad, id_pais) VALUES ('NYC', 'New York', 'USA');
INSERT INTO cities (id_ciudad, nombre_ciudad, id_pais) VALUES ('MEX', 'Mexico City', 'MEX');
INSERT INTO cities (id_ciudad, nombre_ciudad, id_pais) VALUES ('TOR', 'Toronto', 'CAN');
INSERT INTO cities (id_ciudad, nombre_ciudad, id_pais) VALUES ('BUE', 'Buenos Aires', 'ARG');
INSERT INTO cities (id_ciudad, nombre_ciudad, id_pais) VALUES ('RIO', 'Rio de Janeiro', 'BRA');


INSERT INTO airport (id_aeropuerto, nombre_aeropuerto, id_ciudad) VALUES ('JFK', 'John F. Kennedy International Airport', 'NYC');
INSERT INTO airport (id_aeropuerto, nombre_aeropuerto, id_ciudad) VALUES ('MEX', 'Mexico City International Airport', 'MEX');
INSERT INTO airport (id_aeropuerto, nombre_aeropuerto, id_ciudad) VALUES ('YYZ', 'Toronto Pearson International Airport', 'TOR');
INSERT INTO airport (id_aeropuerto, nombre_aeropuerto, id_ciudad) VALUES ('EZE', 'Ezeiza International Airport', 'BUE');
INSERT INTO airport (id_aeropuerto, nombre_aeropuerto, id_ciudad) VALUES ('GIG', 'Galeão International Airport', 'RIO');


INSERT INTO statusA (id_estado, nombre_estado) VALUES (1, 'Operational');
INSERT INTO statusA (id_estado, nombre_estado) VALUES (2, 'Maintenance');
INSERT INTO statusA (id_estado, nombre_estado) VALUES (3, 'Grounded');
INSERT INTO statusA (id_estado, nombre_estado) VALUES (4, 'Retired');
INSERT INTO statusA (id_estado, nombre_estado) VALUES (5, 'Reserved');


INSERT INTO manufacturer (id_manufactura, nombre_manufactura) VALUES (1, 'Boeing');
INSERT INTO manufacturer (id_manufactura, nombre_manufactura) VALUES (2, 'Airbus');
INSERT INTO manufacturer (id_manufactura, nombre_manufactura) VALUES (3, 'Embraer');
INSERT INTO manufacturer (id_manufactura, nombre_manufactura) VALUES (4, 'Bombardier');
INSERT INTO manufacturer (id_manufactura, nombre_manufactura) VALUES (5, 'Cessna');


INSERT INTO models (id_modelo, nombre_modelo, id_manufactura) VALUES (1, '737', 1);
INSERT INTO models (id_modelo, nombre_modelo, id_manufactura) VALUES (2, 'A320', 2);
INSERT INTO models (id_modelo, nombre_modelo, id_manufactura) VALUES (3, 'E190', 3);
INSERT INTO models (id_modelo, nombre_modelo, id_manufactura) VALUES (4, 'CRJ700', 4);
INSERT INTO models (id_modelo, nombre_modelo, id_manufactura) VALUES (5, 'Citation X', 5);


INSERT INTO planes (id_avion, matricula, capacidad, fecha_fabricacion, id_estado, id_modelo) VALUES (1, 'N12345', 180, '2010-01-01', 1, 1);
INSERT INTO planes (id_avion, matricula, capacidad, fecha_fabricacion, id_estado, id_modelo) VALUES (2, 'N67890', 200, '2012-05-15', 1, 2);
INSERT INTO planes (id_avion, matricula, capacidad, fecha_fabricacion, id_estado, id_modelo) VALUES (3, 'N54321', 100, '2015-09-30', 1, 3);
INSERT INTO planes (id_avion, matricula, capacidad, fecha_fabricacion, id_estado, id_modelo) VALUES (4, 'N98765', 150, '2018-02-20', 1, 4);
INSERT INTO planes (id_avion, matricula, capacidad, fecha_fabricacion, id_estado, id_modelo) VALUES (5, 'N11223', 12, '2020-07-10', 1, 5);


INSERT INTO airline (id_aerolinea, nombre_aerolinea) VALUES (1, 'American Airlines');
INSERT INTO airline (id_aerolinea, nombre_aerolinea) VALUES (2, 'Delta Airlines');
INSERT INTO airline (id_aerolinea, nombre_aerolinea) VALUES (3, 'United Airlines');
INSERT INTO airline (id_aerolinea, nombre_aerolinea) VALUES (4, 'Air Canada');
INSERT INTO airline (id_aerolinea, nombre_aerolinea) VALUES (5, 'LATAM');


INSERT INTO rols (id_rol, nombre_rol) VALUES (1, 'Pilot');
INSERT INTO rols (id_rol, nombre_rol) VALUES (2, 'Co-Pilot');
INSERT INTO rols (id_rol, nombre_rol) VALUES (3, 'Flight Attendant');
INSERT INTO rols (id_rol, nombre_rol) VALUES (4, 'Ground Staff');
INSERT INTO rols (id_rol, nombre_rol) VALUES (5, 'Maintenance Technician');


INSERT INTO employee (id_empleado, nombre_empleado, id_rol, fecha_ingreso, id_aerolinea, id_aeropuerto) VALUES ('EMP001', 'John Doe', 1, '2015-06-01', 1, 'JFK');
INSERT INTO employee (id_empleado, nombre_empleado, id_rol, fecha_ingreso, id_aerolinea, id_aeropuerto) VALUES ('EMP002', 'Jane Smith', 2, '2016-07-15', 2, 'MEX');
INSERT INTO employee (id_empleado, nombre_empleado, id_rol, fecha_ingreso, id_aerolinea, id_aeropuerto) VALUES ('EMP003', 'Emily Johnson', 3, '2018-08-20', 3, 'YYZ');
INSERT INTO employee (id_empleado, nombre_empleado, id_rol, fecha_ingreso, id_aerolinea, id_aeropuerto) VALUES ('EMP004', 'Michael Brown', 4, '2019-09-30', 4, 'EZE');
INSERT INTO employee (id_empleado, nombre_empleado, id_rol, fecha_ingreso, id_aerolinea, id_aeropuerto) VALUES ('EMP005', 'Sarah Davis', 5, '2020-10-10', 5, 'GIG');


INSERT INTO trip (id_trip, precio, lugar_ida, lugar_llegada) VALUES (1, 500.00, 'New York', 'Mexico City');
INSERT INTO trip (id_trip, precio, lugar_ida, lugar_llegada) VALUES (2, 700.00, 'Toronto', 'Rio de Janeiro');
INSERT INTO trip (id_trip, precio, lugar_ida, lugar_llegada) VALUES (3, 450.00, 'Buenos Aires', 'New York');
INSERT INTO trip (id_trip, precio, lugar_ida, lugar_llegada) VALUES (4, 600.00, 'Mexico City', 'Toronto');
INSERT INTO trip (id_trip, precio, lugar_ida, lugar_llegada) VALUES (5, 800.00, 'Rio de Janeiro', 'Buenos Aires');


INSERT INTO flightconnection (id_trayectoria, trayectoria_numero, id_trip, id_avion, id_aeropuerto) VALUES (1, 'FC1001', 1, 1, 'JFK');
INSERT INTO flightconnection (id_trayectoria, trayectoria_numero, id_trip, id_avion, id_aeropuerto) VALUES (2, 'FC1002', 2, 2, 'YYZ');
INSERT INTO flightconnection (id_trayectoria, trayectoria_numero, id_trip, id_avion, id_aeropuerto) VALUES (3, 'FC1003', 3, 3, 'EZE');
INSERT INTO flightconnection (id_trayectoria, trayectoria_numero, id_trip, id_avion, id_aeropuerto) VALUES (4, 'FC1004', 4, 4, 'MEX');
INSERT INTO flightconnection (id_trayectoria, trayectoria_numero, id_trip, id_avion, id_aeropuerto) VALUES (5, 'FC1005', 5, 5, 'GIG');


INSERT INTO documenttype (id_documento, nombre_documento) VALUES (1, 'Passport');
INSERT INTO documenttype (id_documento, nombre_documento) VALUES (2, 'Driver License');
INSERT INTO documenttype (id_documento, nombre_documento) VALUES (3, 'National ID');
INSERT INTO documenttype (id_documento, nombre_documento) VALUES (4, 'Visa');
INSERT INTO documenttype (id_documento, nombre_documento) VALUES (5, 'Residence Permit');


INSERT INTO costumer (id_cliente, nombre_cliente, edad_cliente, id_documento) VALUES ('CUST001', 'Alice Johnson', 28, 1);
INSERT INTO costumer (id_cliente, nombre_cliente, edad_cliente, id_documento) VALUES ('CUST002', 'Bob Smith', 35, 2);
INSERT INTO costumer (id_cliente, nombre_cliente, edad_cliente, id_documento) VALUES ('CUST003', 'Carol Williams', 42, 3);
INSERT INTO costumer (id_cliente, nombre_cliente, edad_cliente, id_documento) VALUES ('CUST004', 'David Brown', 30, 4);
INSERT INTO costumer (id_cliente, nombre_cliente, edad_cliente, id_documento) VALUES ('CUST005', 'Eve Davis', 25, 5);


INSERT INTO tripboooking (id_trip_booking, fecha_ticket, id_trip) VALUES (1, '2023-01-15', 1);
INSERT INTO tripboooking (id_trip_booking, fecha_ticket, id_trip) VALUES (2, '2023-02-20', 2);
INSERT INTO tripboooking (id_trip_booking, fecha_ticket, id_trip) VALUES (3, '2023-03-25', 3);
INSERT INTO tripboooking (id_trip_booking, fecha_ticket, id_trip) VALUES (4, '2023-04-30', 4);
INSERT INTO tripboooking (id_trip_booking, fecha_ticket, id_trip) VALUES (5, '2023-05-05', 5);


INSERT INTO flightfare (id_tarifa, descripcion, detalles, valor) VALUES (1, 'Economy', 'Standard economy class', 200.000);
INSERT INTO flightfare (id_tarifa, descripcion, detalles, valor) VALUES (2, 'Premium Economy', 'Premium economy class', 350.000);
INSERT INTO flightfare (id_tarifa, descripcion, detalles, valor) VALUES (3, 'Business', 'Business class', 500.000);
INSERT INTO flightfare (id_tarifa, descripcion, detalles, valor) VALUES (4, 'First', 'First class', 800.000);
INSERT INTO flightfare (id_tarifa, descripcion, detalles, valor) VALUES (5, 'Basic Economy', 'Basic economy class', 150.000);


INSERT INTO tripbookingdetails (id_trip_booking_details, id_trip_booking, id_cliente, id_tarifa) VALUES (1, 1, 'CUST001', 1);
INSERT INTO tripbookingdetails (id_trip_booking_details, id_trip_booking, id_cliente, id_tarifa) VALUES (2, 2, 'CUST002', 2);
INSERT INTO tripbookingdetails (id_trip_booking_details, id_trip_booking, id_cliente, id_tarifa) VALUES (3, 3, 'CUST003', 3);
INSERT INTO tripbookingdetails (id_trip_booking_details, id_trip_booking, id_cliente, id_tarifa) VALUES (4, 4, 'CUST004', 4);
INSERT INTO tripbookingdetails (id_trip_booking_details, id_trip_booking, id_cliente, id_tarifa) VALUES (5, 5, 'CUST005', 5);



