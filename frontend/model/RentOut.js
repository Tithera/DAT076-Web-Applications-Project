
/**
 * The model class for the rent out class
 * Person responsible for class: Therese Sturesson
 */

export class RentOut {
    
    /* The constructor for the class */
    constructor (id, adress, room, price, description, name, phoneNr, mail, image) {
        this.id = id;
        this.adress = adress;
        this.room = room;
        this.price = price;
        this.description = description;
        this.name = name;
        this.phoneNr = phoneNr;
        this.mail = mail;
        this.image = image;
    }
    
}
