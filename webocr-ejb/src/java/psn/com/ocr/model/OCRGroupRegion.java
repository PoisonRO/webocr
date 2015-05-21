/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.ocr.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dan
 */
public class OCRGroupRegion implements Serializable {

    private List<OCRRegion> lRegions;
    
    public List<OCRRegion> getRegions() {
        return lRegions;
    }
    
}

