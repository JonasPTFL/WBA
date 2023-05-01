/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.repository;

import classes.Aufgabenbereich;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AufgabenbereichRepository {
    private static final AufgabenbereichRepository INSTANCE = new AufgabenbereichRepository();
    private final List<Aufgabenbereich> aufgabenbereiche = new ArrayList();
    
    AufgabenbereichRepository() {
        // Should fetch all data from the data source (e.g database)
        // Because of a missing database implementation, the constructor creates some example data
        Aufgabenbereich a1 = new Aufgabenbereich();
        a1.setId(1L);
        a1.setTitel("Aufgabenbereich 1");
        a1.setKurzbeschreibung("Kurzbeschriebung Aufgabenbereich 1");
        
        Aufgabenbereich a2 = new Aufgabenbereich();
        a2.setId(2L);
        a2.setTitel("Aufgabenbereich 2");
        a2.setKurzbeschreibung("Kurzbeschriebung Aufgabenbereich 2");
        
        // add example data to list
        aufgabenbereiche.add(a1);
        aufgabenbereiche.add(a2);
    }
    
    public List<Aufgabenbereich> getAufgabenbereiche(){
        return aufgabenbereiche;
    }
    
    public void addAufgabenbereich(Aufgabenbereich aufgabenbereich){
        aufgabenbereiche.add(aufgabenbereich);
    }
    
    public void updateAufgabenbereich(Aufgabenbereich aufgabenbereich){
        for(int i=0;i<aufgabenbereiche.size();i++){
            if(Objects.equals(aufgabenbereiche.get(i).getId(), aufgabenbereich.getId())){
                aufgabenbereiche.set(i, aufgabenbereich);
            }
        }
    }
    
    public Aufgabenbereich getAufgabenbereichById(Long id){
        return aufgabenbereiche.stream().filter(aufgabenbereich -> Objects.equals(aufgabenbereich.getId(), id)).findFirst().get();
    }
    
    public static AufgabenbereichRepository getInstance(){
        return INSTANCE;
    }
}
