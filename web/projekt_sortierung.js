class ProjektSortierung {
    
    constructor(projekte) {
        this._projekte = projekte;
    }
    
    sortiereAnfangsdatum() { 
        this._projekte.sort(function(p1, p2){
            return p1.startdatum - p2.startdatum;
        });
        return this._projekte;
    }
    
    sortiereLaufzeit() {    
        this._projekte.sort(function(p1, p2){
            let laufzeit1 = p1.berechneArbeitszeit();
            let laufzeit2 = p2.berechneArbeitszeit();
            return laufzeit1 - laufzeit2;
        });
        return this._projekte;
    }
}