class Projekt {
    
    constructor(id, titel, kurzbeschreibung, logopath, startdate, archiviert, artefakte, aufgabenbereiche) {
        this.id = id;
        this.titel = titel;
        this.kurzbeschreibung = kurzbeschreibung;
        this.logopath = logopath;
        this.startdate = startdate;
        this.archiviert = archiviert;
        this.artefakte = artefakte;
        this.aufgabenbereiche = aufgabenbereiche;
    }
    
    berechneArbeitszeit(){
        var sum = 0;
        for(let artefakt of this.artefakte){
            sum += artefakt.geplanteArbeitszeit;
        }
        return sum; 
    }
}