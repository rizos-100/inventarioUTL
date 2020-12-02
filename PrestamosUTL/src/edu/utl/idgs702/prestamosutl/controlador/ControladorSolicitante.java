
package edu.utl.idgs702.prestamosutl.controlador;

import edu.utl.idgs702.prestamosutl.datos.Conexion;
import edu.utl.idgs702.prestamosutl.modelo.Empleado;
import edu.utl.idgs702.prestamosutl.modelo.Laboratorio;
import edu.utl.idgs702.prestamosutl.modelo.Persona;
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
public class ControladorSolicitante
{
    /**
     * <b>Descripción:</b><br>
     * Consulta todos los Solicitantes de la base de datos.
     * 
     * @return Solicitantes (lista de Solicitantes)
     */
    public static List<Solicitante> getAllSolicitantes()
    {
        String sql = "SELECT * FROM seeSolicitantes";
        List<Solicitante> solicitantes = new ArrayList<>();
        
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
                Solicitante s = new Solicitante();
                Persona p = new Persona();
                
                p.setIdPersona(r.getInt("idPersonaS"));
                p.setNombre(r.getString("nombreS"));
                p.setApellidoPaterno(r.getString("apellidoPaternoS"));
                p.setApellidoMaterno(r.getString("apellidoMaternoS"));
                p.setCorreo(r.getString("correoS"));
                p.setTelefono(r.getString("telefonoS"));
                p.setEstado(r.getString("estadoS"));
                p.setMunicipio(r.getString("municipioS"));
                p.setCalleNum(r.getString("calleNumS"));
                
                s.setIdSolicitante(r.getInt("idSolicitanteS"));
                s.setArea(r.getString("areaS"));
                s.setTipo(r.getString("tipoS"));
                s.setEstatus(r.getInt("estatusS"));
                s.setPersona(p);
                
                solicitantes.add(s);
            }
            miC.close();
            return solicitantes;
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
     * Consulta todos los Solicitantes activos de la base de datos.
     * 
     * @return Solicitantes (lista de Solicitantes)
     */
    public static List<Solicitante> getSolicitantesActivos()
    {
        String sql = "SELECT * FROM seeSolicitantes WHERE estatusS = 1";
        List<Solicitante> solicitantes = new ArrayList<>();
        
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
                Solicitante s = new Solicitante();
                Persona p = new Persona();
                
                p.setIdPersona(r.getInt("idPersonaS"));
                p.setNombre(r.getString("nombreS"));
                p.setApellidoPaterno(r.getString("apellidoPaternoS"));
                p.setApellidoMaterno(r.getString("apellidoMaternoS"));
                p.setCorreo(r.getString("correoS"));
                p.setTelefono(r.getString("telefonoS"));
                p.setEstado(r.getString("estadoS"));
                p.setMunicipio(r.getString("municipioS"));
                p.setCalleNum(r.getString("calleNumS"));
                
                s.setIdSolicitante(r.getInt("idSolicitanteS"));
                s.setArea(r.getString("areaS"));
                s.setTipo(r.getString("tipoS"));
                s.setEstatus(r.getInt("estatusS"));
                s.setPersona(p);
                
                solicitantes.add(s);
            }
            miC.close();
            return solicitantes;
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
     * Consulta todos los Solicitantes inactivos de la base de datos.
     * 
     * @return Solicitantes (lista de Solicitantes)
     */
    public static List<Solicitante> getSolicitantesInactivos()
    {
        String sql = "SELECT * FROM seeSolicitantes WHERE estatusS = 2";
        List<Solicitante> solicitantes = new ArrayList<>();
        
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
                Solicitante s = new Solicitante();
                Persona p = new Persona();
                
                p.setIdPersona(r.getInt("idPersonaS"));
                p.setNombre(r.getString("nombreS"));
                p.setApellidoPaterno(r.getString("apellidoPaternoS"));
                p.setApellidoMaterno(r.getString("apellidoMaternoS"));
                p.setCorreo(r.getString("correoS"));
                p.setTelefono(r.getString("telefonoS"));
                p.setEstado(r.getString("estadoS"));
                p.setMunicipio(r.getString("municipioS"));
                p.setCalleNum(r.getString("calleNumS"));
                
                s.setIdSolicitante(r.getInt("idSolicitanteS"));
                s.setArea(r.getString("areaS"));
                s.setTipo(r.getString("tipoS"));
                s.setEstatus(r.getInt("estatusS"));
                s.setPersona(p);
                
                solicitantes.add(s);
            }
            miC.close();
            return solicitantes;
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
     * Consulta un Solicitante por su id en la base de datos.
     * 
     * @param  idS (id de un solicitante)
     * @return Solicitante
     */
    public static Solicitante getSolicitanteById(int idS)
    {
        String sql = "SELECT * FROM seeSolicitantes WHERE idSolicitanteS = "+idS;
        Solicitante solicitante = new Solicitante();
        
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
                Solicitante s = new Solicitante();
                Persona p = new Persona();
                
                p.setIdPersona(r.getInt("idPersonaS"));
                p.setNombre(r.getString("nombreS"));
                p.setApellidoPaterno(r.getString("apellidoPaternoS"));
                p.setApellidoMaterno(r.getString("apellidoMaternoS"));
                p.setCorreo(r.getString("correoS"));
                p.setTelefono(r.getString("telefonoS"));
                p.setEstado(r.getString("estadoS"));
                p.setMunicipio(r.getString("municipioS"));
                p.setCalleNum(r.getString("calleNumS"));
                
                s.setIdSolicitante(r.getInt("idSolicitanteS"));
                s.setArea(r.getString("areaS"));
                s.setTipo(r.getString("tipoS"));
                s.setEstatus(r.getInt("estatusS"));
                s.setPersona(p);
                
                solicitante = s;
            }
            miC.close();
            return solicitante;
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