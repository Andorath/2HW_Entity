package conto.entity;

import conto.record.OperationRecord;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Damiano Di Stefano, Marco Giuseppe Salafia
 */
@Entity
@Table(name = "conto")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Conto.findAll", query = "SELECT c FROM Conto c ORDER BY c.operationDate"),
    //@NamedQuery(name = "Conto.findAll", query = "SELECT c FROM Conto c"),
    @NamedQuery(name = "Conto.findByOperationID", query = "SELECT c FROM Conto c WHERE c.operationID = :operationID"),
    @NamedQuery(name = "Conto.findByUserID", query = "SELECT c FROM Conto c WHERE c.userID = :userID"),
    @NamedQuery(name = "Conto.findByOperationValue", query = "SELECT c FROM Conto c WHERE c.operationValue = :operationValue")
})
public class Conto implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "operationID")
    private String operationID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "userID")
    private String userID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operationValue")
    private double operationValue;
    @Lob
    @Size(max = 16777215)
    @Column(name = "operationDate")
    private String operationDate;

    public Conto()
    {
    }

    public Conto(String operationID)
    {
        this.operationID = operationID;
    }

    public Conto(String operationID, String userID, double operationValue, long currentDate)
    {
        this.operationID = operationID;
        this.userID = userID;
        this.operationValue = operationValue;
        this.operationDate = String.valueOf(currentDate);
    }

    public String getOperationID()
    {
        return operationID;
    }

    public void setOperationID(String operationID)
    {
        this.operationID = operationID;
    }

    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public double getOperationValue()
    {
        return operationValue;
    }

    public void setOperationValue(double operationValue)
    {
        this.operationValue = operationValue;
    }

    public String getOperationDate()
    {
        return operationDate;
    }

    public void setOperationDate(String operationDate)
    {
        this.operationDate = operationDate;
    }
    
    public OperationRecord getOperationRecord()
    {
        return new OperationRecord(operationID, 
                                   userID, 
                                   operationValue, 
                                   Long.parseLong(operationDate));
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (operationID != null ? operationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conto))
        {
            return false;
        }
        Conto other = (Conto) object;
        if ((this.operationID == null && other.operationID != null) || (this.operationID != null && !this.operationID.equals(other.operationID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "conto.entity.Conto[ operationID=" + operationID + " ]";
    }
    
    
    
}
