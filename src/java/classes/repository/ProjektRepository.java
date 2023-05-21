/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.repository;

import classes.Artefakt;
import classes.Aufgabenbereich;
import classes.DatabaseConstants;
import classes.Projekt;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import rest.ProjektResource;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ProjektRepository {
    private static final ProjektRepository INSTANCE = new ProjektRepository();
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DatabaseConstants.PU_NAME);
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction utx = em.getTransaction();
    
    public List<Projekt> getProjekte(){
        Query query = this.em.createNamedQuery(DatabaseConstants.PROJEKT_SELECT_ALL, Projekt.class);
        return query.getResultList();
    }
    
    public void addProjekt(Projekt projekt) throws Exception {
        this.utx.begin();
        this.em.persist(projekt);
        this.utx.commit();
    }
    
    public void updateProjekt(Projekt projekt){
    }
    
    public Projekt getProjektById(Long id){
        return this.em.find(Projekt.class, id);
    }
    
    public List<Projekt> getProjekteByTitle(String titel){
        Query query = this.em.createNamedQuery(DatabaseConstants.PROJEKT_FILTER_TITLE, Projekt.class);
        query.setParameter("titel", "%" + titel + "%");
        return query.getResultList();
    }
    
    public List<Projekt> getArchivierteProjekteByTitle(String titel){
        Query query = this.em.createNamedQuery(DatabaseConstants.PROJEKT_FILTER_ARCHIVIERT_TITLE, Projekt.class);
        query.setParameter("titel", "%" + titel + "%");
        return query.getResultList();
    }
    
    public List<Projekt> getArchivierteProjekte(){
        Query query = this.em.createNamedQuery(DatabaseConstants.PROJEKT_SELECT_ARCHIVIERT, Projekt.class);
        return query.getResultList();
    }
    
    public static ProjektRepository getInstance(){
        return INSTANCE;
    }
}
