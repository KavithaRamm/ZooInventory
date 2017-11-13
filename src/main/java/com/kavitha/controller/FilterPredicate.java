package com.kavitha.controller;


import com.kavitha.model.Animal;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public class FilterPredicate implements Predicate<Animal> {

	private String filterText;

	public FilterPredicate(String filterText) {
		this.filterText = filterText;
	}

	@Override
	public boolean test(Animal animal) {
		if (StringUtils.containsIgnoreCase(animal.getName(), filterText)) {
			return true;
		} else if (StringUtils.containsIgnoreCase(animal.getSpeciesName(), filterText)) {
			return true;
		}
		return false;
	}
}
