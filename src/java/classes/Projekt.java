package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a project
 * 
 * @author ffehring
 */
@XmlRootElement
@Entity
@Table(name = DatabaseConstants.PROJECT_TABLE)
@NamedQueries({
    @NamedQuery( name=DatabaseConstants.PROJEKT_SELECT_ALL,
            query="SELECT t FROM "+DatabaseConstants.PROJECT_TABLE+" t"),
    @NamedQuery( name=DatabaseConstants.PROJEKT_FILTER_TITLE,
            query="SELECT t FROM "+DatabaseConstants.PROJECT_TABLE+" t WHERE t.titel LIKE :titel"),
    @NamedQuery( name=DatabaseConstants.PROJEKT_SELECT_ARCHIVIERT,
            query="SELECT t FROM "+DatabaseConstants.PROJECT_TABLE+" t WHERE t.id = 1")//WHERE t.archiviert = 1")
})

public class Projekt implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titel;
    
    private String kurzbeschreibung;
    
    private String logopath;
    
    private LocalDateTime startdatum;

    //private boolean archiviert;
    
 
    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        if(titel.length() > 255) throw new IllegalArgumentException("Titel darf nicht länger als 255 Zeichen sein");
        this.titel = titel;
    }

    public String getKurzbeschreibung() {
        return kurzbeschreibung;
    }

    public void setKurzbeschreibung(String kurzbeschreibung) {
        this.kurzbeschreibung = kurzbeschreibung;
    }

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public LocalDateTime getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(LocalDateTime startdatum) {
        this.startdatum = startdatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
