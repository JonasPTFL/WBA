package rest;

import classes.Projekt;
import java.io.Serializable;
import java.net.URI;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
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
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@Path("test")    //Pfad der Ressource wird gesetzt

public class VerbindungZuDBinRESTBeispiel implements Serializable {
    @PersistenceContext(unitName = "JPA_ExamplePU")   //Entity Manager muss vom Payara zum Start in einer REST-Ressource gefunden werden
    private EntityManager em;
    

    @Resource
    private UserTransaction utx;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(ProjektAdapter pa) {      

      try {
            this.utx.begin();
            // Useing adapter to create a persistable object
            Projekt proj = pa.toProject();  
            this.em.persist(proj);          // em speichert in die Tabelle tbl_Project
            this.utx.commit();
            
            URI location = URI.create("/projekt?id=" + proj.getId());  // hier kann man das angelegte abrufen
            ResponseBuilder rb = Response.created(location);   // response 201 für cerated
            // Example for createing a HATEOAS link
            URI delLocLink = URI.create("/projekt/delete?id=" + proj.getId()); //hier kann man das angelegte löschen
            rb.link(delLocLink, "delete");
            return rb.build();

        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            // Better to add a error message here...
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response get(@QueryParam("id") Long id) {
        
        Projekt proj = this.em.find(Projekt.class, id);  // holt JPA-Objekt mit id = ? aus der DB
        ResponseBuilder rb = Response.ok(proj);
        
        return rb.build();
    }
}
