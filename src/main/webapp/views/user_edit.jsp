<jsp:include page="../layouts/header.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="models.User"%>
<%@ page import="dao.UserRepository"%>
<%
        int userId = 0; 
        String userIdParam = request.getParameter("id");
        if (userIdParam != null && !userIdParam.isEmpty()) {
            userId = Integer.parseInt(userIdParam);
        } 
        User user = UserRepository.getUserById(userId);
    %>
<div class="border border-purple-300 w-1/2 mx-auto pb-5 my-40">
	<div class="text-center my-8 text-3xl text-purple-400">
		<h2>Edit User</h2>
	</div>
	<form method="post"
		action="UserServlet?action=update&id=<%=user.getId()%>">
		<table class="w-4/5 mx-auto">
			<tr>
				<td class="w-1/4 text-center py-2"><label for="name"
					class="mb-2 text-sm font-medium text-gray-900">Name : </label></td>
				<td class="w-3/4 py-2"><input type="text" name="name"
					value="<%=user.getName()%>"
					class="w-4/5 border border-purple-300 p-2 bg-purple-50 rounded-lg ml-2"></td>
			</tr>
			<tr class="my-2">
				<td class="w-1/4 text-center py-2"><label for="author"
					class="w-1/4 mb-2 text-sm font-medium text-gray-900">Email
						: </label></td>
				<td class="w-3/4 py-2"><input type="text" name="email"
					value="<%=user.getEmail()%>"
					class="w-4/5 border border-purple-300 p-2 bg-purple-50 rounded-lg ml-2"></td>
			</tr>
			<tr class="my-2">
				<td class="w-1/4 text-center py-2"></td>
				<td class="w-3/4 pt-2 pb-5">
					<button
						class="w-4/5 border border-purple-100 p-2 bg-purple-100 hover:bg-purple-300 rounded-lg ml-2 cursor-pointer hover:text-white">
						Update</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<jsp:include page="../layouts/footer.jsp"></jsp:include>