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
public class ControladorLaboratorio {

    /**
     * <b>Descripción:</b><br>
     * Consulta todos los Laboratorios de la base de datos.
     *
     * @return Laboratorios (lista de Laboratorios)
     */
    public static List<Laboratorio> getAllLaboratorios() {
        String sql = "SELECT * FROM seeLaboratorios";
        List<Laboratorio> laboratorios = new ArrayList<>();

        Conexion c = new Conexion();
        Connection miC = null;
        Statement t;
        ResultSet r;

        try {
            t = null;
            miC = c.abrir();
            t = miC.createStatement();
            r = t.executeQuery(sql);
            r.beforeFirst();
            while (r.next()) {
                Empleado e = new Empleado();
                Persona p = new Persona();
                Laboratorio l = new Laboratorio();

                l.setIdLaboratorio(r.getInt("idLaboratorioL"));
                l.setNombre(r.getString("nombreL"));
                l.setUbicacion(r.getString("ubicacionL"));
                l.setEstatus(r.getInt("estatusL"));

                laboratorios.add(l);
            }
            miC.close();
            return laboratorios;
        } catch (Exception e) {
            e.printStackTrace();
            if (miC == null) {
                c.cerrar();
            }
            return null;
        } finally {
            c.cerrar();
        }
    }

    /**
     * <b>Descripción:</b><br>
     * Consulta todos los Laboratorios activos de la base de datos.
     *
     * @return Laboratorios (lista de Laboratorios)
     */
    public static List<Laboratorio> getLaboratoriosActivos() {
        String sql = "SELECT * FROM seeLaboratorios WHERE estatusL = 1";
        List<Laboratorio> laboratorios = new ArrayList<>();

        Conexion c = new Conexion();
        Connection miC = null;
        Statement t;
        ResultSet r;

        try {
            t = null;
            miC = c.abrir();
            t = miC.createStatement();
            r = t.executeQuery(sql);
            r.beforeFirst();
            while (r.next()) {
                Empleado e = new Empleado();
                Persona p = new Persona();
                Laboratorio l = new Laboratorio();

                l.setIdLaboratorio(r.getInt("idLaboratorioL"));
                l.setNombre(r.getString("nombreL"));
                l.setUbicacion(r.getString("ubicacionL"));
                l.setEstatus(r.getInt("estatusL"));

                laboratorios.add(l);
            }
            miC.close();
            return laboratorios;
        } catch (Exception e) {
            e.printStackTrace();
            if (miC == null) {
                c.cerrar();
            }
            return null;
        } finally {
            c.cerrar();
        }
    }

    /**
     * <b>Descripción:</b><br>
     * Consulta todos los Laboratorios inactivos de la base de datos.
     *
     * @return Laboratorios (lista de Laboratorios)
     */
    public static List<Laboratorio> getLaboratoriosInactivos() {
        String sql = "SELECT * FROM seeLaboratorios WHERE estatusL = 2";
        List<Laboratorio> laboratorios = new ArrayList<>();

        Conexion c = new Conexion();
        Connection miC = null;
        Statement t;
        ResultSet r;

        try {
            t = null;
            miC = c.abrir();
            t = miC.createStatement();
            r = t.executeQuery(sql);
            r.beforeFirst();
            while (r.next()) {
                Empleado e = new Empleado();
                Persona p = new Persona();
                Laboratorio l = new Laboratorio();

                l.setIdLaboratorio(r.getInt("idLaboratorioL"));
                l.setNombre(r.getString("nombreL"));
                l.setUbicacion(r.getString("ubicacionL"));
                l.setEstatus(r.getInt("estatusL"));

                laboratorios.add(l);
            }
            miC.close();
            return laboratorios;
        } catch (Exception e) {
            e.printStackTrace();
            if (miC == null) {
                c.cerrar();
            }
            return null;
        } finally {
            c.cerrar();
        }
    }

    /**
     * <b>Descripción:</b><br>
     * Consulta un Laboratorio por su id en la base de datos.
     *
     * @param idL (id de un laboratorio)
     * @return Laboratorio
     */
    public static Laboratorio getEmpleadoById(int idL) {
        String sql = "SELECT * FROM seeLaboratorios WHERE idLaboratorioL = " + idL;
        Laboratorio laboratorio = new Laboratorio();

        Conexion c = new Conexion();
        Connection miC = null;
        Statement t;
        ResultSet r;

        try {
            t = null;
            miC = c.abrir();
            t = miC.createStatement();
            r = t.executeQuery(sql);
            r.beforeFirst();
            while (r.next()) {
                Empleado e = new Empleado();
                Persona p = new Persona();
                Laboratorio l = new Laboratorio();

                l.setIdLaboratorio(r.getInt("idLaboratorioL"));
                l.setNombre(r.getString("nombreL"));
                l.setUbicacion(r.getString("ubicacionL"));
                l.setEstatus(r.getInt("estatusL"));

                laboratorio = l;
            }
            miC.close();
            return laboratorio;
        } catch (Exception e) {
            e.printStackTrace();
            if (miC == null) {
                c.cerrar();
            }
            return null;
        } finally {
            c.cerrar();
        }
    }
}
