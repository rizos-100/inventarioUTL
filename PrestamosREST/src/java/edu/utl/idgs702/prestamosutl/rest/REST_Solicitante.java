package edu.utl.idgs702.prestamosutl.rest;

import com.google.gson.Gson;
import edu.utl.idgs702.prestamosutl.controlador.ControladorSolicitante;
import edu.utl.idgs702.prestamosutl.modelo.Solicitante;
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
@Path("solicitante")
public class REST_Solicitante extends Application
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
            List<Solicitante> solicitantes = ControladorSolicitante.getAllSolicitantes();
            out = parser.toJson(solicitantes);
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
            List<Solicitante> solicitantes = ControladorSolicitante.getSolicitantesActivos();
            out = parser.toJson(solicitantes);
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
            List<Solicitante> solicitantes = ControladorSolicitante.getSolicitantesInactivos();
            out = parser.toJson(solicitantes);
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
    public Response activarCliente(@QueryParam("idS") int idS)
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            Solicitante solicitante = ControladorSolicitante.getSolicitanteById(idS);
            out = parser.toJson(solicitante);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

}
