package rest;

import classes.Projekt;
import java.time.LocalDateTime;

/**
 * Adapter solveing the issue
 * - Date is not directly parseable from json useing JAXB
 * 
 * @author Florian Fehring
 */
public class ProjektAdapter {
    private String titel;
    private String kurzbeschreibung;
    private String startdate;
    private Long id; 
    private boolean archiviert;

    public boolean isArchiviert() {
        return archiviert;
    }

    public void setArchiviert(boolean archiviert) {
        this.archiviert = archiviert;
    }
    private String logopath;

    public void setKurzbeschreibung(String kurzbeschreibung) {
        this.kurzbeschreibung = kurzbeschreibung;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    
    public Projekt toProject() {
        Projekt proj = new Projekt();
        proj.setId(this.id);
        proj.setTitel(this.titel);
        proj.setArchiviert(this.archiviert);
        proj.setKurzbeschreibung(this.kurzbeschreibung);
        proj.setLogopath(this.logopath);
        proj.setStartdatum(LocalDateTime.parse(this.startdate));  //ISO-Datumsformat yyyy-mm-ddT10:15:30
        return proj;
    }
}
