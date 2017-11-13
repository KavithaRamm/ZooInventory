package com.kavitha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;


public class ZooStartup extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Interview Assignment");

		try {
			FXMLLoader loader = new FXMLLoader(ZooStartup.class.getResource("ZooMaintScreen.fxml"));
			VBox page = (VBox) loader.load();
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("starting " + Arrays.asList(args));
		launch(args);
	}
}
