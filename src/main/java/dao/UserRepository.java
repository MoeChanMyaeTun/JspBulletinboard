package dao;

import common.DbConnection;
import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	// Insert a new user into the 'users' table
	private static final String INSERT_USERS_SQL = "Insert Into users" + "(name, email, password) Value" + "(?, ?, ?);";

	// Select a user by their ID from the 'users' table
	private static final String SELECT_USERS_BY_ID = "select id, name, email, password from users where id = ?;";

	// Select all users from the 'users' table
	private static final String SELECT_ALL_USERS = "select * from users";

	// Delete a user from the 'users' table by their ID
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";

	// Update a user in the 'users' table by their ID
	private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ?, password = ? where id = ?;";

	public User loginUser(String name, String password) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?")) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"),
							resultSet.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// create new user

	public boolean addNewUser(String name, String email, String password) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);

			int result = preparedStatement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	// Retrieve id
	public User getUserById(int Userid) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID)) {
			preparedStatement.setInt(1, Userid);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"),
							resultSet.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// show all user
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		try (Connection connection = new DbConnection().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS)) {
			while (resultSet.next()) {
				userList.add(new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"),
						resultSet.getString("password")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	// delete user by id
	public boolean deleteUser(int userId) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {

			preparedStatement.setInt(1, userId);

			int result = preparedStatement.executeUpdate();
			return result > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// update user by id
	public boolean updateUser(int userId, String name, String email, String password) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setInt(4, userId);

			int result = preparedStatement.executeUpdate();
			return result > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
