package contoller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.PostRepository;
import dao.UserRepository;
import models.Post;
import models.User;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostRepository postRepository;

	public PostServlet() {
		this.postRepository = new PostRepository();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
        if (action == null) {
    	    try {
				listPost(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	} else {
            switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "detail":
                try {
                	showDetailPost(request, response);
               	}catch(SQLException e) {
               		e.printStackTrace();
               	}
                break;
            case "edit":
                try {
                	showEditForm(request, response);
               	}catch(SQLException e) {
               		e.printStackTrace();
               	}
                break;
            default:
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
	            break;    
            }
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("insert".equals(action)) {
			try {
				createPost(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if ("update".equals(action)) {
			try {
				updatePost(request, response);
				;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if ("delete".equals(action)) {
			try {
				deletePost(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/post_create.jsp");
		dispatcher.forward(request, response);
	}

	private void createPost(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String book_name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		postRepository.addNewPost(book_name, author, price, description);
		response.sendRedirect("views/post_list.jsp");
	}

	private void listPost(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Post> postList = PostRepository.getAllPosts();
		request.setAttribute("postList", postList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/post_list.jsp");
		dispatcher.forward(request, response);
	}

	private void showDetailPost(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Post postId = PostRepository.getPostById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/post_detail.jsp");
		request.setAttribute("post", postId);
		dispatcher.forward(request, response);
	}

	 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	           throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Post postId = PostRepository.getPostById(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("views/post_edit.jsp");
	        request.setAttribute("post", postId);
	        dispatcher.forward(request, response);
	    
	    }
	private void updatePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String book_name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		postRepository.updatePost(id, book_name, author, price, description);
		response.sendRedirect("views/post_list.jsp");
	}

	private void deletePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		postRepository.deletePost(id);
		response.sendRedirect("views/post_list.jsp");
	}

}
