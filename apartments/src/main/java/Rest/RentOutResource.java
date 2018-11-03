
package Rest;

import com.google.gson.Gson;
import core.RentOut;
import dao.RentOutCollection;
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
 * The rest backend for web service 
 * Person responsible for class: Therese Sturesson
 */

@Path("reOu")
public class RentOutResource {
    
    private static final Logger LOG = Logger.getLogger(RentOutResource.class.getName());

    @Context
    private UriInfo uriInfo;

    @EJB
    private RentOutCollection rocoll;
    private final Gson gson = new Gson();

    
    /* The method to find a specific rent out ad with json type 
       Sends the data to RentOutCollections find method*/
    @GET
    @Path("{id : [a-zA-Z0-9]+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") String id) {
        RentOut p = rocoll.find(id);
        if (p != null) {
            return Response.ok(gson.toJson(p)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build(); 
        }
    }

    
    /* The method to find all rent out ads with json type 
       Sends the data to RentOutCollections findAll method*/
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        out.println("*** findAll");
        List<RentOut> rentOuts = rocoll.findAll();
        out.println(rentOuts);
        return Response.ok(gson.toJson(rentOuts)).build();
    }

    
    /* The method to count all rent out ads with json type 
       Sends the data to RentOutCollections count method*/
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Path("count")
    public Response count() {
        int count = rocoll.count();
        return Response.ok(gson.toJson(count)).build();
    }
    
    
    /* The method to create a new rent out ad with the json method 
       Sends the data to RentOutCollections create method with json*/
    @POST
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(RentOut rentOut) {
        rocoll.create(rentOut);
        URI rentOutUri = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(rentOut.getId()))
                .build(rentOut);
        return Response.created(rentOutUri).build();
    }
    
    /* The method to create a new rent out ad with the form method 
       Sends the data to RentOutCollections create method with form*/
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response create(@FormParam("id") String id, @FormParam("adress") String adress, @FormParam("room") int room, @FormParam("price") int price,
            @FormParam("description") String description, @FormParam("name") String name,
            @FormParam("phoneNr") int phoneNr, @FormParam("mail") String mail,
            @FormParam("image") String image) {
        
        RentOut rentOut = new RentOut(id, adress,room, price, description, name, phoneNr, mail, image);
        rocoll.create(rentOut);
        URI rentOutUri = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(rentOut.getId()))
                .build(rentOut);
        return Response.created(rentOutUri).build();
    }
    
    
     @PUT
    @Path("{id : [a-zA-Z0-9]+}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response update(@FormParam("id") String id, @FormParam("adress") String adress, @FormParam("room") int room, @FormParam("price") int price,
            @FormParam("description") String description, @FormParam("name") String name,
            @FormParam("phoneNr") int phoneNr, @FormParam("mail") String mail,
            @FormParam("image") String image) {
        System.out.println("id " + id);
        RentOut rentOut = rocoll.find(id);
        if (rentOut != null) {
            rentOut.setAdress(adress);
            rentOut.setRoom(room);
            rentOut.setPrice(price);
            rentOut.setDescription(description);
            rentOut.setName(name);
            rentOut.setPhoneNr(phoneNr);
            rentOut.setMail(mail);
            rentOut.setImage(image);
            rocoll.update(rentOut);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    
    /* The method to delete a rent out ad 
       Sends the data to RentOutCollections delete method*/
    @DELETE
    @Path("{id : [a-zA-Z0-9]+}")
    public Response delete(@PathParam("id") String id) {
        rocoll.delete(id);
        return Response.noContent().build();
    }
    
    
    /* The method to update a rent out ad with the json method 
       Sends the data to RentOutCollections update method with json*/
    @PUT
    @Path("{id : [a-zA-Z0-9]+}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(RentOut rentOut) {
        RentOut b = rocoll.find(rentOut.getId());
        if (b != null) {
            b.setAdress(rentOut.getAdress());
            b.setRoom(rentOut.getRoom());
            b.setPrice(rentOut.getPrice());
            b.setDescription(rentOut.getDescription());
            b.setName(rentOut.getName());
            b.setPhoneNr(rentOut.getPhoneNr());
            b.setMail(rentOut.getMail());
            b.setImage(rentOut.getImage());
            rocoll.update(rentOut);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
}
