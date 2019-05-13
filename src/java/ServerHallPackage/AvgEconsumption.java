/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerHallPackage;

import java.io.Serializable;

public class AvgEconsumption implements Serializable {

    private static final long serialVersionUID = 1L;
    private int min, max, avg;
    private int eprice;

    public AvgEconsumption() {
    }

    public AvgEconsumption(int avg, int min, int max, int eprice) {

        this.avg = avg;
        this.min = min;
        this.max = max;
        this.eprice = eprice;

    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    public int getEprice() {
        return eprice;
    }

    public void setEprice(int eprice) {
        this.eprice = eprice;
    }
    
    
}
