package dao;

/**
 *  Person responsible for class: Emilia Vestlund
*
*/
//imports 
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;

public abstract class AbstractQuery<TDao, KDao> extends AbstractDAO<TDao, KDao>{

    
    //QueryDSL need this 
    private final EntityPathBase<TDao> queryObject;  
   
    protected AbstractQuery(Class<TDao> clazzDao, EntityPathBase<TDao> queryObject) {
        super(clazzDao);
        this.queryObject = queryObject;
    }
    

   public List<TDao> findAll() {

        JPAQueryFactory quaryfactory = new JPAQueryFactory(getEntityManager());
        List<TDao> foundDao = quaryfactory.select(queryObject)
                .from(queryObject)
                .fetch();
        return foundDao;
    }

    public List<TDao> findRange(int start, int numberRecords) {
        JPAQueryFactory quaryfactory = new JPAQueryFactory(getEntityManager());
        
        List<TDao> foundDao = quaryfactory.select(queryObject)
                .from(queryObject)
                .offset(start)
                .limit(numberRecords)
                .fetch();
        
        return foundDao;
    }


    public int count() {
        JPAQueryFactory quaryfactory = new JPAQueryFactory(getEntityManager());
        return quaryfactory.from(queryObject).fetch().size();
    }

    public void clear() {
        JPAQueryFactory quaryfactory = new JPAQueryFactory(getEntityManager());
        // delete all customers
        quaryfactory.delete(queryObject).execute();
    }

}