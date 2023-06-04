package se.fit.quanlydonhang.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {
    @Id
    private String manId;
    private String manName;
    private String contactName;
    private String contractEmail;
    private String contactPhone;
    private String manWebsite;

    public Manufacturer() {
    }

    public Manufacturer(String manId, String manName, String contactName, String contractEmail, String contactPhone, String manWebsite) {
        this.manId = manId;
        this.manName = manName;
        this.contactName = contactName;
        this.contractEmail = contractEmail;
        this.contactPhone = contactPhone;
        this.manWebsite = manWebsite;
    }

    public String getManId() {
        return manId;
    }

    public void setManId(String manId) {
        this.manId = manId;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContractEmail() {
        return contractEmail;
    }

    public void setContractEmail(String contractEmail) {
        this.contractEmail = contractEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getManWebsite() {
        return manWebsite;
    }

    public void setManWebsite(String manWebsite) {
        this.manWebsite = manWebsite;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manId='" + manId + '\'' +
                ", manName='" + manName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contractEmail='" + contractEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", manWebsite='" + manWebsite + '\'' +
                '}';
    }
}
