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
    CompanyRepository companyRepository;
    @Autowired
    ProductRepository productRepository;

    public void createDatabase() {
        if(companyRepository.findAll().size() != 0) return;

        Company apple = new Company("Apple", "/img/portfolio/apple.png", "It all started with three men - Steve Jobs, Steve Wozniak, and Mike Markkula - who together in the late 1970's designed and marketed the Apple II series of computers. It was the first commercially successful line of personal computers, and led to the Apple Lisa in 1983 - the first computer to use a mouse-driven GUI (graphical user interface). One year later, the Apple Macintosh was born (launched by one of the greatest ads of all time, 1984), and with it, the Apple legend began to grow.", 1976, true, "/img/portfolio/apple-backg.jpg", null);
        Company microsoft = new Company("Microsoft", "/img/portfolio/microsoft.png", "On this day in 1975, at a time when most Americans use typewriters, childhood friends Bill Gates and Paul Allen found Microsoft, a company that makes computer software. Originally based in Albuquerque, New Mexico, Microsoft relocated to Washington State in 1979 and eventually grew into a major multinational technology corporation. In 1987, the year after Microsoft went public, 31-year-old Gates became the world’s youngest billionaire.", 1975, true, "/img/portfolio/microsoft-backg.jpg", null);
        Company facebook = new Company("Facebook", "/img/portfolio/facebook.png", "Mark Zuckerberg, 23, founded Facebook while studying psychology at Harvard University. A keen computer programmer, Mr Zuckerberg had already developed a number of social-networking websites for fellow students, including Coursematch, which allowed users to view people taking their degree, and Facemash, where you could rate people's attractiveness.", 2004, true, "/img/portfolio/facebook-backg.jpg", null);
        Company asus = new Company("Asus", "/img/portfolio/asus.png", "ASUS has now became a well known name in the world, but a few years back it was quite unknown. We all thought and still think that it is some Chinese brand. Actually, it is a Taiwanese company. The name “ASUS” is taken from a Greek word Pegasus meaning “the winged horse“. ASUS was founded by four hardware engineers, previously working for Acer in 1989. There is a great story about initial success of ASUS.", 1989, false, "/img/portfolio/asus-backg.jpg", null);
        Company lenovo = new Company("Lenovo", "/img/portfolio/lenovo.png", "Lenovo is one of the world's largest personal technology companies, specializing in desktop computers, laptops, tablets, mobile phones and specialty equipment like supercomputers. It is also one of the newest of the major technology companies and does not yet have the brand familiarity of well-known technology firms like Apple, Dell and Samsung. Although founded in 2004 in China, Lenovo has corporate roots dating back to the 1980's.", 1984, false, "/img/portfolio/lenovo-backg.jpeg", null);
        Company tesla = new Company("Tesla", "/img/portfolio/tesla.png", "Formerly Tesla Motors was named after Serbian American inventor Nikola Tesla. Tesla Motors was formed to develop an electric sports car. Eberhard was Tesla’s chief executive officer (CEO) and Tarpenning its chief financial officer (CFO). Funding for the company was obtained from a variety of sources, most notably PayPal cofounder Elon Musk, who contributed more than $30 million to the new venture and served as chairman of the company, beginning in 2004.", 2003, true, "/img/portfolio/tesla-backg.jpg", null);
        Company google = new Company("Google", "img/portfolio/google.png", "Google Inc., American search engine company, founded in 1998 by Sergey Brin and Larry Page that is a subsidiary of the holding company Alphabet Inc. More than 70 percent of worldwide online search requests are handled by Google, placing it at the heart of most Internet users’ experience. Its headquarters are in Mountain View, California. Google began as an online search firm, but it now offers more than 50 Internet services and products, from e-mail and online document creation to software for mobile phones and tablet computers.", 1998, true, "/img/portfolio/google-backg.jpg", null);
        Company sony = new Company("Sony", "/img/portfolio/sony.png", "Sony is one of the world's most widely known electronics companies. Founded in Japan, the company has grown from humble roots to a multinational giant. From the tape player to the Walkman to OLED TV, Sony's tradition of innovation has made it a profitable company for more than 60 years. Kazuo Hirai, who joined the company in 1984 and worked his way up through its media and consumer electronics divisions, became its president and CEO in 2012.", 1946, false, "/img/portfolio/sony-backg.jpg", null);
        Company hp = new Company("Hewlett Packard", "/img/portfolio/hp.png", "Hewlett-Packard Company, American manufacturer of software and computer services. The company split in 2015 into two companies: HP Inc. and Hewlett Packard Enterprise. Headquarters were in Palo Alto, California.Hewlett-Packard became one of the first businesses in the United States to endorse the idea that employees, customers, and the community have as valid an interest in company performance as do shareholders. As a result, it consistently ranked among the best places to work for women and minorities.", 1939, true, "/img/portfolio/hp-backg.jpg", null);

        Product p1 = new Product("iPhone", "/img/portfolio/iphone.png", "Seventh time....", 2016, null);
        Product p2 = new Product("Macintosh", "/img/portfolio/macintosh.png","Classic vintage computer with GUI....", 1984, null);
        Product p3 = new Product("ROG Strix", "/img/portfolio/rog-strix.png", "Gamer laptop", 2017, null);
        Product p4 = new Product("Model S", "/img/portfolio/tesla-s.png", "The Tesla Model S is an all-electric luxury sedan and the first vehicle developed from the ground up by Tesla.", 2005, null);
        Product p5 = new Product("Roadster", "/img/portfolio/tesla-roadster.png", "It is in the space.", 2020, null);

        p1.setCompany(apple);
        p2.setCompany(apple);
        p3.setCompany(asus);
        p4.setCompany(tesla);
        p5.setCompany(tesla);

        companyRepository.save(apple);
        companyRepository.save(microsoft);
        companyRepository.save(facebook);
        companyRepository.save(asus);
        companyRepository.save(lenovo);
        companyRepository.save(tesla);
        companyRepository.save(google);
        companyRepository.save(sony);
        companyRepository.save(hp);

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
        productRepository.save(p5);
    }

}
