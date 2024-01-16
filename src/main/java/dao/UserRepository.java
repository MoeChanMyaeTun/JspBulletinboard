package dao;

import common.DbConnection;
import models.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ? where id = ?;";
	private static final String Login_User = "SELECT * FROM users WHERE name = ? AND password = ?";
	private static final String CHANGE_PASSWORD = "UPDATE bulletinboard_ojt.users SET password = ? WHERE id = ?;";
	private static final String VERIFY_CREDENTIALS ="SELECT COUNT(*) FROM users WHERE id = ? AND password = ?";
	private static final String RESET_TOKEN = "UPDATE users SET token = ? WHERE id = ?";
	private static final String SAVE_FORGOT = "UPDATE users SET password = ?, reset_token = NULL WHERE id = ?";

	public static void saveResetToken(int userId, String resetToken, String email) {
	        try (Connection connection = new DbConnection().getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(RESET_TOKEN)) {
	            preparedStatement.setString(1, resetToken);
	            preparedStatement.setInt(2, userId);

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	public User loginUser(String name, String password) {

		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Login_User)) {
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
		String hashedPassword = hashPassword(password);
//		try (Connection connection = new DbConnection().getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//			preparedStatement.setString(1, name);
//			preparedStatement.setString(2, email);
//			preparedStatement.setString(3, password);
//
//			int result = preparedStatement.executeUpdate();
//			return result > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
		try (Connection connection = new DbConnection().getConnection();) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, email);
				preparedStatement.setString(3, hashedPassword);
				int result = preparedStatement.executeUpdate();
				return result > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle database errors
			return false;
		}

	}
	
	private static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = md.digest(password.getBytes());
			StringBuilder stringBuilder = new StringBuilder();
			for (byte b : hashedBytes) {
				stringBuilder.append(String.format("%02x", b));
			}
			return stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			// Handle hashing algorithm not available
			return null;
		}
	}

	// Retrieve id
	public static User getUserById(int id) {
		User user = null;
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID)) {
			preparedStatement.setInt(1, id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"),
							resultSet.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	// show all user
	public static List<User> getAllUsers() {
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
	public boolean deleteUser(int id) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {

			preparedStatement.setInt(1, id);

			int result = preparedStatement.executeUpdate();
			return result > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// update user by id
	public boolean updateUser(int id, String name, String email) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, id);

			int result = preparedStatement.executeUpdate();
			return result > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//change password
	public static boolean changePassword(String idString, String hashPasswords, String newPassword) {
		
	    if (verifyCredentials(idString, hashPasswords)) {
	    	String hashedPassword = hashPassword(newPassword);
	        try (Connection connection = new DbConnection().getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_PASSWORD)) {
	        	preparedStatement.setString(1, hashedPassword);
	        	preparedStatement.setString(2, idString);
	            int result = preparedStatement.executeUpdate();
	            return result > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    } else {
	        return false;
	    }
	}

	public static boolean verifyCredentials(String idString, String hashPasswords) {
	    try (Connection connection = new DbConnection().getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(VERIFY_CREDENTIALS)) {
	    	preparedStatement.setString(1, hashPasswords);
	        preparedStatement.setString(2, idString);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            return resultSet.next();
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	 public static void updatePassword(int userId, String newPassword) {
	        try (Connection connection = new DbConnection().getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_FORGOT)) {
	            preparedStatement.setString(1, newPassword);
	            preparedStatement.setInt(2, userId);

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Other methods for user-related database operations...
	}
