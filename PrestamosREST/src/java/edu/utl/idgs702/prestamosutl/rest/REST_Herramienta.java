package edu.utl.idgs702.prestamosutl.rest;

import com.google.gson.Gson;
import edu.utl.idgs702.prestamosutl.controlador.ControladorHerramienta;
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
@Path("herramienta")
public class REST_Herramienta extends Application
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
            List<Herramienta> herramientas = ControladorHerramienta.getAllHerramientas();
            out = parser.toJson(herramientas);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllActivas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActivas()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<Herramienta> herramientas = ControladorHerramienta.getHerramientasActivas();
            out = parser.toJson(herramientas);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllInactivas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInactivas()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<Herramienta> herramientas = ControladorHerramienta.getHerramientasInactivas();
            out = parser.toJson(herramientas);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllPrestadas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPrestadas()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<Herramienta> herramientas = ControladorHerramienta.getHerramientasPrestadas();
            out = parser.toJson(herramientas);
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
    public Response getById(@QueryParam("idH") int idH)
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            Herramienta herramienta = ControladorHerramienta.getHerramientaById(idH);
            out = parser.toJson(herramienta);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

}
