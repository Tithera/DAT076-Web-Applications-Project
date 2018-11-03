
import {
  reOuReg
} from "../model/RentOutRegistry.js"
import {
  RentOut
} from "../model/RentOut.js"
import {
  eventBus as eB
} from "../util/eventBus.js"

/**
 * The controller for the rent out html page
 * Person responsible for class: Therese Sturesson
 */

class Listener {
    

    /* When events from model happens */
    onModelEvent(event, data) {
        var table = $('#rentOut').DataTable();
        table.rows().remove();
        table.rows.add(data).draw();
    }
    
    /* When the pop-up window appears */
    showEditDeleteModal(rowData) {
        $("#rid").val(rowData.id);
        $("#radress").val(rowData.adress);
        $("#rroom").val(rowData.room);
        $("#rprice").val(rowData.price);
        $("#rdescription").val(rowData.description);
        $("#rname").val(rowData.name);
        $("#rphoneNr").val(rowData.phoneNr);
        $("#rmail").val(rowData.mail);
        $("#rimage").val(rowData.image);
        $("#editDeleteModal").modal('show');
    }
    
    /* When you click on the update button in the pop-up window */
    update() {
        let id = $("#rid").val();
        let adr = $("#radress").val();
        let rom = $("#rroom").val();
        let pri = $("#rprice").val();
        let des = $("#rdescription").val();
        let name = $("#rname").val();
        let pho = $("#rphoneNr").val();
        let mail = $("#rmail").val();
        let img = $("#rimage").val();
        let reOu = new RentOut(id, adr, rom, pri, des, name, pho, mail, img);
        reOuReg.update(reOu);
        $("#editDeleteModal").modal('hide');
    }
    
    /* When you click on the delete button in the pop-up window */
    delete() {
        let id = $("#rid").val();
        reOuReg.delete(id);
        $("#editDeleteModal").modal('hide');
    }
    
    /* When you click on the add button */
    create(e) {
        e.preventDefault();
        let id = $("#id").val();
        let adr = $("#adress").val();
        let rom = $("#room").val();
        let pri = $("#price").val();
        let des = $("#description").val();
        let name = $("#name").val();
        let pho = $("#phoneNr").val();
        let mail = $("#mail").val();
        let img = $("#image").val();
        let reOu = new RentOut(id, adr, rom, pri, des, name, pho, mail, img);
        reOuReg.create(reOu, function() {
            window.location.href='/view/RentOut.html';
        });
    }
    
}

/* Creates a listener */
const listener = new Listener();
eB.register(listener);

/* Listening on the events */
$(document).ready(function() {
    let table = $('#rentOut').dataTable().api();
    table.on("click", "tbody tr", function(e) {
      listener.showEditDeleteModal(table.row(this).data());
    });
    $("#update").on("click", listener.update);
    $("#delete").on("click", listener.delete);
    $("#rentOutForm").on("submit", listener.create);
});
