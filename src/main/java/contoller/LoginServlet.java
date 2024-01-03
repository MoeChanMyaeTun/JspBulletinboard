package contoller;

import java.io.IOException;
//import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserRepository;
import models.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepository userRepository;

	public LoginServlet() {
		this.userRepository = new UserRepository();
	}
	  private String hashPassword(String password) {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		String hashPasswords= hashPassword(password);
		User loginUser = userRepository.loginUser(userName, hashPasswords);
		
		if (loginUser != null && loginUser.getName().equalsIgnoreCase(userName)
				&& loginUser.getPassword().equals(hashPasswords)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", loginUser);
			response.sendRedirect("views/home.jsp");
		} else {
			request.setAttribute("errorMessage", "Invalid username or password");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
}
