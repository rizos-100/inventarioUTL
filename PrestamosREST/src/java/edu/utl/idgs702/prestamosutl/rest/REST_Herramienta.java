package edu.utl.idgs702.prestamosutl.rest;

import com.google.gson.Gson;
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
/**
 * @author Carlos Solís
 * @version 1.0
 */
@Path("herramienta")
public class REST_Herramienta extends Application
{
    @Path("getAllActivos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActivos()
    {
        String out = "";
        try
        {
            Gson parser = new Gson();
            List<Herramienta> herramientas = null;
            out = parser.toJson(herramientas);
        }
        catch(Exception e)
        {
            out = "{\"error\":\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

}
