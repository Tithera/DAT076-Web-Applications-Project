/**
 * The service file to execute AJAX call to backend
 * Person responsible for class: Therese Sturesson
 */

class RentOutService {
    
    /* The constructor with the connection to the backend */
    constructor() {
        this.baseUrl = "http://localhost:8080/apartments/rest/reOu";
    }
    
    /* Finds all rent out ads through the backend */
    findAll(callback) {
        window.$.ajax({
            url: this.baseUrl,
            method: "GET",
            context: this 
          }).done(data => { 
            callback(data);
          })
          .fail(msg => { 
            console.log(msg);
        });
    }
    
    /* Creates a rent out ad through the backend */
    create(rentOut, callback) {
        window.$.ajax({
            url: this.baseUrl,
            //contentType:"application/json",
            //data: JSON.stringify(rentOut), 
            data: rentOut,
            method: "POST",
            crossDomain: true,
            context: this
          }).done(data => {
            this.findAll(callback);
          })
          .fail(msg => {
            console.log(msg);
        });
    }
    
    /* Finds a specific rent out ad through the backend */
    find(id, callback) {
        $.ajax({
            url: this.baseUrl + "/" + id,
            method: "GET"
          }).done(data => {
            callback(data);
          })
          .fail(msg => {
            console.log(msg);
        });
    }
    
    /* Deletes a specific rent out ad through the backend */
    delete(id, callback) {
        window.$.ajax({
              url: this.baseUrl + "/" + id,
              method: "DELETE",
              context: this
          }).done (data => {
              this.findAll(callback);
          })
          .fail(msg => {
              console.log(msg);
        });
    }
    
    /* Updates a specific rent out ad through the backend */
    update(rentOut, callback) {
        window.$.ajax({
              url: this.baseUrl + "/" + rentOut.id,
              //contentType:"application/json",
              //data: JSON.stringify(rentOut),
              method: "PUT",
              data: rentOut,
              crossDomain: true,
              context: this
          }).done(data => {
              this.findAll(callback);
          })
          .fail(msg => {
              console.log(msg);
        }); 
    }
  
}

export const rentOutService = new RentOutService();
