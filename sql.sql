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
    id_pais VARCHAR(5) NOT NULL AUTO_INCREMENT,
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
    PRIMARY KEY(id_revision)
);

CREATE TABLE revemployee(
    id_revi_empleado INT AUTO_INCREMENT,
    id_empleado VARCHAR(20),
    id_revision INT,
    id_revision_detalles INT,
    PRIMARY KEY(id_revi_empleado)
);

CREATE TABLE revdetailes(
    id_revision_detalles INT AUTO_INCREMENT,
    detalles text,
    PRIMARY KEY(id_revision_detalles)
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
    detalLes text,
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
ADD CONSTRAINT fk_rev_empleado_revision FOREIGN KEY (id_revision) REFERENCES revisions(id_revision),
ADD CONSTRAINT fk_rev_empleado_revision_detalles FOREIGN KEY (id_revision_detalles) REFERENCES revdetailes(id_revision_detalles);


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
FOREIGN KEY (id_aeropuerto) REFERENCES Vuelos_globales.airport(id_aeropuerto) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE models
ADD CONSTRAINT FK_modelsmanufacturer
FOREIGN KEY(id_manufactura) REFERENCES manufacturer(id_manufactura);

ALTER TABLE airport ADD CONSTRAINT fk_aeropuerto_ciudad FOREIGN KEY (id_ciudad) REFERENCES cities(id_ciudad) ON DELETE RESTRICT ON UPDATE CASCADE;

