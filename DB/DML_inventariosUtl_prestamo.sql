/************************************************
 *      BASE DE DATOS Sistema De Administración *
 *       De Inventario De Equipo De Préstamo    *
 *       De Laboratorios                        *
 *                                              *
 *      Archivo de Manipulacion de Datos (DML)  *
 ***********************************************/
 
  /*
    Version:        1.1
    Fecha:          28/11/2020 15:00 
    Autor:          Maria Dolores Espinosa Valdez
    Email:          lolis.ev49@gmail.com
    Comentarios:   Creacion de procedimientos 
                    almacenados para el modulo de prestamos.
                    
                    02/12/2020 - Se agregaron los procedimientos para
                    desactivar o devolver una herramienta, terminar un 
                    prestamo y se modifico el de registrar un prestamo.
                    
                    02/12/2020 - Se modifico el procedimiento de insertar prestamo
                    y terminar prestamo para cambiar el ingreso de observaciones.
                    
                    02/12/2020 - Se modifico el procedimiento de insertar prestamo
                    se quito el IN observacion. -Carrizal

 */
 
 USE inventariosutl;
 ###################################################################################################
 /* Procedimiento para agregar prestamo*/
 DROP PROCEDURE IF EXISTS insertarPrestamo;
 DELIMITER $$
 CREATE PROCEDURE insertarPrestamo(IN tipo  VARCHAR(30),IN idSol INT, 
 IN idEmp INT, OUT idP INT)
 BEGIN
  INSERT INTO prestamo VALUES(DEFAULT,NOW(),NULL,DEFAULT,tipo, NULL, idSol, idEmp);
  set idP=last_insert_id();
 END $$
 
 CALL insertarPrestamo('Interno',1,1,'Ninguna',@idP);
 ############################################################################################################
  /* Procedimiento para agregar materiales a un prestamo*/
 DROP PROCEDURE IF EXISTS insertarHerramientaPrestamo;
 DELIMITER $$
 CREATE PROCEDURE insertarHerramientaPrestamo(IN fotoP LONGTEXT,IN idP INT, IN idH INT,OUT idHP INT)
 BEGIN
  INSERT INTO prestamoHerramienta VALUES(DEFAULT,fotoP,NULL,idP,idH,DEFAULT);
  set idHP=last_insert_id();
  UPDATE herramienta
  SET estatus=2
  WHERE idHerramienta=idH;
 END $$
 
 CALL insertarHerramientaPrestamo('HAAGSHSGSGSH',2,1,@IidHP);
 ############################################################################################################
 /* Procedimiento para desactivar materiales de un prestamo*/
 DROP PROCEDURE IF EXISTS desactivarHerramientaPrestamo;
 DELIMITER  $$
 CREATE PROCEDURE desactivarHerramientaPrestamo(IN idHP INT,IN idH INT)
 BEGIN
 UPDATE prestamoherramienta
 SET estatus=2
 WHERE idPrestamoHerramienta=idHP;
 
 UPDATE herramienta
 SET estatus=1
 WHERE idHerramienta=idH;
 END
 $$
 
 CALL desactivarHerramientaPrestamo(1,1);
 #######################################################################################################
 /* Procedimiento para devolverr materiales de un prestamo*/
 DROP PROCEDURE IF EXISTS devolverHerramientaPrestamo;
 DELIMITER  $$
 CREATE PROCEDURE devolverHerramientaPrestamo(IN idHP INT,IN idH INT,IN fotoD LONGTEXT)
 BEGIN
 UPDATE prestamoherramienta
 SET estatus=3
 WHERE idPrestamoHerramienta=idHP;
 
 UPDATE herramienta
 SET estatus=1
 WHERE idHerramienta=idH;

 
 UPDATE prestamoherramienta
 SET fotoDevolucion=fotoD
 WHERE idPrestamoHerramienta=idHP;
 
 END
 $$
 
 CALL devolverHerramientaPrestamo(1,1,'HGDRSYHGA');
 
 ##############################################################################################################
  /* Procedimiento para registrar la entrega total de un prestamo*/
   DROP PROCEDURE IF EXISTS terminarPrestamo;
   DELIMITER $$
   CREATE PROCEDURE terminarPrestamo(IN idP INT, IN observ VARCHAR(100))
   BEGIN
   UPDATE prestamo
   SET fechaHoraDevolucion=NOW(),estatus=2,observaciones=observ
   WHERE idPrestamo=idP;
 
   END
   $$
   
CALL terminarPrestamo(2,'Todo bien');