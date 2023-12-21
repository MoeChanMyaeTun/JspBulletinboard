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
</head>
<body>
	<nav class="bg-purple-300">
		<div
			class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto py-2">
			<a href="/Bulletinboard_OJT/"
				class="flex items-center space-x-3 rtl:space-x-reverse"> <span
				class="self-center text-2xl font-semibold whitespace-nowrap text-zinc-600">BookStore</span>
			</a>
			<div class="flex md:order-2">
				<button type="button" data-collapse-toggle="navbar-search"
					aria-controls="navbar-search" aria-expanded="false"
					class="md:hidden text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-4 focus:ring-gray-200 rounded-lg text-sm p-2.5 me-1">
					<span class="sr-only">Search</span>
				</button>
				<div class="relative hidden md:block">
					<div
						class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
						<svg class="w-4 h-4 text-gray-500 dark:text-gray-400"
							aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
							viewBox="0 0 20 20">
	          <path stroke="currentColor" stroke-linecap="round"
								stroke-linejoin="round" stroke-width="2"
								d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
	        </svg>
						<span class="sr-only">Search icon</span>
					</div>
					<input type="text" id="search-navbar"
						class="block w-full p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"
						placeholder="Search...">
				</div>
				<button data-collapse-toggle="navbar-search" type="button"
					class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 "
					aria-controls="navbar-search" aria-expanded="false">
					<span class="sr-only">Open main menu</span>
					<svg class="w-5 h-5" aria-hidden="true"
						xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 17 14">
	            <path stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2"
							d="M1 1h15M1 7h15M1 13h15" />
	        		</svg>
				</button>
			</div>
			<div
				class="items-center justify-between hidden w-full md:flex md:w-auto md:order-1"
				id="navbar-search">
				<div class="relative mt-3 md:hidden">
					<div
						class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
						<svg class="w-4 h-4 text-gray-500 dark:text-gray-400"
							aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
							viewBox="0 0 20 20">
	            <path stroke="currentColor" stroke-linecap="round"
								stroke-linejoin="round" stroke-width="2"
								d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
	          </svg>
					</div>
					<input type="text" id="search-navbar"
						class="block w-full p-2 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"
						placeholder="Search...">
				</div>
				<ul
					class="flex flex-col p-4 md:p-0 mt-4 font-medium  md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 text-zinc-600">
					<li><a href="/Bulletinboard_OJT/"
						class="block py-2 px-3 bg-blue-700 rounded md:bg-transparent md:hover:text-blue-700 md:p-0 "
						aria-current="page">Home</a></li>
					<li><a href="UserServlet"
						class="block py-2 px-3  rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0">User
							list</a></li>
					<li><a href="#"
						class="block py-2 px-3 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 ">Post</a>
					</li>
					<li><a href="/Bulletinboard_OJT/login.jsp"
						class="block py-2 px-3 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 ">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>