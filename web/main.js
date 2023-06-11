
function berechneArbeitszeit(artefakte){
    var sum = 0;
    for(artefakt of artefakte){
        console.log(artefakt.geplanteArbeitszeit);
        sum += artefakt.geplanteArbeitszeit;
    }
    return sum;
}

artefakt1 = new Artefakt(0, "titel1", "Kurz1", 2);
artefakt2 = new Artefakt(1, "titel2", "Kurz2", 4);
artefakt3 = new Artefakt(2, "titel3", "Kurz3", 6);
artefakt4 = new Artefakt(3, "titel4", "Kurz4", 1); // new Aufgabenbereich(0, "Titel1", "Kurz1"),

artefakte = [artefakt1, artefakt2, artefakt3, artefakt4];

let sum = berechneArbeitszeit(artefakte);

alert("Arbeitszeit: "+sum);
