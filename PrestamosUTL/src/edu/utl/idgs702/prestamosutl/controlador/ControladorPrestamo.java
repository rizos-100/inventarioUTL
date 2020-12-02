
package edu.utl.idgs702.prestamosutl.controlador;

import edu.utl.idgs702.prestamosutl.datos.Conexion;
import edu.utl.idgs702.prestamosutl.modelo.Empleado;
import edu.utl.idgs702.prestamosutl.modelo.Herramienta;
import edu.utl.idgs702.prestamosutl.modelo.Laboratorio;
import edu.utl.idgs702.prestamosutl.modelo.Persona;
import edu.utl.idgs702.prestamosutl.modelo.PrestamoHerramienta;
import edu.utl.idgs702.prestamosutl.modelo.Prestamo;
import edu.utl.idgs702.prestamosutl.modelo.Solicitante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Omar Carrizal
 * @version 1.0
 */
public class ControladorPrestamo
{
    /**
     * <b>Descripción:</b><br>
     * Consulta todos los prestamos de la base de datos.
     * 
     * @return Prestamos (lista de prestamos)
     */
    public static List<Prestamo> getAllPrestamos()
    {
        String sql = "SELECT * FROM seePrestamos";
        List<Prestamo> prestamos = new ArrayList<>();
        
        Conexion c = new Conexion();
        Connection miC = null;
        Statement t;
        ResultSet r;
        
        try
        {
            t = null;
            miC = c.abrir();
            t = miC.createStatement();
            r = t.executeQuery(sql);
            r.beforeFirst();
            while (r.next())
            {
                
                Prestamo pr = new Prestamo();
                
                Empleado e = new Empleado();
                Persona ep = new Persona();
                Laboratorio el = new Laboratorio();
                
                Solicitante s = new Solicitante();
                Persona sp = new Persona();
                
                /*Llenado del prestamo 'pr' */
                
                el.setIdLaboratorio(r.getInt("idLaboratorioE"));
                el.setNombre(r.getString("nombreLE"));
                el.setUbicacion(r.getString("ubicacionE"));
                el.setEstatus(r.getInt("estatusLE"));
                
                ep.setIdPersona(r.getInt("idPersonaE"));
                ep.setNombre(r.getString("nombreE"));
                ep.setApellidoPaterno(r.getString("apellidoPaternoE"));
                ep.setApellidoMaterno(r.getString("apellidoMaternoE"));
                ep.setCorreo(r.getString("correoE"));
                ep.setTelefono(r.getString("telefonoE"));
                ep.setEstado(r.getString("estadoE"));
                ep.setMunicipio(r.getString("municipioE"));
                ep.setCalleNum(r.getString("calleNumE"));
                
                e.setIdEmpleado(r.getInt("idEmpleadoE"));
                e.setPuesto(r.getString("puestoE"));
                e.setArea(r.getString("areaE"));
                e.setUsuario(r.getString("usuarioE"));
                e.setContrasena(r.getString("contraseniaE"));
                e.setEstatus(r.getInt("estatusE"));
                e.setLaboratorio(el);
                e.setPersona(ep);
                
                
                sp.setIdPersona(r.getInt("idPersonaS"));
                sp.setNombre(r.getString("nombreS"));
                sp.setApellidoPaterno(r.getString("apellidoPaternoS"));
                sp.setApellidoMaterno(r.getString("apellidoMaternoS"));
                sp.setCorreo(r.getString("correoS"));
                sp.setTelefono(r.getString("telefonoS"));
                sp.setEstado(r.getString("estadoS"));
                sp.setMunicipio(r.getString("municipioS"));
                sp.setCalleNum(r.getString("calleNumS"));
                
                s.setIdSolicitante(r.getInt("idSolicitanteS"));
                s.setArea(r.getString("areaS"));
                s.setTipo(r.getString("tipoS"));
                s.setEstatus(r.getInt("estatusS"));
                s.setPersona(sp);
                
                
                pr.setIdPrestamo(r.getInt("idPrestamoHerramientaPh"));
                pr.setFechaHoraPrestamo(r.getDate("fechaHoraPrestamoPr"));
                pr.setFechaHoraDevolucion(r.getDate("fechaHoraDevolucionPr"));
                pr.setEstatus(r.getInt("estatusPr"));
                pr.setTipo(r.getString("tipoPr"));
                pr.setObservaciones(r.getString("observacionesPr"));
                pr.setEmpleado(e);
                pr.setSolicitante(s);
                
                List<PrestamoHerramienta> ph = ControladorPrestamoHerramienta.getPrestamoHerramientasByPrestamo(pr.getIdPrestamo());
                pr.setHerramientas(ph);
                
                /*Fin del llenado del prestamo 'pr' */
                
                
                
                
                prestamos.add(pr);
            }
            miC.close();
            return prestamos;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if(miC == null){
                c.cerrar();
            }
            return null;
        }
        finally{
            c.cerrar();
        }
    }
    
