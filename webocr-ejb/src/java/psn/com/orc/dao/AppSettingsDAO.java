/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.orc.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import psn.com.ocr.model.AppSettings;

/**
 *
 * @author dan
 */
@Stateless
public class AppSettingsDAO extends AbstractFacade<AppSettings> {
    @PersistenceContext(unitName = "webocr-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppSettingsDAO() {
        super(AppSettings.class);
    }
    
}
