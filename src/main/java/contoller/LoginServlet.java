package contoller;

import java.io.IOException;
//import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

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
//	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	            throws ServletException, IOException {
//	        String action = request.getParameter("action");
//	        System.out.println(action);
//	        if ("forgot".equals(action)) {
//	            try {
//	            	showForgotForm(request, response);
//	           	}catch(SQLException e) {
//	           		e.printStackTrace();
//	           	}
//	        }
//	  }

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
//    private void showForgotForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//    	//mail nk sit pay mha ya ml 
//    	// id ma pr lox
//    	 int id = Integer.parseInt(request.getParameter("id"));
//         User existingUser = UserRepository.getUserById(id);
//         RequestDispatcher dispatcher = request.getRequestDispatcher("views/forgot_password.jsp");
//         request.setAttribute("user", existingUser);
//         dispatcher.forward(request, response);
//    }

//    private void forgotPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Extract user email from the request
//        String email = request.getParameter("email");
//        User saveResetToken = userRepository.saveResetToken(userId, resetToken, email);
//        // Check if the email exists in the database
//        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = UserRepository.getUserById(id);
//
//        if (existingUser != null) {
//            // Generate a unique token for password reset
//            String resetToken = generateUniqueToken();
//
//            // Save the reset token in the database
//            UserRepository.saveResetToken(existingUser.getId(), resetToken);
//
//            // Forward to a confirmation page
//            request.getRequestDispatcher("resetConfirmation.jsp").forward(request, response);
//        } else {
//            // Forward to an error page or forgot password form with an error message
//            request.getRequestDispatcher("forgotPasswordError.jsp").forward(request, response);
//        }
//    }
//
//    // Implement your logic for generating a unique token
//    private String generateUniqueToken() {
//        // ...
//        return "uniqueToken";
//    }
}
