/**
 * The model for the rent class
 * Person responsible for class: Amanda Jonsson
 */
export class Rent {
    
    //The constructor for the class
    constructor (id, description,price, rooms, mail, name, phoneNr) {
        this.id = id;
        this.description = description;
        this.price=price;
        this.rooms=rooms;
        this.mail = mail;
        this.name = name;
        this.phoneNr = phoneNr;
    }
    
}

