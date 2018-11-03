package Rest;

 /* 
**Person responsible for class: Emilia Vestlund
**
*/


import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    /*
**should not be changed because they are
** automated populated
**/

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Rest.CORSFilter.class);
        resources.add(Rest.DatabaseResource.class);
        resources.add(Rest.RentOutResource.class);
        resources.add(Rest.RentResource.class);

    }
    
}

