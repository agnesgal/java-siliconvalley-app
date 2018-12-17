package com.valley.app.viewmodel;

import com.valley.app.model.Company;

public class CompanyView {

    public static CompanyView create(Company company) {
        CompanyView cv = new CompanyView();
        cv.logo = company.getLogo();
        cv.name = company.getName();
        cv.id = company.getId();

        return cv;
    }

    public String name;
    public String logo;
    public Long id;
}
