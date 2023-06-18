/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.repository;

import classes.Artefakt;
import classes.DatabaseConstants;
import classes.Projekt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.net.URI;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;
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
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ArtefaktRepository {
    private static final ArtefaktRepository INSTANCE = new ArtefaktRepository();
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DatabaseConstants.PU_NAME);
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction utx = em.getTransaction();
    
    public List<Artefakt> getArtefakte(){
        Query query = this.em.createNamedQuery(DatabaseConstants.ARTEFAKT_SELECT_ALL, Artefakt.class);
        return query.getResultList();
    }
    
    public void addArtefakt(Artefakt aufgabenbereich) throws Exception {
        this.utx.begin();
        this.em.persist(aufgabenbereich);
        this.utx.commit();
    }
    
    public void updateArtefakt(Artefakt artefakt) throws Exception {
        Artefakt a = this.em.getReference(Artefakt.class, artefakt.getId());
        
        
        this.utx.begin();
        a.setGeplanteArbeitszeit(artefakt.getGeplanteArbeitszeit());
        a.setKurzbeschreibung(artefakt.getKurzbeschreibung());
        a.setTatsaechlicheArbeitszeit(artefakt.getTatsaechlicheArbeitszeit());
        a.setKurzbeschreibung(artefakt.getKurzbeschreibung());
        a.setZugehoerigerAufgabenbeeich(artefakt.getZugehoerigerAufgabenbeeich());
        this.utx.commit();
    }
    
    public Artefakt getArtefaktById(Long id){
        return this.em.find(Artefakt.class, id);
    }
    
    public List<Artefakt> getArtefaktByTitle(String titel){
        Query query = this.em.createNamedQuery(DatabaseConstants.ARTEFAKT_FILTER_TITLE, Artefakt.class);
        query.setParameter("titel", "%" + titel + "%");
        return query.getResultList();
    }
    
    public static ArtefaktRepository getInstance(){
        return INSTANCE;
    }
}
