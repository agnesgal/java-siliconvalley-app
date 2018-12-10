package com.valley.app.controller;

import com.auth0.SessionUtils;
import com.valley.app.model.Company;
import com.valley.app.model.User;
import com.valley.app.repository.CompanyRepository;
import com.valley.app.repository.UserRepository;
import com.valley.app.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CompanyControllerTest {

    @MockBean
    private CompanyRepository companyRepository;

    @MockBean
    private UserService userService;

    @InjectMocks
    private  CompanyController companyController;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    protected MockHttpSession session;


    private Long id;
    private String stringId;
    private User testUser;
    private Company testCompany;
    private List<Company> testCompanyList = new ArrayList<>();

    @Before
    public void setup() {

        session.setAttribute("accessToken", "123");
        session.setAttribute("idToken", "123");

        id = 2L;
        stringId = "1";

        testCompany = new Company("Microsoft", "/img/portfolio/microsoft.png", "On this day in 1975, at a time when most Americans use typewriters, childhood friends Bill Gates and Paul Allen found Microsoft, a company that makes computer software. Originally based in Albuquerque, New Mexico, Microsoft relocated to Washington State in 1979 and eventually grew into a major multinational technology corporation. In 1987, the year after Microsoft went public, 31-year-old Gates became the world’s youngest billionaire.", 1975, true, "/img/portfolio/microsoft-backg.jpg", null);
        testCompany.setId(id);
        testCompanyList.add(testCompany);
        testUser = new User(stringId, "test@test.com", "TestUser", "TestUser", "TestUser", "TestUser", "testpic.com", "05.12.2018");

        when(companyRepository.getOne(id)).thenReturn(testCompany);
        when(userService.getOurUser()).thenReturn(testUser);
    }

    @WithMockUser(value = "spring")
    @Test
    public void testGetOneCompany() throws Exception {
        mockMvc.perform(get("/company/" + id).session(session))
                .andExpect(status().isOk())
                .andExpect(model().attribute("company", equalTo(testCompany)));

        verify(companyRepository, times(1)).getOne(id);
        verifyNoMoreInteractions(companyRepository);
    }

    @WithMockUser(value = "spring")
    @Test
    public void testGetUser() throws Exception {
        mockMvc.perform(get("/company/" + id).session(session))
                .andExpect(status().isOk())
                .andExpect(model().attribute("name", notNullValue()));
    }

}
