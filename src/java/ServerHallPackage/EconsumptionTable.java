/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerHallPackage;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "econstable")
public class EconsumptionTable implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private int econsumption;
    private Date date;
    
    public EconsumptionTable(){}
    
    public EconsumptionTable(int id, int econsumption, Date date){
        
        this.id = id;
        this.econsumption = econsumption;
        this.date = date;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEconsumption() {
        return econsumption;
    }

    @XmlElement
    public void setEconsumption(int econsumption) {
        this.econsumption = econsumption;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    

}
