package com.kavitha.model;

import javafx.beans.property.SimpleStringProperty;

public class Animal {

	private final SimpleStringProperty name;
	private final SimpleStringProperty speciesName;

	public Animal(String name, String speciesName) {
		this.name = new SimpleStringProperty(name);
		this.speciesName = new SimpleStringProperty(speciesName);
	}

	public String getName() {
		return name.get();
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}

	public String getSpeciesName() {
		return speciesName.get();
	}

	public SimpleStringProperty speciesNameProperty() {
		return speciesName;
	}
}
