/************************************************
 *      BASE DE DATOS Sistema De Administración *
 *       De Inventario De Equipo De Préstamo    *
 *       De Laboratorios                        *
 *                                              *
 *      Archivo de Manipulacion de Datos (DML)  *
 *      DATOS BASE                              *
 ***********************************************/
 
  /*
    Version:        1.0
    Fecha:          02/12/2020 00:10 
    Autor:          Maria Dolores Espinosa Valdez
    Email:          lolis.ev49@gmail.com
    Comentarios:   Creacion de procedimientos 
                    almacenados para el modulo de prestamos.

 */
 USE inventariosutl;
 
 /*DATOS PERSONA*/
 INSERT INTO persona VALUES(DEFAULT,'Juan','Lopez','Perez','jperez@gmail.com','4778952316','Guanajuato','Leon','Blvd Aeropuerto 115');
 INSERT INTO persona VALUES(DEFAULT,'Alejandra','Becerra','Martinez','becerra@gmail.com','4778594712','Guanajuato','Leon','Calle Miraflores 103');
 INSERT INTO persona VALUES(DEFAULT,'Pedro','Ramirez','Hernandez','pedrorh@gmail.com','4777412589','Guanajuato','Leon','Calle Francisci I Madero 789');
 INSERT INTO persona VALUES(DEFAULT,'Maria','Cedeño','Navarro','sofi12@gmail.com','4762589746','Guanajuato','San Francisco','Blvd Del Valle 150');
 INSERT INTO persona VALUES(DEFAULT,'Fermin','Sanchez','Cortez','fcortes@gmail.com','4773698547','Guanajuato','Leon','Calle Hidalgo 589');
 INSERT INTO persona VALUES(DEFAULT,'Kenia','Juarez','Lopez','kenia25@gmail.com','4777892563','Guanajuato','Leon','Blvd Delta 526');
 
 /*DATOS SOLICITANTE */
 INSERT INTO solicitante VALUES(DEFAULT,'Tecnologias de la Informacion','Alumno',DEFAULT,4);
 INSERT INTO solicitante VALUES(DEFAULT,'Electromecanica','Docente',DEFAULT,5);
 INSERT INTO solicitante VALUES(DEFAULT,'Administracion','Alumno',DEFAULT,6);
 
 /*DATOS LABORATORIOS*/
 INSERT INTO laboratorio VALUES(DEFAULT,'Laboratorio TI','Edificio D',DEFAULT);
 INSERT INTO laboratorio VALUES(DEFAULT,'Laboratorio Electromecania','Edificio C',DEFAULT);
 INSERT INTO laboratorio VALUES(DEFAULT,'Laboratorio Administracion','Edificio A',DEFAULT);
   
 
 /*DATOS EMPLEADO*/
 INSERT INTO empleado VALUES(DEFAULT,'Encargado de laboratorio','Tecnologias de la Informacion','17003698','jp17003698',DEFAULT,1,1);
 INSERT INTO empleado VALUES(DEFAULT,'Encargado de laboratorio','Electromecanica','17002056','ab17002056',DEFAULT,2,2);
 INSERT INTO empleado VALUES(DEFAULT,'Encargado de laboratorio','Administracion','17002010','pr17002010',DEFAULT,3,3);
 
 /*DATOS HERRAMIENTAS*/
 INSERT INTO herramienta VALUES(DEFAULT,'Pinzas para ponchar cable','Negro','Pinzas','Acero y plastico','Buenas',DEFAULT,1);
 INSERT INTO herramienta VALUES(DEFAULT,'Cable HDMI','Rojo','Cables','Acero y plastico','Buenas',DEFAULT,1);
 INSERT INTO herramienta VALUES(DEFAULT,'Voltimetro','Verde','Dispositivos','Acero y plastico','Buenas',DEFAULT,1);
 
 INSERT INTO herramienta VALUES(DEFAULT,'Pinzas sencillas','Negro','Pinzas','Acero y plastico','Buenas',DEFAULT,2);
 INSERT INTO herramienta VALUES(DEFAULT,'Cable HDMI','Rojo','Cables','Acero y plastico','Buenas',DEFAULT,2);
 INSERT INTO herramienta VALUES(DEFAULT,'Voltimetro','Verde','Dispositivos','Acero y plastico','Buenas',DEFAULT,2);
 
 INSERT INTO herramienta VALUES(DEFAULT,'Cable de red','Azul','Cables','Plastico y cobre','Buenas',DEFAULT,3);
 INSERT INTO herramienta VALUES(DEFAULT,'Cable HDMI','Rojo','Cables','Acero y plastico','Buenas',DEFAULT,3);
 INSERT INTO herramienta VALUES(DEFAULT,'Perforadora','Gris','Herramientas de escritorio','Acero','Buenas',DEFAULT,3);
 
