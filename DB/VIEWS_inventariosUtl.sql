/************************************************
 *      BASE DE DATOS Sistema De Administración *
 *       De Inventario De Equipo De Préstamo    *
 *       De Laboratorios                        *
 *                                              *
 *      Archivo con las vistas del sistema      *
 ***********************************************/
 
  /*
    Version:        1.0
    Fecha:          02/12/2020 1:00 
    Autor:          Omar Alberto Carrizal Mendez
    Email:          omaralbertocarrizal@gmail.com
    Comentarios:    Creacion de las vistas para la base de datos.
                    
                    02/12/2020 - Se crearon las vistas necesarias para
                    consumir cada una de las tablas de manera sencilla.
                    
 */
 use inventariosutl;
 
 #Consultar Empleado
 DROP VIEW IF EXISTS seeEmpleados;
 CREATE VIEW seeEmpleados AS
 (
	SELECT e.idEmpleado AS idEmpleadoE, e.puesto AS puestoE, e.area AS areaE, e.contrasenia AS contraseniaE, e.estatus AS estatusE, 
    p.idPersona AS idPersonaE, p.nombre AS nombreE, p.apellidoPaterno AS apellidoPaternoE, p.apellidoMaterno AS apellidoMaternoE, 
    p.correo AS correoE, p.telefono AS telefonoE, p.estado AS estadoE, p.municipio AS municipioE, p.calleNum AS calleNumE, 
    l.idLaboratorio AS idLaboratorioE, l.nombre AS nombreLE, l.ubicacion AS ubicacionE, l.estatus AS estatusLE
    FROM empleado e 
    INNER JOIN persona p 
    ON e.idPersona = p.idPersona 
    INNER JOIN laboratorio l 
    ON e.idLaboratorio = l.idLaboratorio
 );
 
 #Consultar Herramienta
 DROP VIEW IF EXISTS seeHerramientas;
 CREATE VIEW seeHerramientas AS
 (
	SELECT h.idHerramienta AS idHerramientaH, h.descripcion AS descripcionH, h.color AS colorH, h.tipo AS tipoH, 
    h.material AS materialH, h.condiciones AS condicionesH, h.estatus AS estatusH, 
	l.idLaboratorio AS idLaboratorioH, l.nombre AS nombreLH, l.ubicacion AS ubicacionH, l.estatus AS estatusLH
    FROM herramienta h
    INNER JOIN laboratorio l 
    ON h.idLaboratorio = l.idLaboratorio
 );
 
 #Consultar Laboratorio
 DROP VIEW IF EXISTS seeLaboratorios;
 CREATE VIEW seeLaboratorios AS
 (
	SELECT l.idLaboratorio AS idLaboratorioL, l.nombre AS nombreL, l.ubicacion AS ubicacionL, l.estatus AS estatusL
    FROM laboratorio l
 );
 
 #Consultar Solicitante
 DROP VIEW IF EXISTS seeSolicitantes;
 CREATE VIEW seeSolicitantes AS
 (
	SELECT s.idSolicitante AS idSolicitanteS, s.area AS areaS, s.tipo AS tipoS, s.estatus AS estatusS,
    p.idPersona AS idPersonaS, p.nombre AS nombreS, p.apellidoPaterno AS apellidoPaternoS, p.apellidoMaterno AS apellidoMaternoS, 
    p.correo AS correoS, p.telefono AS telefonoS, p.estado AS estadoS, p.municipio AS municipioS, p.calleNum AS calleNumS
    FROM solicitante s
    INNER JOIN persona p 
    ON s.idPersona = p.idPersona
 );
 
 #Consultar Prestamo
 DROP VIEW IF EXISTS seePrestamos;
 CREATE VIEW seePrestamos AS
 (
	SELECT pr.idPrestamo AS idPrestamoPr, pr.fechaHoraPrestamo AS fechaHoraPrestamoPr, 
    pr.fechaHoraDevolucion AS fechaHoraDevolucionPr, pr.estatus AS estatusPr, pr.tipo AS tipoPr, pr.observaciones AS observacionesPr,
    se.*, ss.*
    FROM prestamo pr 
    INNER JOIN seeSolicitantes ss
    ON pr.idSolicitante = ss.idSolicitanteS
    INNER JOIN seeEmpleados se
    ON pr.idEmpleado = se.idEmpleadoE
 );
 
 #Consultar PrestamoHerramienta
 DROP VIEW IF EXISTS seePrestamoHerramientas;
 CREATE VIEW seePrestamoHerramientas AS
 (
	SELECT ph.idPrestamoHerramienta AS idPrestamoHerramientaPh, ph.fotoPrestamo AS fotoPrestamoPh, ph.fotoDevolucion AS fotoDevolucionPh,
    ph.estatus AS estatusPh,
    spr.*, sh.*
    FROM prestamoherramienta ph 
    INNER JOIN seePrestamos spr
    ON ph.idPrestamo = spr.idPrestamoPr
    INNER JOIN seeHerramientas sh
    ON ph.idHerramienta = sh.idHerramientaH
 );