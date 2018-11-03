/**
 * The class that represent the table for rent
 * Person responsible for class: Amanda Jonsson
 */
import {
  reReg
} from "../model/RentRegistry.js"

//Column data definitions
const columns = [{
    data: "id"
  },
  {
    data: "description"
  },
   {
    data: "price"
  },
   {
    data: "rooms"
  },
  {
    data: "mail"
  },
  {
    data: "name"
  },
  {
    data: "phoneNr"
  }
];

// Create and add table when DOM fully constructed
$(document).ready(function() {
  let rents = reReg.findAll();
  let table = $('#rent').DataTable({
    data: rents,
    columns: columns 
  });
});

