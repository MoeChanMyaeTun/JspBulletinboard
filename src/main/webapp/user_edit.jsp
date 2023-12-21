<jsp:include page="layouts/header.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="models.User"%>
<%@ page import="dao.UserRepository"%>

<h2>Edit User Details:</h2>

<%
        int userId = 0; 
        String userIdParam = request.getParameter("id");
        if (userIdParam != null && !userIdParam.isEmpty()) {
            userId = Integer.parseInt(userIdParam);
        } 
        User user = UserRepository.getUserById(userId);
    %>


<form class="max-w-md mx-auto" method="post"
	action="UserServlet?action=update&id=<%= user.getId() %>">
	<div class="mb-5">
		<label for="name" class="w-1/4 mb-2 text-sm font-medium text-gray-900">Name
			: </label> <input type="text" name="name" value="<%= user.getName() %>"
			class="w-3/4 border border-purple-300 p-2 bg-purple-50 rounded-lg ml-2">
	</div>
	<div class="mb-5">
		<label for="email"
			class="w-1/4 mb-2 text-sm font-medium text-gray-900">Email :
		</label> <input type="text" name="email" value="<%= user.getEmail() %>"
			class="w-3/4 border border-purple-300 p-2 bg-purple-50 rounded-lg ml-2">
	</div>
	<div class="mb-5">
		<label for="email"
			class="w-1/4 mb-2 text-sm font-medium text-gray-900"></label> <input
			type="submit" value="Update"
			class="w-3/4 border border-purple-300 p-2 bg-purple-50 rounded-lg ml-2">
	</div>

</form>


<jsp:include page="layouts/footer.jsp"></jsp:include>