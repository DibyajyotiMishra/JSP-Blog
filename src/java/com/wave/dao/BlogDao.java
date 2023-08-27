/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
            while(result.next()) {
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
    
}
