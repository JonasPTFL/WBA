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
    
    /*
    * Generates a path to a specific object
    */
    public static String createObjectLocationPath(String basePath, Long id){
        return "/"+basePath+"?id="+id;
    }
}
