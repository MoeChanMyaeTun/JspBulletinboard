<jsp:include page="../layouts/header.jsp"></jsp:include>
<%@ page import="java.util.List"%>
<%@ page import="models.User"%>
<%@ page import="dao.UserRepository"%>
<%@ page import="java.util.ArrayList"%>

<div class="relative  shadow-md  w-10/12 my-5 mx-auto ">

	<table class="w-full text-sm text-left rtl:text-right text-gray-500">
		<thead
			class="text-xs text-gray-700 uppercase bg-purple-100 text-center">
			<tr>
				<th scope="col" class="px-6 py-3">Id</th>
				<th scope="col" class="px-6 py-3">Name</th>
				<th scope="col" class="px-6 py-3">Email</th>
				<th scope="col" class="px-6 py-3">Action</th>
			</tr>
		</thead>
		<tbody class="text-center">
			<%
				  List<User> userList = UserRepository.getAllUsers();
				
				  for (User user : userList) {
			%>
			<tr class="odd:bg-white">
				<th scope="row"
					class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap">
					<%= user.getId() %>

				</th>
				<th scope="row"
					class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap">
					<a href="<%=request.getContextPath() + "/UserServlet?action=detail&id="+ user.getId() %>"><%= user.getName() %></a>
				</th>
				<td class="px-6 py-4"><%= user.getEmail() %></td>
				<td class="px-6 py-4"><a
					href="<%=request.getContextPath() + "/UserServlet?action=edit&id="+ user.getId() %>">Edit</a>
					<form action="<%=request.getContextPath() + "/UserServlet?action=delete&id="+ user.getId() %>"
						method="post">
						<input type="submit" value="Delete">
					</form></td>
			</tr>
			<%
		    }
		 %>


		</tbody>
	</table>


</div>

<jsp:include page="../layouts/footer.jsp"></jsp:include>