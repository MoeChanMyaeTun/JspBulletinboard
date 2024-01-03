<jsp:include page="../layouts/header.jsp"></jsp:include>
<section class="bg-purple-100">
		<div
			class="flex flex-col items-center justify-center px-6 mx-auto md:h-screen lg:py-0">
			<div
				class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0">
				<div class="p-6 sm:p-8">
					<h1
						class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl text-center">
						Post Create</h1>
					<form class="space-y-4 md:space-y-6" action="<%=request.getContextPath() + "/PostServlet?action=insert"%>" method="post">
						<div>
							<label for="book_name" class="block text-sm font-medium">Book Name</label> 
							<input type="text" name="book_name" id="name"
								class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
								placeholder="Enter book name" required="">
						</div>
						<div>
							<label for="author" class="block text-sm font-medium">
								Author</label> <input type="text" name="author" id="author"
								class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
								placeholder="Enter author" required="">
						</div>
						<div>
							<label for="price"
								class="block text-sm font-medium text-gray-900">Price</label>
							<input type="text" name="price" id="price"
								class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
								placeholder="Enter price" required="">
						</div>
						<div>
							<label for="description"
								class="block text-sm font-medium text-gray-900">Description</label>
							<input type="text" name="description" id="description"
								class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
								placeholder="Enter description" required="">
						</div>
						<button type="submit"
							class="w-full bg-purple-500 py-2 rounded-lg text-white">Create
							post</button>
					</form>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="../layouts/footer.jsp"></jsp:include>