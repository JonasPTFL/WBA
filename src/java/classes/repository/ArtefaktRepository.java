/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.repository;

import classes.Artefakt;
import classes.Projekt;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ArtefaktRepository {
    private static final ArtefaktRepository INSTANCE = new ArtefaktRepository();
    

    @PersistenceContext(unitName = "JPA_ExamplePU")   //Entity Manager muss vom Payara zum Start in einer REST-Ressource gefunden werden
    private EntityManager em;

    @Resource
    private UserTransaction utx;
    
    ArtefaktRepository() {
        // Should fetch all data from the data source (e.g database)
        // Because of a missing database implementation, the constructor creates some example data
        Artefakt a1 = new Artefakt();
        a1.setId(1L);
        a1.setTitel("Artefakt 1");
        a1.setGeplanteArbeitszeit(5);
        a1.setKurzbeschreibung("Kurzbeschriebung Artefakt 1");
        
        Artefakt a2 = new Artefakt();
        a2.setId(2L);
        a2.setTitel("Artefakt 2");
        a2.setGeplanteArbeitszeit(3);
        a2.setKurzbeschreibung("Kurzbeschriebung Artefakt 2");
        
        // add example data to list
        //artefakte.add(a1);
        //artefakte.add(a2);
    }
    
    public List<Artefakt> getArtefakte(){
        Query query = this.em.createNamedQuery("Artefakt.findAll", Artefakt.class); 
        return query.getResultList();
    }
    
    public void addArtefakt(Artefakt aufgabenbereich) throws Exception{
        try {
            this.utx.begin();
            this.em.persist(aufgabenbereich);
            this.utx.commit();

        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            throw new Exception("Error occurred while storing object");
        }
    }
    
    public void updateArtefakt(Artefakt aufgabenbereich){
        // TODO implement
    }
    
    public Artefakt getArtefaktById(Long id){
        return this.em.find(Artefakt.class, id);
    }
    
    public Artefakt getArtefaktByTitel(Long id){
        Query query = this.em.createNamedQuery("Artefakt.findByTitel", Artefakt.class); 
        query.setParameter("id", id); 
        return (Artefakt) query.getSingleResult();
    }
    
    public static ArtefaktRepository getInstance(){
        return INSTANCE;
    }
}
