
package edu.utl.idgs702.prestamosutl.controlador;

import edu.utl.idgs702.prestamosutl.datos.Conexion;
import edu.utl.idgs702.prestamosutl.modelo.Herramienta;
import edu.utl.idgs702.prestamosutl.modelo.Laboratorio;
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
public class ControladorHerramienta
{
    /**
     * <b>Descripción:</b><br>
     * Consulta todas las herramientas de la base de datos.
     * 
     * @return Herramientas (lista de herramientas)
     */
    public static List<Herramienta> getAllHerramientas()
    {
        String sql = "SELECT * FROM seeHerramientas";
        List<Herramienta> herramientas = new ArrayList<>();
        
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
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
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
                
                herramientas.add(h);
            }
            miC.close();
            return herramientas;
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
     * Consulta todas las herramientas activas de la base de datos.
     * 
     * @return Herramientas (lista de herramientas)
     */
    public static List<Herramienta> getHerramientasActivas()
    {
        String sql = "SELECT * FROM seeHerramientas WHERE estatusH = 1";
        List<Herramienta> herramientas = new ArrayList<>();
        
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
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
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
                
                herramientas.add(h);
            }
            miC.close();
            return herramientas;
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
     * Consulta todas las herramientas inactivas de la base de datos.
     * 
     * @return Herramientas (lista de herramientas)
     */
    public static List<Herramienta> getHerramientasInactivas()
    {
        String sql = "SELECT * FROM seeHerramientas WHERE estatusH = 3";
        List<Herramienta> herramientas = new ArrayList<>();
        
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
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
                l.setIdLaboratorio(r.getInt("idLaboratorio"));
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
                
                herramientas.add(h);
            }
            miC.close();
            return herramientas;
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
     * Consulta todas las herramientas prestadas de la base de datos.
     * 
     * @return Herramientas (lista de herramientas)
     */
    public static List<Herramienta> getHerramientasPrestadas()
    {
        String sql = "SELECT * FROM seeHerramientas WHERE estatusH = 2";
        List<Herramienta> herramientas = new ArrayList<>();
        
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
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
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
                
                herramientas.add(h);
            }
            miC.close();
            return herramientas;
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
     * Consulta una herramienta por su id en la base de datos.
     * 
     * @param idH (id de una herramienta)
     * @return Herramienta
     */
    public static Herramienta getHerramientaById(int idH)
    {
        String sql = "SELECT * FROM seeHerramientas WHERE idHerramientaH = "+idH;
        Herramienta herramienta = new Herramienta();
        
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
                Herramienta h = new Herramienta();
                Laboratorio l = new Laboratorio();
                
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
                
                herramienta = h;
            }
            miC.close();
            return herramienta;
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