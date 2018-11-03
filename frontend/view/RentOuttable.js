
import {
  reOuReg
} from "../model/RentOutRegistry.js"

/**
 * Table for rent outs html page using jQuery Data table
 * Person responsible for class: Therese Sturesson
 */

/* The column data definition for the table */
const columns = [{
    data: "id"
  },
  {
    data: "adress"
  },
  {
    data: "room"
  },
  {
    data: "price"
  },
  {
    data: "description"
  },
  {
    data: "name"
  },
  {
    data: "phoneNr"
  },
  {
    data: "mail"
  },
  {
    data: "image"
  }
];

/* Creates and add table when DOM fully constructed */
$(document).ready(function() {
  let rentOuts = reOuReg.findAll();
  let table = $('#rentOut').DataTable({
    data: rentOuts,
    columns: columns  // Must be here
  });
});

