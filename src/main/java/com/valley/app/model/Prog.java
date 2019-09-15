package com.valley.app.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="prog")
public class Prog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String logo;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int year;

    @ManyToMany(mappedBy = "company")
    @Column(nullable = false)
    private List<Company> companiesList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Company> getCompaniesList() {
        return companiesList;
    }

    public void setCompaniesList(List<Company> companiesList) {
        this.companiesList = companiesList;
    }

    public Prog() {
    }

    public Prog(String name, String logo, String description, int year, List<Company> companiesList) {
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.year = year;
        this.companiesList = companiesList;
    }
}
