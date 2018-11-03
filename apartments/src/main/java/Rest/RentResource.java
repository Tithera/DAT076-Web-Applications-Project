package Rest;

import com.google.gson.Gson;
import core.Rent;
import core.RentOut;
import dao.RentCollection;
import static java.lang.System.out;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * The rest for web service 
 * Person responsible for class: Amanda Jonsson 
 */

@Path("re")
public class RentResource {
    
    private static final Logger LOG = Logger.getLogger(RentResource.class.getName());

    @Context
    private UriInfo uriInfo;

    @EJB
    private RentCollection rcoll;
    private final Gson gson = new Gson();

    
    /* The method to find a specific rent ad */
    @GET
    @Path("{id : [a-zA-Z0-9]+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") String id) {
        Rent p = rcoll.find(id);
        if (p != null) {
            return Response.ok(gson.toJson(p)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build(); 
        }
    }

    
    /* The method to find all rent ads */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        out.println("*** findAll");
        List<Rent> rents = rcoll.findAll();
        out.println(rents);
        return Response.ok(gson.toJson(rents)).build();
    }

    
    /* The method to count all rent ads */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Path("count")
    public Response count() {
        int count = rcoll.count();
        return Response.ok(gson.toJson(count)).build();
    }

    
    /* The method to create a new rent ad with the json method */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Rent rent) {
        rcoll.create(rent);
        URI rentUri = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(rent.getId()))
                .build(rent);
        return Response.created(rentUri).build();
    }
 

    
    
    /* The method to delete a rent ad */
    @DELETE
    @Path("{id : [a-zA-Z0-9]+}")
    public Response delete(@PathParam("id") String id) {
        rcoll.delete(id);
        return Response.noContent().build();
    }
    
    
    /* The method to update a rent ad with the json method */
    @PUT
    @Path("{id : [a-zA-Z0-9]+}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(Rent rent) {
        Rent b = rcoll.find(rent.getId());
        if (b != null) {
            b.setDescription(rent.getDescription());
            b.setPrice(rent.getPrice());
            b.setRooms(rent.getRooms());
            b.setMail(rent.getMail());
            b.setName(rent.getName());
            b.setPhoneNr(rent.getPhoneNr());
            
            rcoll.update(rent);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    
     /* The method to create a new rent ad with the form method */
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response create(@FormParam("id") String id,
            @FormParam("description") String description,
            @FormParam("price") int price,
            @FormParam("rooms") int rooms,
            @FormParam("mail") String mail,
            @FormParam("name") String name,
            @FormParam("phoneNr") int phoneNr){
        
        Rent rent = new Rent(id, description, price, rooms, mail, name, phoneNr);
        rcoll.create(rent);
        URI rentUri = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(rent.getId()))
                .build(rent);
        return Response.created(rentUri).build();
    }

    
       /* The method to update a rent ad with the form method */
    @PUT
    @Path("{id : [a-zA-Z0-9]+}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response update(@FormParam("id") String id,
            @FormParam("description") String description,
            @FormParam("price") int price,
            @FormParam("rooms") int rooms,
            @FormParam("mail") String mail,
            @FormParam("name") String name,
            @FormParam("phoneNr") int phoneNr){
        
        System.out.println("id " + id);
        Rent rent = rcoll.find(id);
        if (rent != null) {
            rent.setDescription(description);
            rent.setPrice(price);
            rent.setRooms(rooms);
            rent.setMail(mail);
            rent.setName(name);
            rent.setPhoneNr(phoneNr);
            rcoll.update(rent);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    
    
}
