/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.image;

import java.io.ByteArrayInputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
/**
 *
 * @author dan
 */

@ManagedBean
@ViewScoped
public class ImageController {
 
    private UploadedFile image = null;
    
    public void handleFileUpload(FileUploadEvent event) {
        image = event.getFile();
    }
        
    public StreamedContent getImage() {
        if (image != null) 
            return new DefaultStreamedContent(new ByteArrayInputStream(image.getContents()), image.getContentType());
        else
            return new DefaultStreamedContent();
    }
}
