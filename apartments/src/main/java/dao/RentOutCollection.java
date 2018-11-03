
package dao;

import core.RentOut;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import core.QRentOut;


/**
 * The RentOut Collection class
 * Person responsible for class: Therese Sturesson
 */

@Stateless
public class RentOutCollection extends AbstractQuery<RentOut, String> {
    

    /* The connection to the persistence file and glassfish */
    @PersistenceContext(unitName ="apartment_persistence")
    
    /* The entity manager varible */
    private EntityManager em;
    
    
    /* The constructor for the class */
    public RentOutCollection() {
        super(RentOut.class, QRentOut.rentOut);
    }
    
    
    /* The getter for the entity manager */
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    
    /* The setter for the entity manager */
   @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
}
