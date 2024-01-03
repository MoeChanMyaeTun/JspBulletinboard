<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Store</title>

<!-- CDN link tailwind CSS  -->
<script src="https://cdn.tailwindcss.com"></script>
<style>
	.clearfix::after {
    content: "";
    display: table;
    clear: both;
  }
</style>
</head>
<body>
	<nav class="bg-purple-300">
		<div
			class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto py-2">
			<a href="/Bulletinboard_OJT/views/home.jsp"
				class="flex items-center space-x-3 rtl:space-x-reverse"> <span
				class="self-center text-2xl font-semibold whitespace-nowrap text-zinc-600">BookStore</span>
			</a>
			<div class="flex md:order-2">
					<a href="/Bulletinboard_OJT/views/index.jsp"
						class="block py-2 px-3 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 text-zinc-600 font-medium">Logout</a>
				</div>
				<ul
					class="flex flex-col p-4 md:p-0 mt-4 font-medium  md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 text-zinc-600">
					<li><a href="/Bulletinboard_OJT/views/home.jsp"
						class="block py-2 px-3 bg-blue-700 rounded md:bg-transparent md:hover:text-blue-700 md:p-0 "
						aria-current="page">Home</a></li>
					<li><a href="<%=request.getContextPath() + "/UserServlet"%>"
						class="block py-2 px-3  rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0">User
							list</a></li>
					<li><a href="<%=request.getContextPath() + "/PostServlet"%>"
						class="block py-2 px-3 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 ">Post</a>
					</li>
					
				</ul>
			</div>
		</div>
	</nav>