package contoller;
import dao.UserRepository;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;
    private UserRepository userRepository;
    public UserServlet() {
    	this.userRepository = new UserRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                	try {
                		 insertUser(request, response);
                	}catch(SQLException e) {
                		e.printStackTrace();
                	}
                    break;
                case "/delete":
                    try {
                    	 deleteUser(request, response);
	               	}catch(SQLException e) {
	               		e.printStackTrace();
	               	}
                    break;
                case "/edit":
                    try {
                    	showEditForm(request, response);
	               	}catch(SQLException e) {
	               		e.printStackTrace();
	               	}
                    break;
                case "/update":
                    try {
                    	updateUser(request, response);
	               	}catch(SQLException e) {
	               		e.printStackTrace();
	               	}
                    break;
                default:
                    try {
                    	listUsers(request, response);
	               	}catch(SQLException e) {
	               		e.printStackTrace();
	               	}
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, IOException {
       String name = request.getParameter("name");
       String email = request.getParameter("email");
       String password = request.getParameter("password");
       userRepository.addNewUser(name, email, password);
       response.sendRedirect("list");
   }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> userList = userRepository.getAllUsers();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
        dispatcher.forward(request, response);
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userRepository.deleteUser(id);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userRepository.getUserById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        userRepository.updateUser(id, name, email, password);
        response.sendRedirect("list");
    }
        
}

