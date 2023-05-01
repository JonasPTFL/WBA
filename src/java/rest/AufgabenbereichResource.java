package rest;

import classes.Aufgabenbereich;
import classes.RestConstants;
import classes.repository.AufgabenbereichRepository;
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


@Path(RestConstants.AUFGABENBEREICH_PATH)
public class AufgabenbereichResource implements Serializable {    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Aufgabenbereich aufgabenbereichResource) {
            AufgabenbereichRepository.getInstance().addAufgabenbereich(aufgabenbereichResource);
            URI location = URI.create(RestConstants.createObjectLocationPath(RestConstants.AUFGABENBEREICH_PATH, aufgabenbereichResource.getId()));
            ResponseBuilder rb = Response.ok(location);
            return rb.build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Aufgabenbereich aufgabenbereichResource) {
            AufgabenbereichRepository.getInstance().updateAufgabenbereich(aufgabenbereichResource);
            URI location = URI.create(RestConstants.createObjectLocationPath(RestConstants.AUFGABENBEREICH_PATH, aufgabenbereichResource.getId()));
            ResponseBuilder rb = Response.ok(location);
            return rb.build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("id") Long id) {
        ResponseBuilder rb = Response.ok(AufgabenbereichRepository.getInstance().getAufgabenbereichById(id));
        return rb.build();
    }
    
    
    @GET
    @Path("liste")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        ResponseBuilder rb = Response.ok(AufgabenbereichRepository.getInstance().getAufgabenbereiche());
        return rb.build();
    }
}
