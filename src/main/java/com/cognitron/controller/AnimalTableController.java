package com.cognitron.controller;

import com.cognitron.dao.AnimalDao;
import com.cognitron.model.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AnimalTableController {

	@FXML private TextField filterField;
	@FXML private TableView<Animal> animalTable;
	@FXML private TableColumn<Animal, String> nameColumn;
	@FXML private TableColumn<Animal, String> speciesNameColumn;
	@FXML private Button deleteButton;
	@FXML private TextField addName;
	@FXML private TextField addSpeciesName;
	@FXML private Button addButton;

	private AnimalDao animalDao;

	private ObservableList<Animal> masterData = FXCollections.observableArrayList();

	public AnimalTableController() {
		animalDao = new AnimalDao(); //TODO: Can we inject this? This is automatically during load of fxml
		masterData.addAll(animalDao.getAllAnimals());
	}

	@FXML
	private void initialize() {
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		speciesNameColumn.setCellValueFactory(cellData -> cellData.getValue().speciesNameProperty());
		FilteredList<Animal> filteredData = new FilteredList<>(masterData, p -> true);
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(new FilterPredicate(newValue));
		});

		deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Animal selectedItem = animalTable.getSelectionModel().getSelectedItem();
				masterData.remove(selectedItem);
				animalDao.deleteAnimal(selectedItem);
			}
		});

		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Animal animal = new Animal(addName.getText(), addSpeciesName.getText());
				masterData.add(animal);
				animalDao.insertAnimal(animal);
				addName.clear();
				addSpeciesName.clear();

			}
		});

		SortedList<Animal> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(animalTable.comparatorProperty());
		animalTable.setItems(sortedData);
	}

}
