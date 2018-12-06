package com.valley.app.service;

import com.valley.app.model.Company;
import com.valley.app.model.Product;
import com.valley.app.repository.CompanyRepository;
import com.valley.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAndCompanyService {

    @Autowired
    CompanyRepository coRepo;
    @Autowired
    ProductRepository pRepo;

    public void createDatabase() {
        if(coRepo.findAll().size() >= 5 && pRepo.findAll().size() >= 3) return;

        Company apple = new Company("Apple", "/img/portfolio/apple.png", "Steve Jobs and Steve Wozniak...", 1976, true, null);
        Company microsoft = new Company("Microsoft", "/img/portfolio/microsoft.png", "Windows and blabla...", 1976, true, null);
        Company facebook = new Company("Facebook", "/img/portfolio/facebook.png", "Mark Zuckerberg revolutionary idea based on...", 2008, true, null);
        Company asus = new Company("Asus", "/img/portfolio/asus.png", "Repuclib", 2008, false, null);
        Company lenovo = new Company("Lenovo", "/img/portfolio/lenovo.png", "Something revolutainry here as well", 1995, false, null);

        coRepo.save(apple);
        coRepo.save(microsoft);
        coRepo.save(facebook);
        coRepo.save(asus);
        coRepo.save(lenovo);

        Product p1 = new Product("iPhone 7", "Seventh time....", 2016, null);
        Product p2 = new Product("Macintosh", "Classic vintage computer with GUI....", 1984, null);
        Product p3 = new Product("ROG Strix", "Gamer laptop", 2017, null);

        pRepo.save(p1);
        pRepo.save(p2);
        pRepo.save(p3);

        p1.setCompany(apple);
        p2.setCompany(facebook);
        p3.setCompany(asus);
    }

}
