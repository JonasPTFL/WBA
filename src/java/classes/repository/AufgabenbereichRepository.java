/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.repository;

import classes.Artefakt;
import classes.Aufgabenbereich;
import classes.DatabaseConstants;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AufgabenbereichRepository {
    private static final AufgabenbereichRepository INSTANCE = new AufgabenbereichRepository();
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DatabaseConstants.PU_NAME);
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction utx = em.getTransaction();
    
    public List<Aufgabenbereich> getAufgabenbereiche(){
        Query query = this.em.createNamedQuery(DatabaseConstants.AUFGABENBEREICH_SELECT_ALL, Aufgabenbereich.class);
        return query.getResultList();
    }
    
    public void addAufgabenbereich(Aufgabenbereich aufgabenbereich){
        this.utx.begin();
        this.em.persist(aufgabenbereich);
        this.utx.commit();
    }
    
    public void updateAufgabenbereich(Aufgabenbereich aufgabenbereich){

    }
    
    public Aufgabenbereich getAufgabenbereichById(Long id){
        return this.em.find(Aufgabenbereich.class, id);
    }
    
    public static AufgabenbereichRepository getInstance(){
        return INSTANCE;
    }
}
