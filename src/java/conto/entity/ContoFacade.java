package conto.entity;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Damiano Di Stefano, Marco Giuseppe Salafia
 */
@Stateless
public class ContoFacade extends AbstractFacade<Conto> implements ContoFacadeLocal
{

    @PersistenceContext(unitName = "Entity1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public ContoFacade()
    {
        super(Conto.class);
    }

    @Override
    public List<Conto> findAllOrdered()
    {
        Query q = em.createNamedQuery("Conto.getOperationsByDate");
        return q.getResultList();
    }
    
    
    
}
