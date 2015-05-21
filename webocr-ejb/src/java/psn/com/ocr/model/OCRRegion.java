/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.ocr.model;

/**
 *
 * @author dan
 */

import java.io.Serializable;

/**
 *
 * @author dan
 */

public class OCRRegion implements Serializable{
    
    public int x1;
    public int x2;
    public int y1;
    public int y2;
    public String name;
    
    public OCRRegion() {
        x1=-1;
        x2=-1;
        y1=-1;
        y2=-1;
        name=" ";
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}