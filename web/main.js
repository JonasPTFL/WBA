let aufgabenbereich = new Aufgabenbereich(0, "Titel1", "Kurz1");
let artefakt1 = new Artefakt(0, "titel1", "Kurz1", aufgabenbereich, 2);
let artefakt2 = new Artefakt(1, "titel2", "Kurz2", aufgabenbereich, 4);
let artefakt3 = new Artefakt(2, "titel3", "Kurz3", aufgabenbereich, 6);
let artefakt4 = new Artefakt(3, "titel4", "Kurz4", aufgabenbereich, 1);

let date1 = new Date(2023, 1, 1, 0, 0, 0, 0);
let date2 = new Date(2024, 6, 6, 6, 6, 6, 6);
let projekt1 = new Projekt(0, "Titel1", "Kurz1", "Logo1", date2, false, [artefakt1, artefakt4], [aufgabenbereich]);
let projekt2 = new Projekt(1, "Titel2", "Kurz2", "Logo2", date1, false, [artefakt2, artefakt3], [aufgabenbereich]);

let sortierer = new ProjektSortierung([projekt1, projekt2]);



let anfangsdatumSortiert = sortierer.sortiereAnfangsdatum().slice();
console.log("anfangsdatumSortiert:");
console.log(anfangsdatumSortiert);

let laufzeitSortiert = sortierer.sortiereLaufzeit().slice();
console.log("laufzeitSortiert:");
console.log(laufzeitSortiert);

alert("Arbeitszeit: "+projekt1.berechneArbeitszeit());

var userLang = navigator.language || navigator.userLanguage; 
alert ("The language is: " + userLang);


let sprachen_texte = new Map();
sprachen_texte.set("navigation_projekte", new LexikonEintrag("Projekte", "Projects"));
sprachen_texte.set("navigation_projekte_anlegen", new LexikonEintrag("Neues Projekt", "New project"));
sprachen_texte.set("startseite_willkommensnachricht_1", new LexikonEintrag("Willkommen", "Welcome"));
sprachen_texte.set("startseite_willkommensnachricht_2", new LexikonEintrag("im ProjectBoard!", "to the ProjectBoard!"));
sprachen_texte.set("anmelden_benutzername", new LexikonEintrag("Benutzer", "Username"));
sprachen_texte.set("anmelden_passwort", new LexikonEintrag("Passwort", "Password"));
sprachen_texte.set("anmelden_register", new LexikonEintrag("Neu registrieren", "Regsiter"));
sprachen_texte.set("anmelden", new LexikonEintrag("Anmelden", "Sign in"));
sprachen_texte.set("impressum", new LexikonEintrag("Impressum", "Imprint"));
sprachen_texte.set("datenschutzerklaerung", new LexikonEintrag("Datenschutzerklaerung", "Privacy policy"));
sprachen_texte.set("haftungsausschluss", new LexikonEintrag("Haftungsausschluss", "Disclaimer"));
sprachen_texte.set("copyright", new LexikonEintrag("Haftungsausschluss", "Copyright"));
sprachen_texte.set("kontaktinformationen", new LexikonEintrag("Kontaktinformationen", "Contact information"));
sprachen_texte.set("zum_seitenanfang", new LexikonEintrag("Zum Seitenanfang", "Jump to top"));
sprachen_texte.set("projekte_titel", new LexikonEintrag("Projekt-Liste", "Project list"));
sprachen_texte.set("projekte_filter", new LexikonEintrag("Filter", "Filter"));
sprachen_texte.set("projekte_tabelle_titel", new LexikonEintrag("Titel", "Title"));
sprachen_texte.set("projekte_tabelle_kurzbeschreibung", new LexikonEintrag("Kurzbeschreibung", "Brief description"));
sprachen_texte.set("projektdetail_titel", new LexikonEintrag("Projektseite", "Project site"));
sprachen_texte.set("projektdetail_name", new LexikonEintrag("Name", "Name"));
sprachen_texte.set("projektdetail_autor", new LexikonEintrag("Autor", "Author"));
sprachen_texte.set("projektdetail_kurzbeschreibung", new LexikonEintrag("Kurzbeschreibung", "Brief description"));
sprachen_texte.set("projektdetail_langbeschreibung", new LexikonEintrag("Langbeschreibung", "Long description"));
sprachen_texte.set("projektdetail_projektziele", new LexikonEintrag("Projektziele", "Project goals"));
sprachen_texte.set("projektdetail_startdatum", new LexikonEintrag("Startdatum", "Start date"));
sprachen_texte.set("projektdetail_enddatum", new LexikonEintrag("Enddatum", "End date"));
sprachen_texte.set("projektdetail_speichern", new LexikonEintrag("Speichern", "Save"));
sprachen_texte.set("projektdetail_kurzbeschreibung_link", new LexikonEintrag("Zu: Kurzschreibung", "To: brief description"));
sprachen_texte.set("projektdetail_langbeschreibung_link", new LexikonEintrag("Zu: Langbechreibung", "To: long description"));
sprachen_texte.set("projektdetail_projektziele_link", new LexikonEintrag("Zu: Projektzielen", "To: project goals"));


for (var [key, value] of sprachen_texte.entries()) {
    if(userLang == "de"){
        // deutsch
        console.log(value.deutsch);
    } else {
        // englisch
        console.log(value.englisch);

    }
}

function getLexikonText(key){
    if(userLang == "de"){
        return sprachen_texte.get(key).deutsch;
    } else {
        return sprachen_texte.get(key).englisch;

    }
}
