<jsp:include page="../layouts/header.jsp"></jsp:include>

<%@ page import="java.util.StringTokenizer" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.util.List"%>
<%@ page import="models.Post"%>
<%@ page import="dao.PostRepository"%>
<%@ page import="common.DbConnection"%>
<%@ page import="java.util.ArrayList"%>
	<div class="relative mt-4">
		<a href="<%=request.getContextPath() + "/PostServlet?action=create"%>" class="inline-flex items-center px-8 py-2 text-center text-white bg-purple-300 rounded-lg hover:bg-purple-800 focus:ring-4 focus:outline-none focus:ring-blue-300 absolute right-32">Create</a>
	</div>

	<%! 
	    String limitWords(String input, int limit) {
	        StringTokenizer tokenizer = new StringTokenizer(input);
	        List<String> words = new ArrayList<>();
	        while (tokenizer.hasMoreTokens() && words.size() < limit) {
	            words.add(tokenizer.nextToken());
	        }
	        return String.join(" ", words);
	    }
	%>	 <ul class="clearfix py-8 pl-12">
	 	<% 
        List<Post> postList = PostRepository.getAllPosts();

        for (Post post : postList) {
    	%>
                <li class="w-80 ml-7 mt-11 py-5 float-left border px-8 border-purple-100">
                    <img src="<%=request.getContextPath()%>/assets/img/default.jpg" alt="" width="300" height="200">
                    <p class="text-center mt-2 font-bold"><%= post.getBook_name() %></p>
                    <p class="text-center  mt-2 font-bold"><%= post.getAuthor() %></p>
                    <p class="text-center"><%= post.getPrice() %></p>
                    <p class=" mt-2">
                      <% 
					    String fullText =  post.getDescription();
					
					    // Limit the number of words to display
					    int wordLimit = 10;
					    String limitedText = limitWords(fullText, wordLimit);
					%>
                    <%= limitedText %> ...</p>
                    
                    <a href="<%=request.getContextPath() + "/PostServlet?action=detail&id="+ post.getId() %>" class="mt-4 ml-32 inline-flex items-center px-3 py-2 text-sm font-medium text-center text-white bg-purple-300 rounded-lg hover:bg-purple-800 focus:ring-4 focus:outline-none focus:ring-blue-300">
			            Read more
			             <svg class="rtl:rotate-180 w-3.5 h-3.5 ms-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
			                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
			            </svg>
			       </a>
                </li>
          <%} %>
      </ul>
<jsp:include page="../layouts/footer.jsp"></jsp:include>