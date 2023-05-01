package rest;

import classes.Aufgabenbereich;
import classes.Projekt;
import java.io.Serializable;
import java.net.URI;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;


/**
 * REST interface for executeing imports
 *
 * @author ffehring
 */
@Path("aufgabenbereich")    //Pfad der Ressource wird gesetzt

public class AufgabebereichResource implements Serializable {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("id") Long id) {
        Aufgabenbereich aufgabenbereich = new Aufgabenbereich();
        aufgabenbereich.setId(1l);
        aufgabenbereich.setTitel("aufgabenbereichtitel 1");
        aufgabenbereich.setKurzbeschreibung("Kurze Beschriebung des Aufgabenbereichs");
        ResponseBuilder rb = Response.ok(aufgabenbereich);
        
        return rb.build();
    }
}
