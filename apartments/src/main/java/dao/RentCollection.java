package dao;

import core.QRent;
import core.Rent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * The RentCollection class
 * Person responsible for class: Amanda Jonsson
 */

@Stateless
public class RentCollection extends AbstractQuery<Rent, String>{

  
    /* The connection to the persistence file and glassfish */
    @PersistenceContext(unitName ="apartment_persistence")
    
    /* The entity manager varible */
    private EntityManager em;
    
    /* The constructor for the class */
    public RentCollection() {
        super(Rent.class, QRent.rent);
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
