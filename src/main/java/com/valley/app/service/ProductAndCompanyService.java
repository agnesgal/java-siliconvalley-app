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
        Company intel = new Company("Intel", "/img/portfolio/intel.png", "For nearly 40 years, Intel Corporation has been at the forefront of silicon innovation. Today it is the world leader in developing technologies, products, and initiatives to continually advance how people work and live. Intel’s early history is legendary. The company was established in 1968 by Robert N. Noyce, cofounder of the integrated circuit, and Gordon E. Moore, a colleague of Noyce’s from Fairchild Semiconductor, to make semiconductor memory more practical and affordable.", 1968, true, "/img/portfolio/intel-backg.jpg", null);
        Company ebay = new Company("Ebay", "/img/portfolio/ebay.png", "After spending Labor Day weekend at home writing code on his personal computer, eBay founder Pierre Omidyar launches AuctionWeb, a site dedicated to bringing together buyers and sellers in an honest and open marketplace. Canadian Mark Fraser purchased the first item that eBay founder Pierre Omidyar listed on the site in 1995 -- a broken laser pointer. Pierre hires employee #1, Chris Agarpao, to help coordinate the fast-growing company’s online operations. Over twenty years later, Chris is still an eBay employee. The total value of merchandise sold on AuctionWeb reaches $7.2 million.", 1995, true, "/img/portfolio/ebay-backg.jpeg", null);
        Company yahoo = new Company("Yahoo!", "/img/portfolio/yahoo.Jpg", "Yahoo! was started at Stanford University. It was founded in January 1994 by Jerry Yang and David Filo, who were Electrical Engineering graduate students when they created a website named \"Jerry and David's Guide to the World Wide Web\". The Guide was a directory of other websites, organized in a hierarchy, as opposed to a searchable index of pages. In April 1994, Jerry and David's Guide to the World Wide Web was renamed \"Yahoo!\". The word \"YAHOO\" is a backronym for \"Yet Another Hierarchically Organized Oracle\" or \"Yet Another Hierarchical Officious Oracle.\" The yahoo.com domain was created on January 18, 1995.", 1994, true, "/img/portfolio/yahoo-backg.jpg", null);
        Company ea = new Company("Electronic Arts", "/img/portfolio/ea.png", "Electronic Arts founder Trip Hawkins had a lifelong fascination with games. \"I fell in love with complex board games like Strat-O-Matic and Dungeons & Dragons,\" he told us. \"I realized I was making invaluable social connections from playing games and that my brain was more active.\" In the summer of 1975 I learned about the invention of the microprocessor and about the first retail store where a consumer could rent a timesharing terminal to use from home,\" he remembered. \"That very day I committed to found EA in 1982. I figured that it would take seven years for enough computing hardware to get into homes to create an audience for the computer games that I wanted to make.\" After graduating from Harvard, Hawkins moved across the country to pursue an MBA at Stanford, a decision that placed him at ground zero of the personal computer revolution. \"When I finished my education in 1978 I got a job at Apple. When I started there, we had only fifty employees and had sold only 1,000 computers in the history of the company, most of them in the prior year. Four years later we were a Fortune 500 company with 4,000 employees and nearing $1 billion in annual revenue.\"", 1982,true, "/img/portfolio/ea-backg.jpg",null);
        Company cisco = new Company("Cisco Systems", "/img/portfolio/cisco.png", "Just as San Francisco, for which Cisco Systems is named, provides a gateway to the Pacific Rim, Cisco provides the networking technology that is the gateway to computer-based communication. This Silicon Valley giant is the worldwide market leader in routing, switching, unified communications, wireless communication, and security. Cisco was founded in order to enable communication. In 1984, founders Len Bosack and Sandy Lerner were experimenting at Stanford University to connect detached networks in two separate buildings on campus. After running network cables between the two buildings, and connecting them with bridges and then routers, the two realized that to make the disparate networks talk to each other and share information, a technology was needed that could handle the different local area protocols. So Bosack and Lerner invented the multi-protocol router, which they launched in 1986. By 1989, with only three products and 111 employees, Cisco’s revenues were $27 million.", 1984, true, "/img/portfolio/cisco-backg.png", null);
        Company uber = new Company("Uber", "/img/portfolio/uber.png", "Uber’s story began in Paris in 2008. Two friends, Travis Kalanick and Garrett Camp, were attending the LeWeb, an annual tech conference the Economist describes as “where revolutionaries gather to plot the future. In 2007, both men had sold startups they co-founded for large sums. Kalanick sold Red Swoosh to Akamai Technologies for $19 million while Camp sold StumbleUpon to eBay for $75 million. Rumor has it that the concept for Uber was born one winter night during the conference when the pair was unable to get a cab. Initially, the idea was for a timeshare limo service that could be ordered via an app. After the conference, the entrepreneurs went their separate ways, but when Camp returned to San Francisco, he continued to be fixated on the idea and bought the domain name UberCab.com.", 2009, true, "/img/portfolio/uber-backg.jpg", null);


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
        companyRepository.save(intel);
        companyRepository.save(ebay);
        companyRepository.save(yahoo);
        companyRepository.save(ea);
        companyRepository.save(cisco);
        companyRepository.save(uber);

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
        productRepository.save(p5);
    }

}
