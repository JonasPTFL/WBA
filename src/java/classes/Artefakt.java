package classes;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a project
 * 
 * @author ffehring
 */
@XmlRootElement
public class Artefakt implements Serializable {

    private static final long serialVersionUID = 1L;
   
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
