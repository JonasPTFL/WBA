/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

public class DatabaseConstants {
    public static final String PU_NAME = "JPA_ExamplePU";
    
    public static final String PROJECT_TABLE = "Projekt";
    public static final String AUFGABENBEREICH_TABLE = "Aufgabenbereich";
    public static final String ARTEFAKT_TABLE = "Artefakt";
    public static final String PROJEKT_ARTEFAKT_TABLE = "Projekt_Artefakt";
    public static final String PROJEKT_AUFGABENBEREICH_TABLE = "Projekt_Aufgabenbereich";
    
    
    public static final String ARTEFAKT_SELECT_ALL = "artefakt.findAll";
    public static final String ARTEFAKT_FILTER_TITLE = "artefakt.filterTitle";
    
    public static final String PROJEKT_SELECT_ALL = "projekt.findAll";
    public static final String PROJEKT_FILTER_TITLE = "projekt.filterTitle";
    public static final String PROJEKT_SELECT_ARCHIVIERT = "projekt.findArchiviert";
    
    public static final String AUFGABENBEREICH_SELECT_ALL = "aufgabenbereich.findAll";
    public static final String AUFGABENBEREICH_FILTER_TITLE = "aufgabenbereich.filterTitle";
}
