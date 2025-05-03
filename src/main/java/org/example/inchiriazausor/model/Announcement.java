package org.example.inchiriazausor.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "announcements")
public class Announcement {
    @Id
    private String id;
    private String title;
    private String description;
    private String location;
    private Double price;
    private String category;
    private Double guaranty;
    private List<String> imageUrl;

    public Announcement() {
    }

    public Announcement
    (
        String title, 
        String description, 
        String location,
        Double price, 
        String category, 
        Double guaranty,
        List<String> imageUrl
    ) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.price = price;
        this.category = category;
        this.guaranty = guaranty;
        this.imageUrl = imageUrl;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public void setGuaranty(Double guaranty) {
        this.guaranty = guaranty;
    }
    public Double getGuaranty() {
        return guaranty;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public void save(Announcement announcement) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
   
    
}