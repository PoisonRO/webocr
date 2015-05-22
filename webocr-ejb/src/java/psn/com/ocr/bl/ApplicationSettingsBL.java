/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.ocr.bl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import psn.com.ocr.model.AppSettings;
import psn.com.orc.dao.AppSettingsDAO;

/**
 *
 * @author dan
 */
@Singleton
@Startup
@LocalBean
public class ApplicationSettingsBL {
   
    @EJB
    private AppSettingsDAO              pAppSettingsDAO;
    
    
    public ApplicationSettingsBL() {

    }
    
    public List<AppSettings> getDBSettings() {
        return pAppSettingsDAO.findAll();
    }
    
    public void addDBSetting(AppSettings newSetting) {
        pAppSettingsDAO.create(newSetting);
    }
    
    public void deleteDBSetting(AppSettings oldSetting) {
        pAppSettingsDAO.remove(oldSetting);
    }
    
    public void updateDBSetting(AppSettings newSetting) {
        pAppSettingsDAO.edit(newSetting);
    }
}
