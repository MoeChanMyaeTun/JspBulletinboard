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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;
    private UserRepository userRepository;
    public UserServlet() {
    	this.userRepository = new UserRepository();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if ("update".equals(action)) {
            try {
            	updateUser(request, response);
           	}catch(SQLException e) {
           		e.printStackTrace();
           	}
        } else {
            // Handle other actions if needed
        }
        if ("delete".equals(action)) {
            try {
            	deleteUser(request, response);
           	}catch(SQLException e) {
           		e.printStackTrace();
           	}
        } else {
            // Handle other actions if needed
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
        if (action == null) {
    	    try {
				listUsers(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	} else {
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
                case "edit":
                    try {
                    	showEditForm(request, response);
	               	}catch(SQLException e) {
	               		e.printStackTrace();
	               	}
                    break;
                case "detail":
                    try {
                    	showDetailUser(request, response);
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
        List<User> userList = UserRepository.getAllUsers();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
        dispatcher.forward(request, response);
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userRepository.deleteUser(id);
        response.sendRedirect("user_list.jsp");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
           throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = UserRepository.getUserById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user_edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        userRepository.updateUser(id, name, email);
        response.sendRedirect("user_list.jsp");
    }
    
    private void showDetailUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	 int id = Integer.parseInt(request.getParameter("id"));
         User existingUser = UserRepository.getUserById(id);
         RequestDispatcher dispatcher = request.getRequestDispatcher("user_detail.jsp");
         request.setAttribute("user", existingUser);
         dispatcher.forward(request, response);
    }
}

