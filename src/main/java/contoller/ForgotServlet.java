package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import dao.UserRepository;

@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	 int id = Integer.parseInt(request.getParameter("id"));
//         User existingUser = UserRepository.getUserById(id);
//
//        if (existingUser != null) {
//            // Generate a unique token for password reset
//            String resetToken = generateUniqueToken();
//
//            // Save the token in the database (you may use a service for this)
//            UserRepository.updatePassword(existingUser, resetToken);
//
//            // Send the reset link to the user's email
//            UserRepository.sendResetEmail(existingUser, resetToken);
//
//            // Forward to a confirmation page
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//        } else {
//            // Forward to an error page if the email is not found
//            request.getRequestDispatcher("views/forgot_password.jsp").forward(request, response);
//        }
//    }
//
//    private String generateUniqueToken() {
//        // Implement your token generation logic
//        // This could involve using a secure random generator or a time-based approach
//        // Return the generated token
//        return "generatedToken";
//    }
}
