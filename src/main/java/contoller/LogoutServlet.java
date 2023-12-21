package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		   Object session;
//		if (session != null) {
//	            // Clear authentication-related attributes
//	            ((ServletRequest) session).removeAttribute("name");
//
//	            // Invalidate the session
//	            ((Object) session).invalidate();
//	        }

	        // Redirect to the login page after logout
	        response.sendRedirect("login.jsp");
	}

}
