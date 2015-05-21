/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.ocr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dan
 */
public class OCRRegionSetup implements Serializable {
    
    private List<OCRRegion> lRegions;
    private List<OCRGroupRegion> lRegionsGroups;
    
    public OCRRegionSetup()
    {
        lRegions = new ArrayList<>();
        lRegionsGroups = new ArrayList<>();
    }
    
    public void addOCRRegion(OCRRegion newRegion) 
    {
        lRegions.add(newRegion);
    }
    
    public void addOCRRegionGroup(OCRGroupRegion newGroupRegion) 
    {
        lRegionsGroups.add(newGroupRegion);
    }

    public List<OCRRegion> getlRegions() {
        return lRegions;
    }

    public List<OCRGroupRegion> getlRegionsGroups() {
        return lRegionsGroups;
    }

    public void setlRegions(List<OCRRegion> lRegions) {
        this.lRegions = lRegions;
    }

    public void setlRegionsGroups(List<OCRGroupRegion> lRegionsGroups) {
        this.lRegionsGroups = lRegionsGroups;
    }
    
    public void clearSetup()
    {
        lRegions.clear();
        lRegionsGroups.clear();
    }
}
