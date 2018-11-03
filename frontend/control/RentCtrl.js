import {
  reReg
} from "../model/RentRegistry.js"
import {
  Rent
} from "../model/Rent.js"
import {
  eventBus as eB
} from "../util/eventBus.js"

/**
 * The controller for the rent html page. Handles events.
 * Person responsible for class: Amanda Jonsson
 */
class Listener {
    
    //Handle events from model
    onModelEvent(event, data) {
        var table = $('#rent').DataTable();
        table.rows().remove();
        table.rows.add(data).draw();
    }
    
    //Handle events from the gui, shows the pop up window
    showEditDeleteModal(rowData) {
        $("#rid").val(rowData.id);
        $("#rdescription").val(rowData.description);
         $("#rprice").val(rowData.price);
        $("#rrooms").val(rowData.rooms);
        $("#rmail").val(rowData.mail);
        $("#rname").val(rowData.name);
        $("#rphoneNr").val(rowData.phoneNr);
        $("#editDeleteModal").modal('show');
    }
    
    //Handle events from the gui, update a rent
    update() {
        let id = $("#rid").val();
        let des = $("#rdescription").val();
        let price = $("#rprice").val();
        let rooms = $("#rrooms").val();
        let mail = $("#rmail").val();
        let name = $("#rname").val();
        let pho = $("#rphoneNr").val();
        let re = new Rent(id, des,price, rooms, mail, name, pho);
        reReg.update(re);
        $("#editDeleteModal").modal('hide');
    }
    
    //Handle events from the gui, delete a rent
    delete() {
        let id = $("#rid").val();
        reReg.delete(id);
        $("#editDeleteModal").modal('hide');
    }
    

    //Handle events from the gui, create a rent
    create(e) {
        e.preventDefault();
        let id = $("#id").val();
        let des = $("#description").val();
        let price = $("#price").val();
        let rooms = $("#rooms").val();
        let mail = $("#mail").val();
        let name = $("#name").val();
        let pho = $("#phoneNr").val();
        let re = new Rent(id, des, price, rooms, mail, name, pho);
        reReg.create(re, function () {
            window.location.href='/view/Rent.html';
        });
    }
    
}

const listener = new Listener();
eB.register(listener);

$(document).ready(function() {
    let table = $('#rent').dataTable().api();
    table.on("click", "tbody tr", function(e) {
      listener.showEditDeleteModal(table.row(this).data());
    });
    $("#update").on("click", listener.update);
    $("#delete").on("click", listener.delete);
    $("#rentForm").on("submit", listener.create);
});
