package edu.csumb.Webstore.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
    @Id
    String id;
    String name;
    String description;
    String imageURL;
    Double cost;
    Integer stock;

    public Product(String name, String description, String imageURL, Double cost, Integer stock) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.cost = cost;
        this.stock = stock;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Double getCost() {
        return this.cost;
    }

    public Integer getStock() {
        return this.stock;
    }

    public String setId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}