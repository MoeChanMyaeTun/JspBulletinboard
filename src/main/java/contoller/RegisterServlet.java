package contoller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserRepository;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        System.out.println("hello");

	        // Your other code for handling the GET request goes here
	    }
		private UserRepository userRepository;
	 
	 	/**
	 	 * @see HttpServlet#HttpServlet()
	 	 */
	 	public RegisterServlet() {
	 		this.userRepository = new UserRepository();
	 	}
	 
	 	/**
	 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 	 *      response)
	 	 */
	 	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 			throws ServletException, IOException {
	 		String userName = request.getParameter("name");
	 		String email = request.getParameter("email");
	 		String password = request.getParameter("password");
	 		userRepository.addNewUser(userName, email, password);
	 		RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
	 		dispatcher.forward(request, response);
	 	}

}
