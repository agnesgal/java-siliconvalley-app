package com.valley.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String logo;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int foundationYear;

    @Column(nullable = false)
    private boolean isSilicon;

    @OneToMany(mappedBy = "company")
    private List<Product> productList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public boolean isSilicon() {
        return isSilicon;
    }

    public void setSilicon(boolean silicon) {
        isSilicon = silicon;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Company() {
    }

    public Company(String name, String logo, String description, int foundationYear, boolean isSilicon, List<Product> productList) {
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.foundationYear = foundationYear;
        this.isSilicon = isSilicon;
        this.productList = productList;
    }
}
