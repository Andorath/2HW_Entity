package conto.entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Damiano Di Stefano, Marco Giuseppe Salafia
 */
@Local
public interface ContoFacadeLocal
{

    void create(Conto conto);

    void edit(Conto conto);

    void remove(Conto conto);

    Conto find(Object id);

    List<Conto> findAll();

    List<Conto> findRange(int[] range);

    int count();
    
}
