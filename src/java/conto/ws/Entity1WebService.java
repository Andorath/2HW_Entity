package conto.ws;

import conto.entity.Conto;
import conto.entity.ContoFacadeLocal;
import conto.record.OperationRecord;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Damiano Di Stefano, Marco Giuseppe Salafia
 */
@WebService(serviceName = "Entity1WebService")
public class Entity1WebService
{

    @EJB
    private ContoFacadeLocal contoFacade;

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "conto") Conto conto)
    {
        contoFacade.create(conto);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "conto") Conto conto)
    {
        contoFacade.edit(conto);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "conto") Conto conto)
    {
        contoFacade.remove(conto);
    }

    @WebMethod(operationName = "find")
    public Conto find(@WebParam(name = "id") Object id)
    {
        return contoFacade.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Conto> findAll()
    {
        return contoFacade.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Conto> findRange(@WebParam(name = "range") int[] range)
    {
        return contoFacade.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count()
    {
        return contoFacade.count();
    }
    
    @WebMethod(operationName = "createEntry")
    @Oneway
    public void createEntry(@WebParam(name = "operationID") String operationID, 
                            @WebParam(name = "userID") String userID, 
                            @WebParam(name = "operationValue") double operationValue)
    {
        Conto c = new Conto(operationID, userID, operationValue, System.currentTimeMillis());
        create(c);
    }    
}
