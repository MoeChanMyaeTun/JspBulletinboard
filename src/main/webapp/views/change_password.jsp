<jsp:include page="../layouts/header.jsp"></jsp:include>
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
<section class="bg-purple-100">
	<div
		class="flex flex-col items-center justify-center px-6 py-6 mx-auto md:h-screen lg:py-0">
		<div
			class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0">
			<div class="p-6 space-y-4 md:space-y-6 sm:p-8">
				<h1
					class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
					Change Password</h1>
				<form class="space-y-4 md:space-y-6" method="post" action="UserServlet?action=changePassword&id=<%=user.getId()%>">
					<div>
						<label for="currentPassword"
							class="block mb-2 text-sm font-medium text-gray-900">Current
							Password</label> <input type="password" name="currentPassword"
							id="currentPassword"
							class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
							placeholder="Enter your current password">
					</div>
					<div>
						<label for="newPassword"
							class="block mb-2 text-sm font-medium text-gray-900">New
							Password</label> <input type="password" name="newPassword"
							id="newPassword"
							class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
							placeholder="Enter your new password">
					</div>
					<button type="submit"
						class="w-full bg-purple-500 py-2 rounded-lg text-white">Submit</button>
				</form>
			</div>
		</div>
	</div>
	</section>
		<jsp:include page="../layouts/footer.jsp"></jsp:include>