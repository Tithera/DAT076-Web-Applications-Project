
package Rest;

import Service.DataSupplier;
import com.google.gson.Gson;
import core.Rent;
import core.RentOut;
import dao.RentCollection;
import dao.RentOutCollection;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 * Person responsible for class: Emilia Vestlund
 */

@Path("db")
public class DatabaseResource {
    
    @EJB
    private RentOutCollection rocoll;
    
    @EJB
    private RentCollection rcoll;

    private final Gson gson = new Gson();

    //Recreate database
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response recreateDatabase() {
        rocoll.clear();
        rcoll.clear();
        
        for (RentOut ro : DataSupplier.getRentOuts()) {
            rocoll.create(ro);
        }
        
        for(Rent r : DataSupplier.getRents()){
            rcoll.create(r);
        }
        
        return Response.ok(gson.toJson("Database recreated")).build();
    }
     
}
