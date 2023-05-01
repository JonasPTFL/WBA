/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.repository;

import classes.Artefakt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArtefaktRepository {
    private static final ArtefaktRepository INSTANCE = new ArtefaktRepository();
    private final List<Artefakt> artefakte = new ArrayList();
    
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
        artefakte.add(a1);
        artefakte.add(a2);
    }
    
    public List<Artefakt> getArtefakte(){
        return artefakte;
    }
    
    public void addArtefakt(Artefakt aufgabenbereich){
        artefakte.add(aufgabenbereich);
    }
    
    public void updateArtefakt(Artefakt aufgabenbereich){
        for(int i=0;i<artefakte.size();i++){
            if(Objects.equals(artefakte.get(i).getId(), aufgabenbereich.getId())){
                artefakte.set(i, aufgabenbereich);
            }
        }
    }
    
    public Artefakt getArtefaktById(Long id){
        return artefakte.stream().filter(aufgabenbereich -> Objects.equals(aufgabenbereich.getId(), id)).findFirst().get();
    }
    
    public static ArtefaktRepository getInstance(){
        return INSTANCE;
    }
}
