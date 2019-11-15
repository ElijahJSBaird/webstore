
package edu.csumb.fall19.cst438.webstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
    @Id
    private String id;
    private String name;
    private Integer year;
    private String description;
    private String imageURL;
    private Double price;
    private Integer stock;
    private String trailer;

    public Product (String name, Integer year, String description, String imageURL, Double price, Integer stock, String trailer) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.stock = stock;
        this.trailer = trailer;
    }

    public void updateStock(Integer quantity) {
        this.stock -= quantity;
    }

    public String getId() {
        return this.id;
    }

    public Integer getYear() {
        return this.year;
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

    public Double getPrice() {
        return this.price;
    }

    public Integer getStock() {
        return this.stock;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageUrl) {
        this.imageURL = imageUrl;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}