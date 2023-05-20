/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.repository;

import classes.Artefakt;
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

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ProjektRepository {
    private static final ProjektRepository INSTANCE = new ProjektRepository();
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DatabaseConstants.PU_NAME);
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction utx = em.getTransaction();
    
    
    ProjektRepository() {
        // Should fetch all projects from the data source (e.g database)
        // Because of a missing database implementation, the constructor creates some example data
        Projekt p1 = new Projekt();
        p1.setId(1L);
        p1.setTitel("Projekt 1");
        p1.setKurzbeschreibung("Kurzbeschriebung Projekt 1");
        p1.setLogopath("/logo1.jpg");
        p1.setStartdatum(LocalDateTime.now());
        
        Projekt p2 = new Projekt();
        p2.setId(2L);
        p2.setTitel("Projekt 2");
        p2.setKurzbeschreibung("Kurzbeschriebung Projekt 2");
        p2.setLogopath("/logo2.jpg");
        p2.setStartdatum(LocalDateTime.now());
        
        Projekt p3 = new Projekt();
        p3.setId(3L);
        p3.setTitel("Projekt 3");
        p3.setKurzbeschreibung("Kurzbeschriebung Projekt 3");
        p3.setLogopath("/logo3.jpg");
        p3.setStartdatum(LocalDateTime.now());
        
        // add example projects
        try {
            addProjekt(p1);
            addProjekt(p2);
            addProjekt(p3);
        } catch (Exception ex) {
            Logger.getLogger(ProjektRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
    
    public static ProjektRepository getInstance(){
        return INSTANCE;
    }
}
