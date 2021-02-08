package de.smava.webapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import de.smava.homework.loan.LoanApplication;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoanApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class LoanTests {
	
    @Autowired
    private WebApplicationContext context;

	MockMvc buildMvCMock;

	private static final String SERVICE_ENDPOINT = "http://localhost:9182/api/loanapplications";
	
	//Test and valid request
	//T1 - Test a valid request 
	@Test
	public void test_ValidRequest() throws Exception {		
		String Request = "{\n" + 
				" \"customerId\": \"1\",\n" + 
				" \"amount\": 1000,\n" + 
				" \"duration\": 11\n" + 
				"}\n" + 
				""; 
		buildMvCMock = MockMvcBuilders.webAppContextSetup(context).build();
		buildMvCMock.perform(post(SERVICE_ENDPOINT)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(Request))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.id").isNotEmpty());
		
			      
	}
	@Test
	public void test_CustomerNotFound() throws Exception {		
		String Request = "{\n" + 
				" \"customerId\": \"0\",\n" + 
				" \"amount\": 0000,\n" + 
				" \"duration\": 0000\n" + 
				"}\n" + 
				""; 
		buildMvCMock = MockMvcBuilders.webAppContextSetup(context).build();
		buildMvCMock.perform(post(SERVICE_ENDPOINT)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(Request))
	                .andExpect(status().isBadRequest());
		
		
			      
	}
	



}
