
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
public class ControladorPrestamoHerramienta
{
    /**
     * <b>Descripción:</b><br>
     * Consulta todas las prestamoherramientas de la base de datos.
     * 
     * @return Prestamoherramientas (lista de prestamoherramientas)
     */
    public static List<PrestamoHerramienta> getAllPrestamoHerramientas()
    {
        String sql = "SELECT * FROM seePrestamoHerramientas";
        List<PrestamoHerramienta> prestamoHerramientas = new ArrayList<>();
        
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
                PrestamoHerramienta ph = new PrestamoHerramienta();
                
                Prestamo pr = new Prestamo();
                
                Empleado e = new Empleado();
                Persona ep = new Persona();
                Laboratorio el = new Laboratorio();
                
                Solicitante s = new Solicitante();
                Persona sp = new Persona();
                
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
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
                
                
                pr.setIdPrestamo(r.getInt("idPrestamoPr"));
                pr.setFechaHoraPrestamo(r.getDate("fechaHoraPrestamoPr"));
                pr.setFechaHoraDevolucion(r.getDate("fechaHoraDevolucionPr"));
                pr.setEstatus(r.getInt("estatusPr"));
                pr.setTipo(r.getString("tipoPr"));
                pr.setObservaciones(r.getString("observacionesPr"));
                pr.setEmpleado(e);
                pr.setSolicitante(s);
                
                /*Fin del llenado del prestamo 'pr' */
                
                
                /*Llenado de la herramienta del Prestamo 'h' */
                l.setIdLaboratorio(r.getInt("idLaboratorioH"));
                l.setNombre(r.getString("nombreLH"));
                l.setUbicacion(r.getString("ubicacionH"));
                l.setEstatus(r.getInt("estatusLH"));
                
                h.setIdHerramienta(r.getInt("idHerramientaH"));
                h.setDescripcion(r.getString("descripcionH"));
                h.setColor(r.getString("colorH"));
                h.setTipo(r.getString("tipoH"));
                h.setMaterial(r.getString("materialH"));
                h.setCondiciones(r.getString("condicionesH"));
                h.setEstatus(r.getInt("estatusH"));
                h.setLaboratorio(l);
                /*Fin del llenado de la herramienta del Prestamo 'h' */
                
                
                /*Llenado del prestamoHerramienta 'ph' */
                
                ph.setIdPrestamoHerramienta(r.getInt("idPrestamoHerramientaPh"));
                ph.setFotoPretamo(r.getString("fotoPrestamoPh"));
                ph.setFotoDevolucion(r.getString("fotoDevolucionPh"));
                ph.setEstatus(r.getInt("estatusPh"));
                ph.setPrestamo(pr);
                ph.setHerramienta(h);
                
                /*Fin del llenado del prestamoHerramienta 'ph' */
                
                prestamoHerramientas.add(ph);
            }
            miC.close();
            return prestamoHerramientas;
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
     * Consulta todas las prestamosHerramientas activas de la base de datos.
     * 
     * @return PrestamosHerramientas (lista de PrestamosHerramientas)
     */
    public static List<PrestamoHerramienta> getPrestamoHerramientasActivas()
    {
        String sql = "SELECT * FROM seePrestamoHerramientas WHERE estatusPh = 1";
        List<PrestamoHerramienta> prestamoHerramientas = new ArrayList<>();
        
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
                PrestamoHerramienta ph = new PrestamoHerramienta();
                
                Prestamo pr = new Prestamo();
                
                Empleado e = new Empleado();
                Persona ep = new Persona();
                Laboratorio el = new Laboratorio();
                
                Solicitante s = new Solicitante();
                Persona sp = new Persona();
                
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
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
                
                
                pr.setIdPrestamo(r.getInt("idPrestamoPr"));
                pr.setFechaHoraPrestamo(r.getDate("fechaHoraPrestamoPr"));
                pr.setFechaHoraDevolucion(r.getDate("fechaHoraDevolucionPr"));
                pr.setEstatus(r.getInt("estatusPr"));
                pr.setTipo(r.getString("tipoPr"));
                pr.setObservaciones(r.getString("observacionesPr"));
                pr.setEmpleado(e);
                pr.setSolicitante(s);
                
                /*Fin del llenado del prestamo 'pr' */
                
                
                /*Llenado de la herramienta del Prestamo 'h' */
                l.setIdLaboratorio(r.getInt("idLaboratorioH"));
                l.setNombre(r.getString("nombreLH"));
                l.setUbicacion(r.getString("ubicacionH"));
                l.setEstatus(r.getInt("estatusLH"));
                
                h.setIdHerramienta(r.getInt("idHerramientaH"));
                h.setDescripcion(r.getString("descripcionH"));
                h.setColor(r.getString("colorH"));
                h.setTipo(r.getString("tipoH"));
                h.setMaterial(r.getString("materialH"));
                h.setCondiciones(r.getString("condicionesH"));
                h.setEstatus(r.getInt("estatusH"));
                h.setLaboratorio(l);
                /*Fin del llenado de la herramienta del Prestamo 'h' */
                
                
                /*Llenado del prestamoHerramienta 'ph' */
                
                ph.setIdPrestamoHerramienta(r.getInt("idPrestamoHerramientaPh"));
                ph.setFotoPretamo(r.getString("fotoPrestamoPh"));
                ph.setFotoDevolucion(r.getString("fotoDevolucionPh"));
                ph.setEstatus(r.getInt("estatusPh"));
                ph.setPrestamo(pr);
                ph.setHerramienta(h);
                
                /*Fin del llenado del prestamoHerramienta 'ph' */
                
                prestamoHerramientas.add(ph);
            }
            miC.close();
            return prestamoHerramientas;
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
     * Consulta todas las prestamosHerramientas canceladas de la base de datos.
     * 
     * @return PrestamosHerramientas (lista de PrestamosHerramientas)
     */
    public static List<PrestamoHerramienta> getPrestamoHerramientasCanceladas()
    {
        String sql = "SELECT * FROM seePrestamoHerramientas WHERE estatusPh = 2";
        List<PrestamoHerramienta> prestamoHerramientas = new ArrayList<>();
        
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
                PrestamoHerramienta ph = new PrestamoHerramienta();
                
                Prestamo pr = new Prestamo();
                
                Empleado e = new Empleado();
                Persona ep = new Persona();
                Laboratorio el = new Laboratorio();
                
                Solicitante s = new Solicitante();
                Persona sp = new Persona();
                
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
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
                
                
                pr.setIdPrestamo(r.getInt("idPrestamoPr"));
                pr.setFechaHoraPrestamo(r.getDate("fechaHoraPrestamoPr"));
                pr.setFechaHoraDevolucion(r.getDate("fechaHoraDevolucionPr"));
                pr.setEstatus(r.getInt("estatusPr"));
                pr.setTipo(r.getString("tipoPr"));
                pr.setObservaciones(r.getString("observacionesPr"));
                pr.setEmpleado(e);
                pr.setSolicitante(s);
                
                /*Fin del llenado del prestamo 'pr' */
                
                
                /*Llenado de la herramienta del Prestamo 'h' */
                l.setIdLaboratorio(r.getInt("idLaboratorioH"));
                l.setNombre(r.getString("nombreLH"));
                l.setUbicacion(r.getString("ubicacionH"));
                l.setEstatus(r.getInt("estatusLH"));
                
                h.setIdHerramienta(r.getInt("idHerramientaH"));
                h.setDescripcion(r.getString("descripcionH"));
                h.setColor(r.getString("colorH"));
                h.setTipo(r.getString("tipoH"));
                h.setMaterial(r.getString("materialH"));
                h.setCondiciones(r.getString("condicionesH"));
                h.setEstatus(r.getInt("estatusH"));
                h.setLaboratorio(l);
                /*Fin del llenado de la herramienta del Prestamo 'h' */
                
                
                /*Llenado del prestamoHerramienta 'ph' */
                
                ph.setIdPrestamoHerramienta(r.getInt("idPrestamoHerramientaPh"));
                ph.setFotoPretamo(r.getString("fotoPrestamoPh"));
                ph.setFotoDevolucion(r.getString("fotoDevolucionPh"));
                ph.setEstatus(r.getInt("estatusPh"));
                ph.setPrestamo(pr);
                ph.setHerramienta(h);
                
                /*Fin del llenado del prestamoHerramienta 'ph' */
                
                prestamoHerramientas.add(ph);
            }
            miC.close();
            return prestamoHerramientas;
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
     * Consulta todas las prestamosHerramientas devueltos de la base de datos.
     * 
     * @return PrestamosHerramientas (lista de PrestamosHerramientas)
     */
    public static List<PrestamoHerramienta> getPrestamoHerramientasDevueltas()
    {
        String sql = "SELECT * FROM seePrestamoHerramientas WHERE estatusPh = 3";
        List<PrestamoHerramienta> prestamoHerramientas = new ArrayList<>();
        
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
                PrestamoHerramienta ph = new PrestamoHerramienta();
                
                Prestamo pr = new Prestamo();
                
                Empleado e = new Empleado();
                Persona ep = new Persona();
                Laboratorio el = new Laboratorio();
                
                Solicitante s = new Solicitante();
                Persona sp = new Persona();
                
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
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
                
                
                pr.setIdPrestamo(r.getInt("idPrestamoPr"));
                pr.setFechaHoraPrestamo(r.getDate("fechaHoraPrestamoPr"));
                pr.setFechaHoraDevolucion(r.getDate("fechaHoraDevolucionPr"));
                pr.setEstatus(r.getInt("estatusPr"));
                pr.setTipo(r.getString("tipoPr"));
                pr.setObservaciones(r.getString("observacionesPr"));
                pr.setEmpleado(e);
                pr.setSolicitante(s);
                
                /*Fin del llenado del prestamo 'pr' */
                
                
                /*Llenado de la herramienta del Prestamo 'h' */
                l.setIdLaboratorio(r.getInt("idLaboratorioH"));
                l.setNombre(r.getString("nombreLH"));
                l.setUbicacion(r.getString("ubicacionH"));
                l.setEstatus(r.getInt("estatusLH"));
                
                h.setIdHerramienta(r.getInt("idHerramientaH"));
                h.setDescripcion(r.getString("descripcionH"));
                h.setColor(r.getString("colorH"));
                h.setTipo(r.getString("tipoH"));
                h.setMaterial(r.getString("materialH"));
                h.setCondiciones(r.getString("condicionesH"));
                h.setEstatus(r.getInt("estatusH"));
                h.setLaboratorio(l);
                /*Fin del llenado de la herramienta del Prestamo 'h' */
                
                
                /*Llenado del prestamoHerramienta 'ph' */
                
                ph.setIdPrestamoHerramienta(r.getInt("idPrestamoHerramientaPh"));
                ph.setFotoPretamo(r.getString("fotoPrestamoPh"));
                ph.setFotoDevolucion(r.getString("fotoDevolucionPh"));
                ph.setEstatus(r.getInt("estatusPh"));
                ph.setPrestamo(pr);
                ph.setHerramienta(h);
                
                /*Fin del llenado del prestamoHerramienta 'ph' */
                
                prestamoHerramientas.add(ph);
            }
            miC.close();
            return prestamoHerramientas;
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
     * Consulta todas las prestamosHerramientas de un prestamo de la base de datos.
     * 
     * @param  idPr (id de un prestamo)
     * @return PrestamosHerramientas (lista de PrestamosHerramientas)
     */
    public static List<PrestamoHerramienta> getPrestamoHerramientasByPrestamo(int idPr)
    {
        String sql = "SELECT * FROM seePrestamoHerramientas WHERE idPrestamoPr = "+idPr;
        List<PrestamoHerramienta> prestamoHerramientas = new ArrayList<>();
        
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
                PrestamoHerramienta ph = new PrestamoHerramienta();
                
                Prestamo pr = new Prestamo();
                
                Empleado e = new Empleado();
                Persona ep = new Persona();
                Laboratorio el = new Laboratorio();
                
                Solicitante s = new Solicitante();
                Persona sp = new Persona();
                
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
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
                
                
                pr.setIdPrestamo(r.getInt("idPrestamoPr"));
                pr.setFechaHoraPrestamo(r.getDate("fechaHoraPrestamoPr"));
                pr.setFechaHoraDevolucion(r.getDate("fechaHoraDevolucionPr"));
                pr.setEstatus(r.getInt("estatusPr"));
                pr.setTipo(r.getString("tipoPr"));
                pr.setObservaciones(r.getString("observacionesPr"));
                pr.setEmpleado(e);
                pr.setSolicitante(s);
                
                /*Fin del llenado del prestamo 'pr' */
                
                
                /*Llenado de la herramienta del Prestamo 'h' */
                l.setIdLaboratorio(r.getInt("idLaboratorioH"));
                l.setNombre(r.getString("nombreLH"));
                l.setUbicacion(r.getString("ubicacionH"));
                l.setEstatus(r.getInt("estatusLH"));
                
                h.setIdHerramienta(r.getInt("idHerramientaH"));
                h.setDescripcion(r.getString("descripcionH"));
                h.setColor(r.getString("colorH"));
                h.setTipo(r.getString("tipoH"));
                h.setMaterial(r.getString("materialH"));
                h.setCondiciones(r.getString("condicionesH"));
                h.setEstatus(r.getInt("estatusH"));
                h.setLaboratorio(l);
                /*Fin del llenado de la herramienta del Prestamo 'h' */
                
                
                /*Llenado del prestamoHerramienta 'ph' */
                
                ph.setIdPrestamoHerramienta(r.getInt("idPrestamoHerramientaPh"));
                ph.setFotoPretamo(r.getString("fotoPrestamoPh"));
                ph.setFotoDevolucion(r.getString("fotoDevolucionPh"));
                ph.setEstatus(r.getInt("estatusPh"));
                ph.setPrestamo(pr);
                ph.setHerramienta(h);
                
                /*Fin del llenado del prestamoHerramienta 'ph' */
                
                prestamoHerramientas.add(ph);
            }
            miC.close();
            return prestamoHerramientas;
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
     * Inserta un nuevo prestamoHerramienta en la base de datos
     * 
     * @param ph (PrestamoHerramienta ha insertar)
     * @return idPrestamoHerramienta (Id de la nueva PrestamoHerramienta)
     * @throws SQLException 
     */
    public static int agregarPrestamoHerramienta(PrestamoHerramienta ph) throws SQLException
    {
        String sql = "{CALL insertarHerramientaPrestamo(?,?,?,?)}";

        CallableStatement cstmt = null;
        Conexion objConn = new Conexion();
        Connection conn = null;
        
        try {
            //Preparamos un statement para ejecutar la consulta
            conn = objConn.abrir();
            cstmt = conn.prepareCall(sql);
            
            //Datos entrada
            cstmt.setString(1, ph.getFotoPretamo());
            cstmt.setInt(2, ph.getPrestamo().getIdPrestamo());
            cstmt.setInt(3, ph.getHerramienta().getIdHerramienta());
            
            //Datos de Salida:
            cstmt.registerOutParameter(4, Types.INTEGER);
            
            //Ejecutamos la consulta
            cstmt.executeUpdate();

            //Almacenamos los datos de salida
            ph.setIdPrestamoHerramienta(cstmt.getInt(4));
            
            cstmt.close();
            return ph.getIdPrestamoHerramienta();
        }
        catch(Exception e)
        {
            if(cstmt != null)
            {
                cstmt.close();
            }
            e.printStackTrace();
            return 0;
        }
        finally
        {
            conn.close();
            objConn.cerrar();
        }
    }
    
