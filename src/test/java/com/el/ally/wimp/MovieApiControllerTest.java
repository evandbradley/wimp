package com.el.ally.wimp;

import static org.junit.Assert.*;

import java.sql.Date;

import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import com.el.ally.wimp.models.Movie;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
@WebAppConfiguration
public class MovieApiControllerTest {
	
	
	private MockMvc mockMvc;
	
	private WebApplicationContext wac;

	@Test
	public void test() throws Exception {
		//Movie mockMovie = new Movie("Mock", Date.valueOf("1999-11-14"), 100, "Acme Pictures");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		String expected = "{id:1,title:Godfather,releaseDate:60033499200000,budget:3000000,distributor:MGM";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
