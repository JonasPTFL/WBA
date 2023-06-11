class Projekt {
    
    constructor(id, titel, kurzbeschreibung, logopath, startdatum, archiviert, artefakte, aufgabenbereiche) {
        this._id = id;
        this._titel = titel;
        this._kurzbeschreibung = kurzbeschreibung;
        this._logopath = logopath;
        this._startdatum = startdatum;
        this._archiviert = archiviert;
        this._artefakte = artefakte;
        this._aufgabenbereiche = aufgabenbereiche;
    }
    
    get artefakte(){
        return this._artefakte;
    }
    get startdatum(){
        return this._startdatum;
    }
    
    istArchiviert() {
        return this._archiviert;
    }
    
    berechneArbeitszeit(){
        var sum = 0;
        for(let artefakt of this._artefakte){
            sum += artefakt.geplanteArbeitszeit;
        }
        return sum; 
    }
}