package dao;

/**
 * Person responsible for class: Emilia Vestlund
 *
 */
import javax.persistence.EntityManager;


public abstract class AbstractDAO<TDao, KDao> {

    private final Class<TDao> classDao;
   
    // will be overwridde 
    public abstract EntityManager getEntityManager();
    // will best tested outside
    public abstract void setEntityManager(EntityManager em);

    protected AbstractDAO(Class<TDao> clazzDao) {
        
        this.classDao = clazzDao;
    }

     // will update the result
    public TDao update(TDao t) {

        return getEntityManager().merge(t);
    }
    
    public void create(TDao tdao) {
        getEntityManager().persist(tdao);
        //dont know if we need anymore cause we dont have exceptionhandling
        flush();    
    }
    
    

    public TDao find(KDao id) {
        return getEntityManager().find(classDao, id);
    }


    public void delete(KDao id) {
        TDao t = getEntityManager().getReference(classDao, id);
        getEntityManager().remove(t);
    }

   
    protected void flush() {
        getEntityManager().flush();
    }
}
