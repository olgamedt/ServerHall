/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerHallPackage;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "temptable")
public class TempTable implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private int temperature;
    private Date date;


    public TempTable() {
    }

    public TempTable(int id, int temperature, Date date) {
        this.id = id;
        this.temperature = temperature;
        this.date = date;

    }

    public TempTable(int temperature) {
        this.temperature = temperature;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    @XmlElement
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
