/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psn.com.ocr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dan
 */
@Entity
@Table(name = "app_settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppSettings.findAll", query = "SELECT a FROM AppSettings a"),
    @NamedQuery(name = "AppSettings.findByAppKey", query = "SELECT a FROM AppSettings a WHERE a.appKey = :appKey"),
    @NamedQuery(name = "AppSettings.findByAppSetting", query = "SELECT a FROM AppSettings a WHERE a.appSetting = :appSetting")})
public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "app_key", nullable = false, length = 45)
    private String appKey;
    @Size(max = 256)
    @Column(name = "app_setting", length = 256)
    private String appSetting;

    public AppSettings() {
    }

    public AppSettings(String appKey) {
        this.appKey = appKey;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSetting() {
        return appSetting;
    }

    public void setAppSetting(String appSetting) {
        this.appSetting = appSetting;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appKey != null ? appKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppSettings)) {
            return false;
        }
        AppSettings other = (AppSettings) object;
        if ((this.appKey == null && other.appKey != null) || (this.appKey != null && !this.appKey.equals(other.appKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "psn.com.ocr.model.AppSettings[ appKey=" + appKey + " ]";
    }
    
}
