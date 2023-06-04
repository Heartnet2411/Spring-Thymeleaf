package se.fit.quanlydonhang.models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private String id;
    private String productName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "manID")
    private Manufacturer manID;

    public Product() {
    }

    public Product(String id, String productName, String description, Manufacturer manID) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.manID = manID;
    }

    public Product(String id, String productName, String description) {
        this.id = id;
        this.productName = productName;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Manufacturer getManID() {
        return manID;
    }

    public void setManID(Manufacturer manID) {
        this.manID = manID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", manID=" + manID +
                '}';
    }
}
