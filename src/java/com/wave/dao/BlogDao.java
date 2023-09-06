package com.wave.dao;

import com.wave.entities.Blog;
import com.wave.entities.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dibyajyotimishra
 */
public class BlogDao {

    Connection connection;

    public BlogDao(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();

        try {
            String query = "select * from categories";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String descrption = result.getString("description");
                Category category = new Category(id, name, descrption);
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    public boolean saveBlog(Blog blog) {
        boolean isSuccess = false;

        try {
            String query = "insert into blogs(title, content, image, categoryId, author, createdOn) values(?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, blog.getBlogTitle());
            statement.setString(2, blog.getBlogContent());
            statement.setString(3, blog.getBlogImage());
            statement.setInt(4, blog.getCategoryId());
            statement.setInt(5, blog.getAuthorId());
            statement.setString(6, blog.getCreatedOn());

            statement.executeUpdate();
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public ArrayList<Blog> getAllBlogs() {
        ArrayList<Blog> blogs = new ArrayList<>();

        try {
            String query = "select * from blogs order by id desc";
            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while(result.next()) {
                int blogId = result.getInt("id");
                String blogTitle = result.getString("title");
                String blogContent = result.getString("content");
                String blogImage = result.getString("image");
                int categoryId = result.getInt("categoryId");
                int authorId = result.getInt("author");
                String createdOn = result.getString("createdOn");
                Blog blog = new Blog(blogId, blogTitle, blogContent, blogImage, categoryId, authorId);
                blogs.add(blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return blogs;
    }

    public ArrayList<Blog> getBlogByCategory(int categoryId) {
        ArrayList<Blog> blogs = new ArrayList<>();

        try {
            String query = "select * from blogs where categoryId = ?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, categoryId);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int blogId = result.getInt("id");
                String blogTitle = result.getString("title");
                String blogContent = result.getString("content");
                String blogImage = result.getString("image");
                int authorId = result.getInt("author");
                String createdOn = result.getString("createdOn");
                Blog blog = new Blog(blogId, blogTitle, blogContent, blogImage, categoryId, authorId);
                blogs.add(blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return blogs;
    }
    
    
    public Blog getBlogById(int id) {
        Blog blog = null;
        try {
            String query = "select * from blogs where id = ?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, id );
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int blogId = result.getInt("id");
                String blogTitle = result.getString("title");
                String blogContent = result.getString("content");
                String blogImage = result.getString("image");
                int authorId = result.getInt("author");
                String createdOn = result.getString("createdOn");
                int categoryId = result.getInt("categoryId");
                blog = new Blog(blogId, blogTitle, blogContent, blogImage, categoryId, authorId);
                return blog;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return blog;
    }
}
