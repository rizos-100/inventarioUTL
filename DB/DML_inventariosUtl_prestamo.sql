/************************************************
 *      BASE DE DATOS Sistema De Administración *
 *       De Inventario De Equipo De Préstamo    *
 *       De Laboratorios                        *
 *                                              *
 *      Archivo de Manipulacion de Datos (DML)  *
 ***********************************************/
 
  /*
    Version:        1.0
    Fecha:          28/11/2020 15:00 
    Autor:          Maria Dolores Espinosa Valdez
    Email:          lolis.ev49@gmail.com
    Comentarios:   Creacion de procedimientos 
                    almacenados para el modulo de prestamos.

 */
 
 /* Procedimiento para agregar prestamo*/
 DROP PROCEDURE IF EXISTS insertarPrestamo;
 DELIMITER $$
 CREATE PROCEDURE insertarPrestamo(IN tipo  VARCHAR(30),IN idSol INT, 
 IN idEmp INT, IN observ VARCHAR(100), OUT idP INT)
 BEGIN
  INSERT INTO prestamo VALUES(DEFAULT,NOW(),NULL,DEFAULT,tipo, observ, idSol, idEmp);
  set idP=last_insert_id();
 END $$
 
 CALL insertarPrestamo('Interno',1,1,'Ninguna',@idP);
 
  /* Procedimiento para agregar materiales a un prestamo*/
 DROP PROCEDURE IF EXISTS insertarHerramientaPrestamo;
 DELIMITER $$
 CREATE PROCEDURE insertarHerramientaPrestamo(IN fotoP LONGTEXT,IN idP INT, IN idH INT,OUT idHP INT)
 BEGIN
  INSERT INTO prestamoHerramienta VALUES(DEFAULT,fotoP,NULL,idP,idH,DEFAULT);
  set idHP=last_insert_id();
 END $$
 
 CALL insertarHerramientaPrestamo('HAAGSHSGSGSH',1,1,@IidHP);