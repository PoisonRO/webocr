/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.ocr.app;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import psn.com.ocr.bl.ApplicationSettingsBL;
import psn.com.ocr.model.AppSettings;

/**
 *
 * @author dan
 */

@ManagedBean(name = "ApplicationSettings")
@ViewScoped
public class ApplicationSettings implements Serializable{
    
    //http://stackoverflow.com/questions/18873970/primefaces-commandbutton-action-doesnt-work
    
    @EJB
    private ApplicationSettingsBL   pSettings;
    
    private AppSettings             newSetting;
    private AppSettings             selectedSetting;
    
    @PostConstruct
    public void ApplicationSettings_PostConstruct() {
        
    }

    public List<AppSettings> getpSettingsList() {
        return pSettings.getDBSettings();
    }
    
    public AppSettings getNewSetting() {
        return newSetting;
    }

    public void setNewSetting(AppSettings newSetting) {
        this.newSetting = newSetting;
    }

    public void setupNewSetting() {
        newSetting = new AppSettings();
    }
    
    public void addNewSetting() {
        pSettings.addDBSetting(newSetting);
    }
    
    public void selectSetting(AppSettings s) {
        selectedSetting = s;
    }
    
    public void deleteSelectedSetting() {
        pSettings.deleteDBSetting(selectedSetting);
    }
}
