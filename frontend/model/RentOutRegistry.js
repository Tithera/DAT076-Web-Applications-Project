
import {
  RentOut
} from "./RentOut.js"
import {
  eventBus as eB
} from "../util/eventBus.js"
import {
  rentOutService
} from "../service/RentOutService.js"


/**
 * The model class for the frontend
 * Person responsible for class: Therese Sturesson
 */

class RentOutRegistry {
   
   /* The constructor for the class with test data when not connected to backend */
   constructor() {
       this.rentOuts = [
           new RentOut("OO", "oo","2","4000", "oo", "oo", "11", "o@com", "ollev")
       ];
    } 

    /* Finds a specific rent out ad */
    find(id) {
        return this.rentOuts.find(a => a.id === id);
    }
    
    /* Finds all rent out ads through rentOutService */
    findAll() {
        rentOutService.findAll(data => {
          this.rentOuts = data;
          return eB.notify("", data);
        });
    }
    
    /* Creates a new add through rentOutService */
    create(rentOut, callback) {
        rentOutService.create(rentOut, function(data) {
           eB.notify("ADD", data);
           callback();
        }); 
    }
    
    /* Updates a specific rent out ad through rentOutService */
    update(rentOut) {
        rentOutService.update(rentOut, callback => {
            var a = this.find(rentOut.id);
            this.rentOuts = callback;
            eB.notify("UPDATE", this.rentOuts);
        });
    }
    
    /* Deletes a specific rent out add through rentOutService */
    delete(id) {
        rentOutService.delete(id, data => {
           var a = this.find(id);
           this.rentOuts = this.rentOuts.filter(elem => elem !== a);
           return eB.notify("DELETE", this.rentOuts); 
        });
    }
    
}

export const reOuReg = new RentOutRegistry();
