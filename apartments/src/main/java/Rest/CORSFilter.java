package Rest;

 /*
* Person responsible for class: Emilia Vestlund
*/
import static java.lang.System.out;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    
    /*
** allows us to do httprequests to server
*/
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        out.println("**** CORS");
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type");
    }
    
}
