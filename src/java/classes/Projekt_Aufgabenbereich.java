package classes;

import java.io.Serializable;
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
@Table(name = DatabaseConstants.PROJEKT_AUFGABENBEREICH_TABLE)
@NamedQueries({
    @NamedQuery( name="projektaufgabenbereich.findAll",
            query="SELECT t FROM "+DatabaseConstants.PROJEKT_AUFGABENBEREICH_TABLE+" t")
})
public class Projekt_Aufgabenbereich implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
