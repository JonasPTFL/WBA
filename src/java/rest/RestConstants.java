/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest;

/**
 *
 * @author JP-Laptop
 */
public class RestConstants {
    public static final String APPLICATION_PATH = "api";
    public static final String PROJECT_PATH = "projekte";
    public static final String AUFGABENBEREICH_PATH = "aufgabenbereiche";
    public static final String ARTEFAKT_PATH = "artefakte";
    
    /*
    * Generates a path to a specific object
    */
    public static String createObjectLocationPath(String basePath, Long id){
        return "/"+basePath+"?id="+id;
    }
}
