<jsp:include page="../layouts/header.jsp"></jsp:include>
<%@ page import="models.Post"%>
<%@ page import="dao.PostRepository"%>
<%
	int postId = 0;
	String postIdParam = request.getParameter("id");
	if (postIdParam != null && !postIdParam.isEmpty()) {
		postId = Integer.parseInt(postIdParam);
	}
	Post post = PostRepository.getPostById(postId);
%>
<div class="w-1/2 px-16 py-5 bg-white border border-gray-200 rounded-lg shadow mx-auto my-32">

	<div onclick="toggleDropdown()" class="relative">
		<button id="dropdownButton"
			class="absolute right-0 text-gray-500 hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg text-sm p-1.5"
			type="button">
			<span class="sr-only">Open dropdown</span>
			<svg class="w-5 h-5" aria-hidden="true"
				xmlns="http://www.w3.org/2000/svg" fill="currentColor"
				viewBox="0 0 16 3">
	                <path
					d="M2 0a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3Zm6.041 0a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3ZM14 0a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3Z" />
	            </svg>
		</button>
	</div>
	<div class="relative">
		<div id="dropdown"
			class="mt-8 absolute right-0 text-base list-none bg-white divide-y divide-gray-100 rounded-lg shadow w-44 hidden">
			<ul class="py-2">
				<li><a href="PostServlet?action=edit&id=<%= post.getId() %>"
					class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">Edit</a>
				</li>
				<li>
					<form action="PostServlet?action=delete&id=<%= post.getId() %>"
						method="post">
						<input type="submit" value="Delete"
							class="block px-4 py-2 text-sm text-red-600 hover:bg-gray-100">
					</form>
				</li>
			</ul>
		</div>
	</div>

	<div class="flex flex-col items-center pb-10 mt-8">
		<img
			class="w-40 h-40 mb-3 rounded-full shadow-lg transition ease-in-out delay-150 hover:-translate-y-1 hover:scale-150 hover:bg-indigo-500 duration-300 mb-8"
			src="assets/img/default.jpg" alt="" />
		<h3 class="mb-1 text-xl font-medium text-gray-900"><%= post.getBook_name() %></h3>
		<h6 class="text-sm text-gray-500"><%= post.getAuthor()%></h6>
		<p class="text-sm text-gray-500"><%= post.getPrice()%></p>
		<div class="mx-auto">
			<p class="text-sm text-gray-500"><%= post.getDescription()%></p>
		</div>
		
	</div>
</div>
<jsp:include page="../layouts/footer.jsp"></jsp:include>
<script>
    // Function to toggle the dropdown visibility
    function toggleDropdown() {
        var dropdown = document.getElementById("dropdown");
		dropdown.classList.toggle("hidden");
    }
</script>