    /**
     * <b>Descripción:</b><br>
     * Consulta todos los prestamos activos de la base de datos.
     * 
     * @return prestamos (lista de Prestamo)
     */
    public static List<Prestamo> getPrestamosActivos()
    {
        String sql = "SELECT * FROM seePrestamoHerramientas WHERE estatusPr = 1";
        List<Prestamo> prestamos = new ArrayList<>();
        
        Conexion c = new Conexion();
        Connection miC = null;
        Statement t;
        ResultSet r;
        
        try
        {
            t = null;
            miC = c.abrir();
            t = miC.createStatement();
            r = t.executeQuery(sql);
            r.beforeFirst();
            while (r.next())
            {
                
                Prestamo pr = new Prestamo();
                
                Empleado e = new Empleado();
                Persona ep = new Persona();
                Laboratorio el = new Laboratorio();
                
                Solicitante s = new Solicitante();
                Persona sp = new Persona();
                
                /*Llenado del prestamo 'pr' */
                
                el.setIdLaboratorio(r.getInt("idLaboratorioE"));
                el.setNombre(r.getString("nombreLE"));
                el.setUbicacion(r.getString("ubicacionE"));
                el.setEstatus(r.getInt("estatusLE"));
                
                ep.setIdPersona(r.getInt("idPersonaE"));
                ep.setNombre(r.getString("nombreE"));
                ep.setApellidoPaterno(r.getString("apellidoPaternoE"));
                ep.setApellidoMaterno(r.getString("apellidoMaternoE"));
                ep.setCorreo(r.getString("correoE"));
                ep.setTelefono(r.getString("telefonoE"));
                ep.setEstado(r.getString("estadoE"));
                ep.setMunicipio(r.getString("municipioE"));
                ep.setCalleNum(r.getString("calleNumE"));
                
                e.setIdEmpleado(r.getInt("idEmpleadoE"));
                e.setPuesto(r.getString("puestoE"));
                e.setArea(r.getString("areaE"));
                e.setUsuario(r.getString("usuarioE"));
                e.setContrasena(r.getString("contraseniaE"));
                e.setEstatus(r.getInt("estatusE"));
                e.setLaboratorio(el);
                e.setPersona(ep);
                
                
                sp.setIdPersona(r.getInt("idPersonaS"));
                sp.setNombre(r.getString("nombreS"));
                sp.setApellidoPaterno(r.getString("apellidoPaternoS"));
                sp.setApellidoMaterno(r.getString("apellidoMaternoS"));
                sp.setCorreo(r.getString("correoS"));
                sp.setTelefono(r.getString("telefonoS"));
                sp.setEstado(r.getString("estadoS"));
                sp.setMunicipio(r.getString("municipioS"));
                sp.setCalleNum(r.getString("calleNumS"));
                
                s.setIdSolicitante(r.getInt("idSolicitanteS"));
                s.setArea(r.getString("areaS"));
                s.setTipo(r.getString("tipoS"));
                s.setEstatus(r.getInt("estatusS"));
                s.setPersona(sp);
                
                
                pr.setIdPrestamo(r.getInt("idPrestamoHerramientaPh"));
                pr.setFechaHoraPrestamo(r.getDate("fechaHoraPrestamoPr"));
                pr.setFechaHoraDevolucion(r.getDate("fechaHoraDevolucionPr"));
                pr.setEstatus(r.getInt("estatusPr"));
                pr.setTipo(r.getString("tipoPr"));
                pr.setObservaciones(r.getString("observacionesPr"));
                pr.setEmpleado(e);
                pr.setSolicitante(s);
                
                List<PrestamoHerramienta> ph = ControladorPrestamoHerramienta.getPrestamoHerramientasByPrestamo(pr.getIdPrestamo());
                pr.setHerramientas(ph);
                
                /*Fin del llenado del prestamo 'pr' */
                
                
                
                
                prestamos.add(pr);
            }
            miC.close();
            return prestamos;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if(miC == null){
                c.cerrar();
            }
            return null;
        }
        finally{
            c.cerrar();
        }
    }
    
