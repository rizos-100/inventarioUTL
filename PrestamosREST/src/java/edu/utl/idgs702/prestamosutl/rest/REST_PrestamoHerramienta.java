package edu.utl.idgs702.prestamosutl.rest;

import com.google.gson.Gson;
import edu.utl.idgs702.prestamosutl.controlador.ControladorPrestamoHerramienta;
import edu.utl.idgs702.prestamosutl.modelo.Herramienta;
import edu.utl.idgs702.prestamosutl.modelo.Prestamo;
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
    public Response getById(@QueryParam("idPr") int idPr)
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

    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("fotoP") String fotoP,
                            @FormParam("idPr") int idPr,
                            @FormParam("idH") int idH) {
        String out = null;
        Gson gson = new Gson();
        
        PrestamoHerramienta ph = new PrestamoHerramienta();
        Prestamo p = new Prestamo();
        Herramienta h = new Herramienta();
        
        p.setIdPrestamo(idPr);
        h.setIdHerramienta(idH);
        
        ph.setFotoPretamo(fotoP);
        ph.setPrestamo(p);
        ph.setHerramienta(h);
        try {
            
            int ng = ControladorPrestamoHerramienta.agregarPrestamoHerramienta(ph);
            out = "{\"result\":" + ng + "}";
            //out = "{\"result\":\"OK\"}"; 
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error:\"" + e.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();

    }
    
    @POST
    @Path("desactivar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response desactivar(@FormParam("idPH") int idPH,
                            @FormParam("idH") int idH) {
        String out = null;
        Gson gson = new Gson();
        try {
            PrestamoHerramienta ph = new PrestamoHerramienta();
            Herramienta h = new Herramienta();
            
            h.setIdHerramienta(idH);
            
            ph.setIdPrestamoHerramienta(idPH);
            ph.setHerramienta(h);
            ControladorPrestamoHerramienta.desactivaPrestamoHerramienta(ph);
            out = "{\"result\":\"OK\"}"; 
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error:\"" + e.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();

    }
    
    @Path("devolver")
    @Produces(MediaType.APPLICATION_JSON)
    public Response devolver(@FormParam("idPH") int idPH,
                            @FormParam("idH") int idH,
                            @FormParam("fotoD") String fotoD) {
        String out = null;
        Gson gson = new Gson();
        try {
            PrestamoHerramienta ph = new PrestamoHerramienta();
            Herramienta h = new Herramienta();
            
            h.setIdHerramienta(idH);
            
            ph.setIdPrestamoHerramienta(idPH);
            ph.setFotoDevolucion(fotoD);
            ph.setHerramienta(h);
            ControladorPrestamoHerramienta.devolverPrestamoHerramienta(ph);
            out = "{\"result\":\"OK\"}"; 
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"error:\"" + e.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();

    }
}
