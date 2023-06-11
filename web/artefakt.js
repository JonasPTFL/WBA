class Artefakt {
    
    constructor(id, titel, kurzbeschreibung, zugehoerigerAufgabenbeeich, geplanteArbeitszeit) {
        this._id = id;
        this._titel = titel;
        this._kurzbeschreibung = kurzbeschreibung;
        this._zugehoerigerAufgabenbeeich = zugehoerigerAufgabenbeeich;
        this._geplanteArbeitszeit = geplanteArbeitszeit;
    }
    get geplanteArbeitszeit(){
        return this._geplanteArbeitszeit;
    }
}