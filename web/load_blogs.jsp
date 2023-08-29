<%-- 
    Document   : load_blogs
    Created on : 28-Aug-2023, 5:12:02 PM
    Author     : dibyajyotimishra
--%>

<%@page import="com.wave.entities.Blog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wave.helpers.ConnectionProvider"%>
<%@page import="com.wave.dao.BlogDao"%>

<div class="row">

    <%

        BlogDao blogdao = new BlogDao(ConnectionProvider.getConnection());
        ArrayList<Blog> blogs = null;
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        if (categoryId == 0) {
            blogs = blogdao.getAllBlogs();
        } else {
            blogs = blogdao.getBlogByCategory(categoryId);
        }
        
        if(blogs.size() == 0 || blogs == null) {
             out.println("<h4 class='text-center'>No blogs found for this genre!!</h4>");
             return;
        }
        for (Blog blog : blogs) {
    %>

    <div class="col-md-6 mt-2">
        <div class="card">
            <img src="blog_images/<%= blog.getBlogImage()%>" class="card-img-top" style="height: 30vh; width: 50vw;" alt="blog image">
            <div class="card-body">
                <h4><%= blog.getBlogTitle()%></h4>
                <p class="text-right">Posted On: <%= blog.getCreatedOn()%>.</p>
                <p><%= blog.getBlogContent()%></p>
            </div>
        </div>
    </div>   

    <%

        }
    %>

</div>