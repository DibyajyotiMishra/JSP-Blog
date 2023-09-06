<%-- 
    Document   : load_blogs
    Created on : 28-Aug-2023, 5:12:02 PM
    Author     : dibyajyotimishra
--%>

<%@page import="com.wave.dao.LikeDao"%>
<%@page import="com.wave.entities.Blog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wave.helpers.ConnectionProvider"%>
<%@page import="com.wave.dao.BlogDao"%>

<div class="container-fluid content-row">
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

            if (blogs.size() == 0 || blogs == null) {
                out.println("<h4 class='text-center'>No blogs found for this genre!!</h4>");
                return;
            }
            for (Blog blog : blogs) {
        %>

        <div class="col-sm-12 col-lg-6 col-md-6 mt-2 mb-2">
            <div class="card h-100">
                <img src="blog_images/<%= blog.getBlogImage()%>" class="card-img-top"  alt="blog image">
                <div class="card-body">
                    <h4><%= blog.getBlogTitle()%></h4>
                    <p class="text-right">Posted On: <%= blog.getCreatedOn()%>.</p>
                    <p style="
                       display:block;
                       white-space: nowrap;
                       overflow: hidden;
                       text-overflow: ellipsis;
                       max-width: 25ch;"><%= blog.getBlogContent()%></p>
                </div>
                <div class="card-footer">
                    <% 
                                LikeDao likeDao = new LikeDao(ConnectionProvider.getConnection());
                                int likes = likeDao.getAllLikes(blog.getBlogId());
                            %>
                            
                    <a href="show_blog_page.jsp?blog_id=<%= blog.getBlogId() %>" class="btn btn-outline-primary btn-sm">Read more...</a>
                    <a href="#!" onclick="updateLikes(<%= blog.getBlogId() %>)" class="btn btn-outline-primary btn-sm"><i class="fa fa-thumbs-o-up">&nbsp;<span class="like-counter"><%= likes %></span></i></a>
                    <a href="#!" class="btn btn-outline-primary btn-sm"><i class="fa fa-commenting-o">&nbsp;<span>20</span></i></a>
                </div>
            </div>
        </div>   

        <%

            }
        %>

    </div>
</div>