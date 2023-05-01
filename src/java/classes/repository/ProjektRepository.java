/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.repository;

import classes.Projekt;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjektRepository {
    private static final ProjektRepository INSTANCE = new ProjektRepository();
    private final List<Projekt> projekte = new ArrayList();
    
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
        
        // add example projects to list 
        projekte.add(p1);
        projekte.add(p2);
        projekte.add(p3);
    }
    
    public List<Projekt> getProjekte(){
        return projekte;
    }
    
    public void addProjekt(Projekt projekt){
        projekte.add(projekt);
    }
    
    public void updateProjekt(Projekt projekt){
        for(int i=0;i<projekte.size();i++){
            if(Objects.equals(projekte.get(i).getId(), projekt.getId())){
                projekte.set(i, projekt);
            }
        }
    }
    
    public Projekt getProjektById(Long id){
        return projekte.stream().filter(projekt -> Objects.equals(projekt.getId(), id)).findFirst().get();
    }
    
    public static ProjektRepository getInstance(){
        return INSTANCE;
    }
}
