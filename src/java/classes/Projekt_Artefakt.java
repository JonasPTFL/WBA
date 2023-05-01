package classes;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a project
 * 
 * @author ffehring
 */
@XmlRootElement
public class Projekt_Artefakt implements Serializable {

    private static final long serialVersionUID = 1L;
   
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
