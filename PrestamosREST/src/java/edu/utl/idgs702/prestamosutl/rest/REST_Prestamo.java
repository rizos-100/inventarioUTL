package edu.utl.idgs702.prestamosutl.rest;

import com.google.gson.Gson;
import edu.utl.idgs702.prestamosutl.controlador.ControladorPrestamo;
import edu.utl.idgs702.prestamosutl.modelo.Prestamo;
import java.sql.Date;
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
@Path("prestamo")
public class REST_Prestamo extends Application
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
            List<Prestamo> prestamos = ControladorPrestamo.getAllPrestamos();
            out = parser.toJson(prestamos);
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
            List<Prestamo> prestamos = ControladorPrestamo.getPrestamosActivos();
            out = parser.toJson(prestamos);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllDevueltos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDevueltos()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<Prestamo> prestamos = ControladorPrestamo.getPrestamosDevuelto();
            out = parser.toJson(prestamos);
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
    public Response getById(@QueryParam("idP") int idP)
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            Prestamo prestamo = ControladorPrestamo.getPrestamosById(idP);
            out = parser.toJson(prestamo);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("prestamo") String jsonPrestamo) {
        String out = null;
        Gson gson = new Gson();
        Prestamo pr = null;
        //s = gson.fromJson(jsonServicio, Servicio.class);
        try {
            pr = gson.fromJson(jsonPrestamo, Prestamo.class);
            
            int ng = ControladorPrestamo.agregarPrestamo(pr);
            out = "{\"result\":" + ng + "}";
            //out = "{\"result\":\"OK\"}"; 
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error:\"" + e.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();

    }
    
    @POST
    @Path("terminar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response terminar(@FormParam("idP") int idP,
                             @FormParam("obvs") String obvs) {
        String out = null;
        Gson gson = new Gson();
        //s = gson.fromJson(jsonServicio, Servicio.class);
        try {
            Prestamo pr = new Prestamo();
            pr.setIdPrestamo(idP);
            pr.setObservaciones(obvs);
            ControladorPrestamo.terminarPrestamo(pr);
            out = "{\"result\":\"OK\"}"; 
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error:\"" + e.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();

    }

}
