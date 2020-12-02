/************************************************
 *      BASE DE DATOS Sistema De Administración *
 *       De Inventario De Equipo De Préstamo    *
 *       De Laboratorios                        *
 *                                              *
 *      Archivo de Definicion de Datos (DDL)    *
 ***********************************************/
 
 /*
    Version:        1.1
    Fecha:          28/11/2020 14:00 
    Autor:          Maria Dolores Espinosa Valdez
    Email:          lolis.ev49@gmail.com
    Comentarios:    Esta es la primera version de la base de datos
                    con las instrucciones necesarias para
                    generar las tablas.
                    
                    02/12/2020 - Se cambio el estatus de la herramienta a 
                    tipo entero y se definieron sus significados segun el numero 
                    que le corresponda.

 */
 
  DROP DATABASE IF EXISTS inventariosUtl;
  CREATE DATABASE inventariosUtl;
  USE inventariosUtl;
  
  /*Tabla Persona */ 
  CREATE TABLE persona (
  idPersona           INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre              VARCHAR(60) NOT NULL DEFAULT '',
  apellidoPaterno     VARCHAR(60) NOT NULL DEFAULT '',
  apellidoMaterno     VARCHAR(60) NOT NULL DEFAULT '',
  correo              VARCHAR(80) NOT NULL DEFAULT '',
  telefono            VARCHAR(20) NOT NULL DEFAULT '',
  estado              VARCHAR(70) NOT NULL DEFAULT '',
  municipio           VARCHAR(70) NOT NULL DEFAULT '',
  calleNum            VARCHAR(80) NOT NULL DEFAULT ''
  );
  
    /* Tabla Solicitante */
    CREATE TABLE solicitante(
     idSolicitante   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	 area            VARCHAR(150) NOT NULL DEFAULT '',
     tipo            VARCHAR(60) NOT NULL DEFAULT '',
     estatus         INT NOT NULL DEFAULT 1,/*1. Activo 2.Inactivo*/
     idPersona       INT NOT NULL,
     FOREIGN KEY(idPersona) REFERENCES persona(idPersona)
    );
    
      /* Tabla Laboratorio */
      CREATE TABLE laboratorio(
       idLaboratorio      INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       nombre             VARCHAR(150) NOT NULL DEFAULT'',
       ubicacion          VARCHAR(150) NOT NULL DEFAULT'',
       estatus         INT NOT NULL DEFAULT 1/*1. Activo 2.Inactivo*/
      );
      
    
       /* Tabla Empleado */
       CREATE TABLE empleado(
        idEmpleado        INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        puesto            VARCHAR(150) NOT NULL DEFAULT'',
        area              VARCHAR(150) NOT NULL DEFAULT'',
        usuario           VARCHAR(20) NOT NULL DEFAULT'',
        contrasenia       VARCHAR(20) NOT NULL DEFAULT'',
        estatus           INT NOT NULL DEFAULT 1,/*1. Activo 2.Inactivo*/
        idPersona         INT NOT NULL,
        idLaboratorio     INT NOT NULL,
	    FOREIGN KEY(idPersona) REFERENCES Persona(idPersona),
        FOREIGN KEY(idLaboratorio) REFERENCES laboratorio(idLaboratorio)
       );
       
       /* Tabla Herramienta */
       CREATE TABLE herramienta (
        idHerramienta      INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
		descripcion        VARCHAR(70) NOT NULL DEFAULT'',
		color              VARCHAR (20) NOT NULL DEFAULT'',
		tipo               VARCHAR(30) NOT NULL DEFAULT'',
	    material           VARCHAR(40) NOT NULL DEFAULT'',
		condiciones        VARCHAR(60) NOT NULL DEFAULT '',
	    estatus            INT NOT NULL DEFAULT 1,/*1. Disponible 2.Prestado  3.Inactivo*/
        idLaboratorio      INT NOT NULL,
        FOREIGN KEY(idLaboratorio) REFERENCES laboratorio(idLaboratorio)
       );
       
       /* Tabla Prestamo */
       CREATE TABLE prestamo (
        idPrestamo           INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        fechaHoraPrestamo    DATETIME NOT NULL,
        fechaHoraDevolucion  DATETIME,
        estatus              INT NOT NULL DEFAULT 1,/*1. Activo 2.Devuelto*/
        tipo                 VARCHAR(30) NOT NULL DEFAULT '',
        observaciones        VARCHAR(100) NOT NULL DEFAULT '',
        idSolicitante        INT NOT NULL,
        idEmpleado           INT NOT NULL,
        FOREIGN KEY(idSolicitante) REFERENCES solicitante(idSolicitante),
        FOREIGN KEY(idEmpleado) REFERENCES empleado(idEmpleado)
       );
       
       /* Tabla prestamoHerramienta*/
       CREATE TABLE prestamoHerramienta(
        idPrestamoHerramienta    INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        fotoPrestamo             LONGTEXT ,
        fotoDevolucion           LONGTEXT ,
        idPrestamo               INT NOT NULL,
        idHerramienta            INT NOT NULL,
        estatus                  INT NOT NULL DEFAULT 1, /*1. Activo 2.Cancelado 3.Devuelto*/
		FOREIGN KEY(idPrestamo) REFERENCES prestamo(idPrestamo),
		FOREIGN KEY(idHerramienta) REFERENCES herramienta(idHerramienta)
       );
  