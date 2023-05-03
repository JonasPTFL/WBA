package classes;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlRootElement;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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
