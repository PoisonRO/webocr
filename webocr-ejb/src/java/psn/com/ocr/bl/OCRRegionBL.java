/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.ocr.bl;

import java.io.File;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import psn.com.ocr.model.OCRRegion;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *
 * @author dan
 */

@Stateless
@LocalBean
public class OCRRegionBL {

    
    public int createXMLRegions(List<OCRRegion> lRegions,String szTemplateName) throws ParserConfigurationException, TransformerConfigurationException, TransformerException
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
        
        // root element
	Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("template");
        
        // set template name
        rootElement.setAttribute("name",szTemplateName);
        
        // add root element
        doc.appendChild(rootElement);
        
        for (OCRRegion region : lRegions)  {
            Element elem_region = doc.createElement("region");
            elem_region.setAttribute("name", region.getName());
            
                // add position
                Element elem_position = doc.createElement("position");
                elem_position.setAttribute("x1", ""+region.getX1());
                elem_position.setAttribute("y1", ""+region.getY1());
                elem_position.setAttribute("x2", ""+region.getX2());
                elem_position.setAttribute("y2", ""+region.getY2());
                
                elem_region.appendChild(elem_position);
            
            rootElement.appendChild(elem_region);
        }
        
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(new File("/home/dan/Desktop/magick_images/f.xml"));
        
        transformer.transform(source, result);
        
        return 0;
    }
}
