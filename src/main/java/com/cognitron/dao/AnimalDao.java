package com.cognitron.dao;

import com.cognitron.model.Animal;
import org.apache.commons.dbutils.DbUtils;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao {

	private static final Logger LOGGER = Logger.getLogger(AnimalDao.class);

	public List<Animal> getAllAnimals() {
		List<Animal> animals = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection(connection);
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from animal");
			while (rs.next()) {
				Animal animal = new Animal(rs.getString("name"), rs.getString("speciesName"));
				animals.add(animal);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
			throw new RuntimeException();
		} finally {
			DbUtils.closeQuietly(statement);
			DbUtils.closeQuietly(connection);
		}

		return animals;
	}

	public boolean insertAnimal(Animal animal) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection(connection);
			preparedStatement = connection.prepareStatement("insert into  animal(name, speciesName) VALUES(?, ?)");
			preparedStatement.setString(1, animal.getName());
			preparedStatement.setString(2, animal.getSpeciesName());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			LOGGER.error(e);
			throw new RuntimeException();
		} finally {
			DbUtils.closeQuietly(preparedStatement);
			DbUtils.closeQuietly(connection);
		}

	}

	public boolean deleteAnimal(Animal animal) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection(connection);
			preparedStatement = connection.prepareStatement("delete from animal where name=? and speciesName= ?");
			preparedStatement.setString(1, animal.getName());
			preparedStatement.setString(2, animal.getSpeciesName());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			LOGGER.error(e);
			throw new RuntimeException();
		} finally {
			DbUtils.closeQuietly(preparedStatement);
			DbUtils.closeQuietly(connection);
		}
	}

	private Connection getConnection(Connection connection) throws SQLException {

		System.out.println("Working Directory = " +
				System.getProperty("user.dir"));
		return DriverManager.getConnection("jdbc:sqlite:animal.db");
	}

}
