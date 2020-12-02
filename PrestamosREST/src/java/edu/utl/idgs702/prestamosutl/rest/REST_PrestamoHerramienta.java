package edu.utl.idgs702.prestamosutl.rest;

import com.google.gson.Gson;
import edu.utl.idgs702.prestamosutl.controlador.ControladorPrestamoHerramienta;
import edu.utl.idgs702.prestamosutl.modelo.PrestamoHerramienta;
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
@Path("prestamoHerramienta")
public class REST_PrestamoHerramienta extends Application
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
            List<PrestamoHerramienta> prestamosHerramienta = ControladorPrestamoHerramienta.getAllPrestamoHerramientas();
            out = parser.toJson(prestamosHerramienta);
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
            List<PrestamoHerramienta> prestamosHerramienta = ControladorPrestamoHerramienta.getPrestamoHerramientasActivas();
            out = parser.toJson(prestamosHerramienta);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllCanceladas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCanceladas()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<PrestamoHerramienta> prestamosHerramienta = ControladorPrestamoHerramienta.getPrestamoHerramientasCanceladas();
            out = parser.toJson(prestamosHerramienta);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllDevueltas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDevueltas()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<PrestamoHerramienta> prestamosHerramienta = ControladorPrestamoHerramienta.getPrestamoHerramientasDevueltas();
            out = parser.toJson(prestamosHerramienta);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllById")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response activarCliente(@QueryParam("idPr") int idPr)
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<PrestamoHerramienta> prestamosHerramienta = ControladorPrestamoHerramienta.getPrestamoHerramientasByPrestamo(idPr);
            out = parser.toJson(prestamosHerramienta);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

}
