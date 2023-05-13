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
@Table(name = DatabaseConstants.ARTEFAKT_TABLE)
@NamedQueries({
    @NamedQuery( name="artefakt.findAll",
            query="SELECT t FROM "+DatabaseConstants.ARTEFAKT_TABLE+" t"),
    @NamedQuery( name="artefakt.findByTitel",
            query="SELECT t FROM "+DatabaseConstants.ARTEFAKT_TABLE+" t WHERE t.titel = :titel"),
    @NamedQuery( name="artefakt.findById",
            query="SELECT t FROM "+DatabaseConstants.ARTEFAKT_TABLE+" t WHERE t.id = :id")
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
