package com.galvanize.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
final class SpringDemoTests {

	@Test
	public void testMain() {
		SpringDemo.main(new String[]{""});
		assertTrue(true);
	}

}