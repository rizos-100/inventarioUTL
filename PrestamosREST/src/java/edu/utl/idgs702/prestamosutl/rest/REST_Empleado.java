package edu.utl.idgs702.prestamosutl.rest;

import com.google.gson.Gson;
import edu.utl.idgs702.prestamosutl.controlador.ControladorEmpleado;
import edu.utl.idgs702.prestamosutl.modelo.Empleado;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import edu.utl.idgs702.prestamosutl.modelo.Herramienta;
import javax.ws.rs.QueryParam;
/**
 * @author Carlos Solís
 * @version 1.0
 */
@Path("empleado")
public class REST_Empleado extends Application
{
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<Empleado> empleados = ControladorEmpleado.getAllEmpleados();
            out = parser.toJson(empleados);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllActivos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActivos()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<Empleado> empleados = ControladorEmpleado.getEmpleadosActivos();
            out = parser.toJson(empleados);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllInactivos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInactivos()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<Empleado> empleados = ControladorEmpleado.getEmpleadosInactivos();
            out = parser.toJson(empleados);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getById")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@QueryParam("idE") int idE)
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            Empleado empleado = ControladorEmpleado.getEmpleadoById(idE);
            out = parser.toJson(empleado);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

}