    /**
     * <b>Descripción:</b><br>
     * Consulta todos los prestamos devueltos de la base de datos.
     * 
     * @return prestamos (lista de Prestamo)
     */
    public static List<Prestamo> getPrestamosDevuelto()
    {
        String sql = "SELECT * FROM seePrestamoHerramientas WHERE estatusPr = 2";
        List<Prestamo> prestamos = new ArrayList<>();
        
        Conexion c = new Conexion();
        Connection miC = null;
        Statement t;
        ResultSet r;
        
        try
        {
            t = null;
            miC = c.abrir();
            t = miC.createStatement();
            r = t.executeQuery(sql);
            r.beforeFirst();
            while (r.next())
            {
                
                Prestamo pr = new Prestamo();
                
                Empleado e = new Empleado();
                Persona ep = new Persona();
                Laboratorio el = new Laboratorio();
                
                Solicitante s = new Solicitante();
                Persona sp = new Persona();
                
                /*Llenado del prestamo 'pr' */
                
                el.setIdLaboratorio(r.getInt("idLaboratorioE"));
                el.setNombre(r.getString("nombreLE"));
                el.setUbicacion(r.getString("ubicacionE"));
                el.setEstatus(r.getInt("estatusLE"));
                
                ep.setIdPersona(r.getInt("idPersonaE"));
                ep.setNombre(r.getString("nombreE"));
                ep.setApellidoPaterno(r.getString("apellidoPaternoE"));
                ep.setApellidoMaterno(r.getString("apellidoMaternoE"));
                ep.setCorreo(r.getString("correoE"));
                ep.setTelefono(r.getString("telefonoE"));
                ep.setEstado(r.getString("estadoE"));
                ep.setMunicipio(r.getString("municipioE"));
                ep.setCalleNum(r.getString("calleNumE"));
                
                e.setIdEmpleado(r.getInt("idEmpleadoE"));
                e.setPuesto(r.getString("puestoE"));
                e.setArea(r.getString("areaE"));
                e.setUsuario(r.getString("usuarioE"));
                e.setContrasena(r.getString("contraseniaE"));
                e.setEstatus(r.getInt("estatusE"));
                e.setLaboratorio(el);
                e.setPersona(ep);
                
                
                sp.setIdPersona(r.getInt("idPersonaS"));
                sp.setNombre(r.getString("nombreS"));
                sp.setApellidoPaterno(r.getString("apellidoPaternoS"));
                sp.setApellidoMaterno(r.getString("apellidoMaternoS"));
                sp.setCorreo(r.getString("correoS"));
                sp.setTelefono(r.getString("telefonoS"));
                sp.setEstado(r.getString("estadoS"));
                sp.setMunicipio(r.getString("municipioS"));
                sp.setCalleNum(r.getString("calleNumS"));
                
                s.setIdSolicitante(r.getInt("idSolicitanteS"));
                s.setArea(r.getString("areaS"));
                s.setTipo(r.getString("tipoS"));
                s.setEstatus(r.getInt("estatusS"));
                s.setPersona(sp);
                
                
                pr.setIdPrestamo(r.getInt("idPrestamoHerramientaPh"));
                pr.setFechaHoraPrestamo(r.getDate("fechaHoraPrestamoPr"));
                pr.setFechaHoraDevolucion(r.getDate("fechaHoraDevolucionPr"));
                pr.setEstatus(r.getInt("estatusPr"));
                pr.setTipo(r.getString("tipoPr"));
                pr.setObservaciones(r.getString("observacionesPr"));
                pr.setEmpleado(e);
                pr.setSolicitante(s);
                
                List<PrestamoHerramienta> ph = ControladorPrestamoHerramienta.getPrestamoHerramientasByPrestamo(pr.getIdPrestamo());
                pr.setHerramientas(ph);
                
                /*Fin del llenado del prestamo 'pr' */
                
                
                
                
                prestamos.add(pr);
            }
            miC.close();
            return prestamos;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if(miC == null){
                c.cerrar();
            }
            return null;
        }
        finally{
            c.cerrar();
        }
    }
    
