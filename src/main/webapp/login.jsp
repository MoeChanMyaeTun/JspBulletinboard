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
	<section class="bg-purple-100 ">
		<div
			class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
			<div
				class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
				<div class="p-6 space-y-4 md:space-y-6 sm:p-8">
					<h1
						class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
						Sign in to your account</h1>
					<c:if test="${not empty errorMessage}">
						<p style="color: red;">${errorMessage}</p>
					</c:if>
					<form class="space-y-4 md:space-y-6" action="LoginServlet"
						method="post">

						<div>
							<label for="name"
								class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your
								name</label> <input type="text" name="name" id="name"
								class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
								placeholder="Enter your name" required="">
						</div>
						<div>
							<label for="password"
								class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
							<input type="password" name="password" id="password"
								class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
								placeholder="Enter your password" required="">
						</div>
						<div class="flex items-center justify-between">
							<div class="flex items-start">
								<p class="text-sm font-light text-gray-500 dark:text-gray-400">
									<a href="#"
										class="font-medium text-primary-600 hover:underline dark:text-primary-500">Sign
										up</a>
								</p>
							</div>
							<a href="#"
								class="text-sm font-medium text-primary-600 hover:underline dark:text-primary-500">Forgot
								password?</a>
						</div>
						<button type="submit"
							class="w-full bg-purple-500 py-2 rounded-lg text-white">Sign
							in</button>
					</form>
				</div>
			</div>
		</div>
	</section>

</body>
</html>