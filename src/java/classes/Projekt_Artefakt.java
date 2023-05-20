package classes;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlRootElement;
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
@Table(name = DatabaseConstants.PROJEKT_ARTEFAKT_TABLE)
@NamedQueries({
    @NamedQuery( name="projektartefakt.findAll",
            query="SELECT t FROM "+DatabaseConstants.PROJEKT_ARTEFAKT_TABLE+" t")
})
public class Projekt_Artefakt implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long projektId;
    
    private Long artefaktId;
    
    private Integer tatsaechlicheArbeitszeit;

    public Long getArtefaktId() {
        return artefaktId;
    }

    public void setArtefaktId(Long artefaktId) {
        this.artefaktId = artefaktId;
    }

    public Integer getTatsaechlicheArbeitszeit() {
        return tatsaechlicheArbeitszeit;
    }

    public void setTatsaechlicheArbeitszeit(Integer tatsaechlicheArbeitszeit) {
        this.tatsaechlicheArbeitszeit = tatsaechlicheArbeitszeit;
    }

    public Long getProjektId() {
        return projektId;
    }

    public void setProjektId(Long projektId) {
        this.projektId = projektId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
