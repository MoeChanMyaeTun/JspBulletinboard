<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Store</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<section class="bg-purple-100">
		<div
			class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
			<div
				class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0">
				<div class="p-6 space-y-4 md:space-y-6 sm:p-8">
					<h1
						class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
						Create and account</h1>
					<form class="space-y-4 md:space-y-6" action="<%=request.getContextPath() + "/RegisterServlet"%>"
						method="post">
						
						<div>
							<label for="name" class="block mb-2 text-sm font-medium">Your
								name</label> <input type="text" name="name" id="name"
								class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
								placeholder="Enter your name" required="">
						</div>
						<div>
							<label for="email" class="block mb-2 text-sm font-medium">Your
								email</label> <input type="email" name="email" id="email"
								class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
								placeholder="name@gmail.com" required="">
						</div>
						<div>
							<label for="password"
								class="block mb-2 text-sm font-medium text-gray-900">Password</label>
							<input type="password" name="password" id="password"
								placeholder="Enter your password"
								class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
								required="">
						</div>
						<button type="submit"
							class="w-full bg-purple-500 py-2 rounded-lg text-white">Create
							an account</button>
						<p class="text-sm font-light text-gray-500">
							Already have an account? <a href="/Bulletinboard_OJT/login.jsp"
								class="font-medium text-primary-600 hover:underline">Login
								here</a>
						</p>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>