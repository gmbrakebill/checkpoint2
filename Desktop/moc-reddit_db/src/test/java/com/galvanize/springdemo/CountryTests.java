package com.galvanize.springdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class CountryTests {

	@Test
	public void setGetId() {
		Country c = new Country();
		Long id = 123456789L;
		c.setId(id);
		assertEquals(c.getId(), id);
	}

	@Test
	public void setGetName() {
		Country c = new Country();
		c.setName("Peru");
		assertEquals(c.getName(), "Peru");
	}

}