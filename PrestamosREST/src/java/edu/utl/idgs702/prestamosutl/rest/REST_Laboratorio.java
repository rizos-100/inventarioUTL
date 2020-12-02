package edu.utl.idgs702.prestamosutl.rest;

import com.google.gson.Gson;
import edu.utl.idgs702.prestamosutl.controlador.ControladorLaboratorio;
import edu.utl.idgs702.prestamosutl.modelo.Laboratorio;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
/**
 * @author Carlos Solís
 * @version 1.0
 */
@Path("laboratorio")
public class REST_Laboratorio extends Application
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
            List<Laboratorio> laboratorios = ControladorLaboratorio.getAllLaboratorios();
            out = parser.toJson(laboratorios);
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
            List<Laboratorio> laboratorios = ControladorLaboratorio.getLaboratoriosActivos();
            out = parser.toJson(laboratorios);
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
            List<Laboratorio> laboratorios = ControladorLaboratorio.getLaboratoriosInactivos();
            out = parser.toJson(laboratorios);
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
    public Response getById(@QueryParam("idL") int idL)
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            Laboratorio laboratorio = ControladorLaboratorio.getLaboratorioById(idL);
            out = parser.toJson(laboratorio);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

}
