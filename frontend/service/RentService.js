/**
 * The service to execute AJAX call to backend
 * Person responsible for class: Amanda Jonsson
 */
class RentService {
    
    constructor() {
        this.baseUrl = "http://localhost:8080/apartments/rest/re";
    }
    
    //executes a GET AJAX call to backend
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
    
    // executes a POST AJAX call to the backend
    create(rent, callback) {
        window.$.ajax({
            url: this.baseUrl,
            //contentType:"application/json",
            //data: JSON.stringify(rent),
            data: rent,
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
    
    // executes a GET AJAX call to the backend
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
    
    // executes a DELETE AJAX call to the backend
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
    
   // executes a PUT AJAX call to the backend
    update(rent, callback) {
        window.$.ajax({
              url: this.baseUrl + "/" + rent.id,
              //contentType:"application/json",
              //data: JSON.stringify(rent),
              data: rent,
              method: "PUT",
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

export const rentService = new RentService();
