/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerHallPackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "epricetable")
public class EpriceTable implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private int eprice;
    private Date date;
    
    public EpriceTable(){}
    
    public EpriceTable(int id, int eprice, Date date){
        
        this.id = id;
        this.eprice = eprice;
        this.date = date;
        
    }
    
    public EpriceTable(int eprice){
        this.eprice = eprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEprice() {
        return eprice;
    }

    @XmlElement
    public void setEprice(int eprice) {
        this.eprice = eprice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
