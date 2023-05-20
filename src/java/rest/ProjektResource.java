package rest;

import classes.Projekt;
import classes.repository.ProjektRepository;
import java.io.Serializable;
import java.net.URI;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * REST interface for executeing imports
 *
 * @author ffehring
 */
@Path(RestConstants.PROJECT_PATH)    //Pfad der Ressource wird gesetzt
public class ProjektResource implements Serializable {    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(ProjektAdapter pa) {
        try {
             //adapter in Objekt umwandeln - Adapater zur Umwandlung des Datums von JSON und für Referenzen notwendig
            Projekt proj = pa.toProject();
            ProjektRepository.getInstance().addProjekt(proj);
            URI location = URI.create(RestConstants.createObjectLocationPath(RestConstants.PROJECT_PATH, proj.getId()));
            ResponseBuilder rb = Response.ok(location); // mit created erfolgt hier keine Ausgabe?!
            return rb.build();
        } catch (Exception ex) {
            Logger.getLogger(ProjektResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok(ex.toString()).build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(ProjektAdapter pa) {
             //adapter in Objekt umwandeln - Adapater zur Umwandlung des Datums von JSON und für Referenzen notwendig
            Projekt proj = pa.toProject();
            ProjektRepository.getInstance().updateProjekt(proj);
            URI location = URI.create(RestConstants.createObjectLocationPath(RestConstants.PROJECT_PATH, proj.getId()));
            ResponseBuilder rb = Response.ok(location);
            return rb.build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("id") Long id) {
        ResponseBuilder rb = Response.ok(ProjektRepository.getInstance().getProjektById(id));
        return rb.build();
    }
    
    
    @GET
    @Path("liste")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        ResponseBuilder rb = Response.ok(ProjektRepository.getInstance().getProjekte());
        return rb.build();
    }
}
