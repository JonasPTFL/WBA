/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author JP-Laptop
 */
public class RestConstants {
    public static final String PROJECT_PATH = "projekt";
    public static final String AUFGABENBEREICH_PATH = "aufgabenbereich";
    public static final String ARTEFAKT_PATH = "artefakt";
    
    /*
    * Generates a path to a specific object
    */
    public static String createObjectLocationPath(String basePath, Long id){
        return "/"+basePath+"?id="+id;
    }
}
