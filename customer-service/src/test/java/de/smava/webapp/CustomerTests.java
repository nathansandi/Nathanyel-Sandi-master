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

import de.smava.homework.customer.CustomerApplication;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class CustomerTests {
	
    @Autowired
    private WebApplicationContext context;

	MockMvc buildMvCMock;

	private static final String SERVICE_ENDPOINT = "http://localhost:9181/customers";
	
	//Test and valid request
	//T1 - Test a valid request 
	@Test
	public void test_ValidRequest() throws Exception {		
		String Request = "{\n" + 
				" \"userId\": 2,\n" + 
				" \"firstName\": \"THIS IS A TEST\",\n" + 
				" \"lastName\": \"THIS IS A TEST\",\n" + 
				" \"email\": \"THISISATEST@example.com\",\n" + 
				" \"phone\": \"+49 123 456 78 910\"\n" + 
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
				" \"userId\": -222313,\n" + 
				" \"firstName\": \"THIS IS A TEST\",\n" + 
				" \"lastName\": \"THIS IS A TEST\",\n" + 
				" \"email\": \"THISISATEST@example.com\",\n" + 
				" \"phone\": \"+49 123 456 78 910\"\n" + 
				"}\n" + 
				""; 
		buildMvCMock = MockMvcBuilders.webAppContextSetup(context).build();
		buildMvCMock.perform(post(SERVICE_ENDPOINT)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(Request))
	                .andExpect(status().isNotFound());
		
		
			      
	}
	



}
