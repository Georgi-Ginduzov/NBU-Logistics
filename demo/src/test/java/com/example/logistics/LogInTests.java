package com.example.logistics;

import com.example.logistics.models.users.Employee;
import com.example.logistics.services.EmployeeDetailsService;
import com.example.logistics.repositories.interfaces.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc
public class LogInTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeDetailsService employeeDetailsService;

    // Test for valid login
    @Test
    @WithMockUser(username = "admin", password = "admin")
    public void testLoginWithValidCredentials() throws Exception {
        mockMvc.perform(post("/login")
                .param("username", "admin")
                .param("password", "admin"))
                .andExpect(status().isOk()) // expects 200 OK if the login is successful
                .andExpect(redirectedUrl("/dashboard")); // assuming this is the redirect after a successful login
    }

    // Test for invalid login attempt
    @Test
    public void testLoginWithInvalidCredentials() throws Exception {
        mockMvc.perform(post("/login")
                .param("username", "wrongUser")
                .param("password", "wrongPassword"))
                .andExpect(status().isUnauthorized()); // expects 401 Unauthorized for invalid credentials
    }

    // Test if login page loads correctly
    @Test
    public void testLoginPage() throws Exception {
        mockMvc.perform(post("/login"))
                .andExpect(status().isOk()); // expects 200 OK as the login page is rendered
    }
}
