package classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a project
 * 
 * @author ffehring
 */
@XmlRootElement
public class Projekt_Aufgabenbereich implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Long id;
    
    private Long projektId;
    
    private Long aufgabenbereichId;

    public Long getProjektId() {
        return projektId;
    }

    public void setProjektId(Long projektId) {
        this.projektId = projektId;
    }

    public Long getAufgabenbereichId() {
        return aufgabenbereichId;
    }

    public void setAufgabenbereichId(Long aufgabenbereichId) {
        this.aufgabenbereichId = aufgabenbereichId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
