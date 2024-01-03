package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.DbConnection;
import models.Post;

public class PostRepository {
	// Insert a new user into the 'posts' table
	private static final String INSERT_POST = "Insert Into bulletinboard_ojt.posts"
			+ "(book_name, author, price, description) Value" + "(?, ?, ?, ?);";

	// Select a user by their ID from the 'posts' table
	private static final String SELECT_POST_BY_ID = "select id, book_name, author, price, description, image from bulletinboard_ojt.posts where id = ?;";

	// Select all users from the 'posts' table
	private static final String SELECT_ALL_POSTS = "select * from bulletinboard_ojt.posts";

	// Delete a user from the 'posts' table by their ID
	private static final String DELETE_POST_SQL = "delete from bulletinboard_ojt.posts where id = ?;";

	// Update a user in the 'posts' table by their ID
	private static final String UPDATE_POST_SQL = "update bulletinboard_ojt.posts set book_name = ?, author = ?, price= ?, description = ? where id = ?;";

	public boolean addNewPost(String book_name, String author, String price, String description) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POST);) {
			System.out.println("here");
			preparedStatement.setString(1, book_name);
			preparedStatement.setString(2, author);
			preparedStatement.setString(3, price);
			preparedStatement.setString(4, description);
			int result = preparedStatement.executeUpdate();
			System.out.println("result");
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Retrieve id
	public static Post getPostById(int id) {
		Post post = null;
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POST_BY_ID)) {
			preparedStatement.setInt(1, id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return new Post(resultSet.getInt("id"), resultSet.getString("book_name"),
							resultSet.getString("author"), resultSet.getString("price"),
							resultSet.getString("description"), resultSet.getString("image"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

	// show all post
	public static List<Post> getAllPosts() {
		List<Post> postList = new ArrayList<>();
		try (Connection connection = new DbConnection().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_POSTS)) {
			while (resultSet.next()) {
				postList.add(new Post(resultSet.getInt("id"), resultSet.getString("book_name"),
						resultSet.getString("author"), resultSet.getString("price"), resultSet.getString("description"),
						resultSet.getString("image")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return postList;
	}

	// delete user by id
	public boolean deletePost(int id) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_POST_SQL)) {

			preparedStatement.setInt(1, id);

			int result = preparedStatement.executeUpdate();
			return result > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// update user by id
	public boolean updatePost(int id, String book_name, String author, String price, String description) {
		try (Connection connection = new DbConnection().getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_POST_SQL)) {

			preparedStatement.setString(1, book_name);
			preparedStatement.setString(2, author);
			preparedStatement.setString(3, price);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, id);

			int result = preparedStatement.executeUpdate();
			return result > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