    /**
     * <b>Descripción:</b><br>
     * Desactiva un prestamoHerramienta en la base de datos
     * 
     * @param ph (PrestamoHerramienta ha desactivar)
     * @throws SQLException 
     */
    public static void desactivaPrestamoHerramienta(PrestamoHerramienta ph) throws SQLException
    {
        String sql = "{CALL desactivarHerramientaPrestamo(?,?)}";

        CallableStatement cstmt = null;
        Conexion objConn = new Conexion();
        Connection conn = null;
        
        try {
            //Preparamos un statement para ejecutar la consulta
            conn = objConn.abrir();
            cstmt = conn.prepareCall(sql);
            
            //Datos entrada
            cstmt.setInt(1, ph.getIdPrestamoHerramienta());
            cstmt.setInt(2, ph.getHerramienta().getIdHerramienta());
            
            
            //Ejecutamos la consulta
            cstmt.executeUpdate();
            
            cstmt.close();
        }
        catch(Exception e)
        {
            if(cstmt != null)
            {
                cstmt.close();
            }
            e.printStackTrace();
        }
        finally
        {
            conn.close();
            objConn.cerrar();
        }
    }
    
    /**
     * <b>Descripción:</b><br>
     * Devuelve un prestamoHerramienta en la base de datos
     * 
     * @param ph (PrestamoHerramienta ha devolver)
     * @throws SQLException 
     */
    public static void devolverPrestamoHerramienta(PrestamoHerramienta ph) throws SQLException
    {
        String sql = "{CALL devolverHerramientaPrestamo(?,?,?)}";

        CallableStatement cstmt = null;
        Conexion objConn = new Conexion();
        Connection conn = null;
        
        try {
            //Preparamos un statement para ejecutar la consulta
            conn = objConn.abrir();
            cstmt = conn.prepareCall(sql);
            
            //Datos entrada
            cstmt.setInt(1, ph.getIdPrestamoHerramienta());
            cstmt.setInt(2, ph.getHerramienta().getIdHerramienta());
            cstmt.setString(3, ph.getFotoDevolucion());
            
            
            //Ejecutamos la consulta
            cstmt.executeUpdate();
            
            cstmt.close();
        }
        catch(Exception e)
        {
            if(cstmt != null)
            {
                cstmt.close();
            }
            e.printStackTrace();
        }
        finally
        {
            conn.close();
            objConn.cerrar();
        }
    }
}