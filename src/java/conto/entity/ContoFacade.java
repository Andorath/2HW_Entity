package conto.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
