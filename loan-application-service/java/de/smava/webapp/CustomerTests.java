package de.smava.webapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import de.smava.homework.customer.CustomerApplication;
import de.smava.homework.customer.repository.CustomerRepository;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class CustomerTests {
	
    @Autowired
    private WebApplicationContext context;

	MockMvc buildMvCMock;
	
	@Autowired
	private CustomerRepository rep;
    
	

	private static final String SERVICE_ENDPOINT = "http://localhost:9181/customers";
	
	//Test and valid request
	//T1 - Test a valid request 
	@Test
	public void test_ValidRequest() throws Exception {		
		String Request = "{\n" + 
				" \"userId\": 1,\n" + 
				" \"firstName\": \"THIS IS A TEST\",\n" + 
				" \"lastName\": \"THIS IS A TEST\",\n" + 
				" \"email\": \"johnsmith@example.com\",\n" + 
				" \"phone\": \"THIS IS A TEST\"\n" + 
				"}\n"
			+ "}"; 
		buildMvCMock = MockMvcBuilders.webAppContextSetup(context).build();
		buildMvCMock.perform(post(SERVICE_ENDPOINT)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(Request))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.id").isNotEmpty());
		
		System.out.println("TESTE"+jsonPath("$.id"));
		//rep. deleteById(jsonPath("$.id").toString());
			      
	}
	@Test
	public void test_UserNotFound() throws Exception {		
		String Request = "{\n" + 
				" \"userId\": 200,\n" + 
				" \"firstName\": \"THIS IS A TEST\",\n" + 
				" \"lastName\": \"THIS IS A TEST\",\n" + 
				" \"email\": \"johnsmith@example.com\",\n" + 
				" \"phone\": \"THIS IS A TEST\"\n" + 
				"}\n"
			+ "}"; 
		buildMvCMock = MockMvcBuilders.webAppContextSetup(context).build();
		buildMvCMock.perform(post(SERVICE_ENDPOINT)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(Request))
	                .andExpect(status().isNotFound());
		
		
			      
	}
	



}
