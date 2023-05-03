package rest;

import classes.Artefakt;
import classes.repository.ArtefaktRepository;
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


@Path(RestConstants.ARTEFAKT_PATH)
public class ArtefaktResource implements Serializable {    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Artefakt aufgabenbereichResource) {
            ArtefaktRepository.getInstance().addArtefakt(aufgabenbereichResource);
            URI location = URI.create(RestConstants.createObjectLocationPath(RestConstants.ARTEFAKT_PATH, aufgabenbereichResource.getId()));
            ResponseBuilder rb = Response.ok(location);
            return rb.build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Artefakt aufgabenbereichResource) {
            ArtefaktRepository.getInstance().updateArtefakt(aufgabenbereichResource);
            URI location = URI.create(RestConstants.createObjectLocationPath(RestConstants.ARTEFAKT_PATH, aufgabenbereichResource.getId()));
            ResponseBuilder rb = Response.ok(location);
            return rb.build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("id") Long id) {
        ResponseBuilder rb = Response.ok(ArtefaktRepository.getInstance().getArtefaktById(id));
        return rb.build();
    }
    
    
    @GET
    @Path("liste")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        ResponseBuilder rb = Response.ok(ArtefaktRepository.getInstance().getArtefakte());
        return rb.build();
    }
}
