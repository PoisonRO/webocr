/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.image;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.extensions.event.ImageAreaSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import psn.com.ocr.model.OCRRegion;
import psn.com.ocr.model.OCRRegionSetup;

/**
 *
 * @author dan
 */

@SessionScoped
@ManagedBean(name = "ImageControllerBean" )
public class ImageController implements Serializable{
    
    @EJB
    psn.com.ocr.bl.OCRRegionBL  pOCRRegionBL;
            
    private UploadedFile    image = null;
    private String          szDefaultImage = null;
    
    //private List<OCRRegion> lOCRRegions;
    private OCRRegionSetup pRegionSetup;
    
    @PostConstruct
    public void ImageController_PostConstruct() 
    {
        String defaultBackground = "resources/img/webocr.png";

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        
        szDefaultImage = servletContext.getRealPath(defaultBackground);
        
        // create the region list
        pRegionSetup = new OCRRegionSetup();
        
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        // get the uploaded file
        image = event.getFile();
    }
        
    public StreamedContent getImage() throws IOException  {
        
        // return the uploaded image
        
        if (image != null) 
            return new DefaultStreamedContent(image.getInputstream());  
        else
            return new DefaultStreamedContent(new FileInputStream(szDefaultImage));
        
        // or the default image

    }
    
    public void selectAreaListener(final ImageAreaSelectEvent e) {  

        //check click
        if (e.getX1()==e.getX2() && e.getY1() == e.getY2()) return;
         
         
        // create the new OCR Region
        OCRRegion ocr_region = new OCRRegion();
        
        ocr_region.setX1(e.getX1());
        ocr_region.setX2(e.getX2());
        ocr_region.setY1(e.getY1());
        ocr_region.setY2(e.getY2());
        
        // assign default name
        
        ocr_region.setName("Region "+(pRegionSetup.getlRegions().size()+1));
        
        pRegionSetup.addOCRRegion(ocr_region);
    }

    
    public void clearOCRInfo() {
        
        // delete all regions
        
        pRegionSetup.clearSetup();
    }
    
    public void saveOCRTemplate() throws ParserConfigurationException, TransformerConfigurationException, TransformerException
    {
        
        pOCRRegionBL.createXMLRegions(pRegionSetup, "smen");
        
        image=null;
        clearOCRInfo();
    }    

    public OCRRegionSetup getpRegionSetup() {
        return pRegionSetup;
    }

    public void setpRegionSetup(OCRRegionSetup pRegionSetup) {
        this.pRegionSetup = pRegionSetup;
    }
}