    /**
     * <b>Descripción:</b><br>
     * Consulta un prestamo de la base de datos.
     * 
     * @param  idPr (id de un prestamo)
     * @return Prestamo 
     */
    public static Prestamo getPrestamosById(int idPr)
    {
        String sql = "SELECT * FROM seePrestamoHerramientas WHERE idPrestamoPr = "+idPr;
        Prestamo prestamo = new Prestamo();
        
        Conexion c = new Conexion();
        Connection miC = null;
        Statement t;
        ResultSet r;
        
        try
        {
            t = null;
            miC = c.abrir();
            t = miC.createStatement();
            r = t.executeQuery(sql);
            r.beforeFirst();
            while (r.next())
            {
                
                Prestamo pr = new Prestamo();
                
                Empleado e = new Empleado();
                Persona ep = new Persona();
                Laboratorio el = new Laboratorio();
                
                Solicitante s = new Solicitante();
                Persona sp = new Persona();
                
                /*Llenado del prestamo 'pr' */
                
                el.setIdLaboratorio(r.getInt("idLaboratorioE"));
                el.setNombre(r.getString("nombreLE"));
                el.setUbicacion(r.getString("ubicacionE"));
                el.setEstatus(r.getInt("estatusLE"));
                
                ep.setIdPersona(r.getInt("idPersonaE"));
                ep.setNombre(r.getString("nombreE"));
                ep.setApellidoPaterno(r.getString("apellidoPaternoE"));
                ep.setApellidoMaterno(r.getString("apellidoMaternoE"));
                ep.setCorreo(r.getString("correoE"));
                ep.setTelefono(r.getString("telefonoE"));
                ep.setEstado(r.getString("estadoE"));
                ep.setMunicipio(r.getString("municipioE"));
                ep.setCalleNum(r.getString("calleNumE"));
                
                e.setIdEmpleado(r.getInt("idEmpleadoE"));
                e.setPuesto(r.getString("puestoE"));
                e.setArea(r.getString("areaE"));
                e.setUsuario(r.getString("usuarioE"));
                e.setContrasena(r.getString("contraseniaE"));
                e.setEstatus(r.getInt("estatusE"));
                e.setLaboratorio(el);
                e.setPersona(ep);
                
                
                sp.setIdPersona(r.getInt("idPersonaS"));
                sp.setNombre(r.getString("nombreS"));
                sp.setApellidoPaterno(r.getString("apellidoPaternoS"));
                sp.setApellidoMaterno(r.getString("apellidoMaternoS"));
                sp.setCorreo(r.getString("correoS"));
                sp.setTelefono(r.getString("telefonoS"));
                sp.setEstado(r.getString("estadoS"));
                sp.setMunicipio(r.getString("municipioS"));
                sp.setCalleNum(r.getString("calleNumS"));
                
                s.setIdSolicitante(r.getInt("idSolicitanteS"));
                s.setArea(r.getString("areaS"));
                s.setTipo(r.getString("tipoS"));
                s.setEstatus(r.getInt("estatusS"));
                s.setPersona(sp);
                
                
                pr.setIdPrestamo(r.getInt("idPrestamoHerramientaPh"));
                pr.setFechaHoraPrestamo(r.getDate("fechaHoraPrestamoPr"));
                pr.setFechaHoraDevolucion(r.getDate("fechaHoraDevolucionPr"));
                pr.setEstatus(r.getInt("estatusPr"));
                pr.setTipo(r.getString("tipoPr"));
                pr.setObservaciones(r.getString("observacionesPr"));
                pr.setEmpleado(e);
                pr.setSolicitante(s);
                
                List<PrestamoHerramienta> ph = ControladorPrestamoHerramienta.getPrestamoHerramientasByPrestamo(pr.getIdPrestamo());
                pr.setHerramientas(ph);
                
                /*Fin del llenado del prestamo 'pr' */
                
                
                
                
                prestamo = pr;
            }
            miC.close();
            return prestamo;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if(miC == null){
                c.cerrar();
            }
            return null;
        }
        finally{
            c.cerrar();
        }
    }
}