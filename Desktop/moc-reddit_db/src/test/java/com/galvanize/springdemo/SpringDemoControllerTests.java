package com.galvanize.springdemo;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
final class SpringDemoControllerTests {

	@Autowired
	MockMvc mvc;

	@Autowired
	private CountryRepository repo;

	@Test
	public void testHomepage() throws Exception {
		this.mvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello from Spring!"));
	}

	@Test
	@Transactional
	@Rollback
	public void createAndReadOneCountry() throws Exception {
		String countryName = "Peru";

		// POST an item
		MvcResult result = this.mvc.perform(post("/countries")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"" + countryName + "\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(countryName)))
				.andReturn();

		Integer id = JsonPath.read(result.getResponse().getContentAsString(), "$.id");

		// GET the item
		this.mvc.perform(get("/countries/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(countryName)));
	}

	@Test
	@Transactional
	@Rollback
	public void readAllCountries() throws Exception {
		// GET the item
		this.mvc.perform(get("/countries")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}


//	@Test
//	public void testObject() throws Exception {
//		RequestBuilder request = get("/countries")
//				.accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON);
//
//		this.mvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.firstName", is("Dwayne")))
//				.andExpect(jsonPath("$.lastName", is("Johnson")));
//	}
//
//	@Test
//	public void testArray() throws Exception {
//		RequestBuilder request = get("/countries")
//				.accept(MediaType.APPLICATION_JSON)
//				.contentType(MediaType.APPLICATION_JSON);
//
//		this.mvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$[0].firstName", is("Dwayne")))
//				.andExpect(jsonPath("$[0].lastName", is("Johnson")));
//	}

	// For reading JSON from fixture files in test/resources
	private String getJSON(String path) throws Exception {
		URL url = this.getClass().getResource(path);
		return new String(Files.readAllBytes(Paths.get(url.getFile())));
	}

}