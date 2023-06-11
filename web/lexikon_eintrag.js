class LexikonEintrag {
    
    constructor(deutsch, englisch) {
        this._deutsch = deutsch;
        this._englisch = englisch;
    }
    get deutsch(){
        return this._deutsch;
    }
    get englisch(){
        return this._englisch;
    }
}
