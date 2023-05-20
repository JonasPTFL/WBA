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
@Table(name = DatabaseConstants.ARTEFAKT_TABLE)
@NamedQueries({
    @NamedQuery( name=DatabaseConstants.ARTEFAKT_SELECT_ALL,
            query="SELECT t FROM "+DatabaseConstants.ARTEFAKT_TABLE+" t"),
    @NamedQuery( name=DatabaseConstants.ARTEFAKT_FILTER_TITLE,
            query="SELECT t FROM "+DatabaseConstants.ARTEFAKT_TABLE+" t WHERE t.titel LIKE :titel")
})
public class Artefakt implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titel;
    
    private String kurzbeschreibung;
    
    private Aufgabenbereich zugehoerigerAufgabenbeeich;
    
    private Integer geplanteArbeitszeit;

    public Integer getGeplanteArbeitszeit() {
        return geplanteArbeitszeit;
    }

    public void setGeplanteArbeitszeit(Integer geplanteArbeitszeit) {
        this.geplanteArbeitszeit = geplanteArbeitszeit;
    }
    
    

    public Aufgabenbereich getZugehoerigerAufgabenbeeich() {
        return zugehoerigerAufgabenbeeich;
    }

    public void setZugehoerigerAufgabenbeeich(Aufgabenbereich zugehoerigerAufgabenbeeich) {
        this.zugehoerigerAufgabenbeeich = zugehoerigerAufgabenbeeich;
    }   
 
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
