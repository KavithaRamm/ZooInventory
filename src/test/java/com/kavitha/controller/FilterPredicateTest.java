package com.kavitha.controller;

import com.kavitha.model.Animal;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilterPredicateTest {

	@Test
	public void test_returnsTrue_whenMatchOnName() throws Exception {
		assertTrue(new FilterPredicate("Sim").test(new Animal("Simba", "Lion")));
	}

	@Test
	public void test_shouldMatchOnSpeciesName() throws Exception {
		assertTrue(new FilterPredicate("Lio").test(new Animal("Simba", "Lion")));
	}


	@Test
	public void test_returnsFalse_whenMatchNoMatch() throws Exception {
		assertFalse(new FilterPredicate("Lion").test(new Animal("Simba", "Tiger")));
	}

}