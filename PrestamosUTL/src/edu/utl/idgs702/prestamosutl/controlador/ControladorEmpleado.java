
package edu.utl.idgs702.prestamosutl.controlador;

import edu.utl.idgs702.prestamosutl.datos.Conexion;
import edu.utl.idgs702.prestamosutl.modelo.Empleado;
import edu.utl.idgs702.prestamosutl.modelo.Laboratorio;
import edu.utl.idgs702.prestamosutl.modelo.Persona;
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
public class ControladorEmpleado
{
    /**
     * <b>Descripción:</b><br>
     * Consulta todas los Empleados de la base de datos.
     * 
     * @return Empleados (lista de Empleados)
     */
    public static List<Empleado> getAllEmpleados()
    {
        String sql = "SELECT * FROM seeEmpleados";
        List<Empleado> empleados = new ArrayList<>();
        
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
                Empleado e = new Empleado();
                Persona p = new Persona();
                Laboratorio l = new Laboratorio();
                
                l.setIdLaboratorio(r.getInt("idLaboratorioE"));
                l.setNombre(r.getString("nombreLE"));
                l.setUbicacion(r.getString("ubicacionE"));
                l.setEstatus(r.getInt("estatusLE"));
                
                p.setIdPersona(r.getInt("idPersonaE"));
                p.setNombre(r.getString("nombreE"));
                p.setApellidoPaterno(r.getString("apellidoPaternoE"));
                p.setApellidoMaterno(r.getString("apellidoMaternoE"));
                p.setCorreo(r.getString("correoE"));
                p.setTelefono(r.getString("telefonoE"));
                p.setEstado(r.getString("estadoE"));
                p.setMunicipio(r.getString("municipioE"));
                p.setCalleNum(r.getString("calleNumE"));
                
                e.setIdEmpleado(r.getInt("idEmpleadoE"));
                e.setPuesto(r.getString("puestoE"));
                e.setArea(r.getString("areaE"));
                e.setUsuario(r.getString("usuarioE"));
                e.setContrasena(r.getString("contraseniaE"));
                e.setEstatus(r.getInt("estatusE"));
                e.setLaboratorio(l);
                e.setPersona(p);
                
                empleados.add(e);
            }
            miC.close();
            return empleados;
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
     * Consulta todos los Empleados activos de la base de datos.
     * 
     * @return Empleados (lista de Empleados)
     */
    public static List<Empleado> getEmpleadosActivos()
    {
        String sql = "SELECT * FROM seeEmpleados WHERE estatusE = 1";
        List<Empleado> empleados = new ArrayList<>();
        
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
                Empleado e = new Empleado();
                Persona p = new Persona();
                Laboratorio l = new Laboratorio();
                
                l.setIdLaboratorio(r.getInt("idLaboratorioE"));
                l.setNombre(r.getString("nombreLE"));
                l.setUbicacion(r.getString("ubicacionE"));
                l.setEstatus(r.getInt("estatusLE"));
                
                p.setIdPersona(r.getInt("idPersonaE"));
                p.setNombre(r.getString("nombreE"));
                p.setApellidoPaterno(r.getString("apellidoPaternoE"));
                p.setApellidoMaterno(r.getString("apellidoMaternoE"));
                p.setCorreo(r.getString("correoE"));
                p.setTelefono(r.getString("telefonoE"));
                p.setEstado(r.getString("estadoE"));
                p.setMunicipio(r.getString("municipioE"));
                p.setCalleNum(r.getString("calleNumE"));
                
                e.setIdEmpleado(r.getInt("idEmpleadoE"));
                e.setPuesto(r.getString("puestoE"));
                e.setArea(r.getString("areaE"));
                e.setUsuario(r.getString("usuarioE"));
                e.setContrasena(r.getString("contraseniaE"));
                e.setEstatus(r.getInt("estatusE"));
                e.setLaboratorio(l);
                e.setPersona(p);
                
                empleados.add(e);
            }
            miC.close();
            return empleados;
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
     * Consulta todos los Empleados inactivos de la base de datos.
     * 
     * @return Empleados (lista de Empleados)
     */
    public static List<Empleado> getEmpleadosInactivos()
    {
        String sql = "SELECT * FROM seeEmpleados WHERE estatusE = 2";
        List<Empleado> empleados = new ArrayList<>();
        
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
                Empleado e = new Empleado();
                Persona p = new Persona();
                Laboratorio l = new Laboratorio();
                
                l.setIdLaboratorio(r.getInt("idLaboratorioE"));
                l.setNombre(r.getString("nombreLE"));
                l.setUbicacion(r.getString("ubicacionE"));
                l.setEstatus(r.getInt("estatusLE"));
                
                p.setIdPersona(r.getInt("idPersonaE"));
                p.setNombre(r.getString("nombreE"));
                p.setApellidoPaterno(r.getString("apellidoPaternoE"));
                p.setApellidoMaterno(r.getString("apellidoMaternoE"));
                p.setCorreo(r.getString("correoE"));
                p.setTelefono(r.getString("telefonoE"));
                p.setEstado(r.getString("estadoE"));
                p.setMunicipio(r.getString("municipioE"));
                p.setCalleNum(r.getString("calleNumE"));
                
                e.setIdEmpleado(r.getInt("idEmpleadoE"));
                e.setPuesto(r.getString("puestoE"));
                e.setArea(r.getString("areaE"));
                e.setUsuario(r.getString("usuarioE"));
                e.setContrasena(r.getString("contraseniaE"));
                e.setEstatus(r.getInt("estatusE"));
                e.setLaboratorio(l);
                e.setPersona(p);
                
                empleados.add(e);
            }
            miC.close();
            return empleados;
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
     * Consulta un Empleado por su id en la base de datos
     * 
     * @param idE (id de un empleado)
     * @return Herramienta
     */
    public static Empleado getEmpleadoById(int idE)
    {
        String sql = "SELECT * FROM seeEmpleados WHERE idEmpleadoE = "+idE;
        Empleado empleado = new Empleado();
        
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
                Empleado e = new Empleado();
                Persona p = new Persona();
                Laboratorio l = new Laboratorio();
                
                l.setIdLaboratorio(r.getInt("idLaboratorioE"));
                l.setNombre(r.getString("nombreLE"));
                l.setUbicacion(r.getString("ubicacionE"));
                l.setEstatus(r.getInt("estatusLE"));
                
                p.setIdPersona(r.getInt("idPersonaE"));
                p.setNombre(r.getString("nombreE"));
                p.setApellidoPaterno(r.getString("apellidoPaternoE"));
                p.setApellidoMaterno(r.getString("apellidoMaternoE"));
                p.setCorreo(r.getString("correoE"));
                p.setTelefono(r.getString("telefonoE"));
                p.setEstado(r.getString("estadoE"));
                p.setMunicipio(r.getString("municipioE"));
                p.setCalleNum(r.getString("calleNumE"));
                
                e.setIdEmpleado(r.getInt("idEmpleadoE"));
                e.setPuesto(r.getString("puestoE"));
                e.setArea(r.getString("areaE"));
                e.setUsuario(r.getString("usuarioE"));
                e.setContrasena(r.getString("contraseniaE"));
                e.setEstatus(r.getInt("estatusE"));
                e.setLaboratorio(l);
                e.setPersona(p);
                
                empleado = e;
            }
            miC.close();
            return empleado;
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