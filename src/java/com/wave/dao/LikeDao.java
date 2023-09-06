package com.wave.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dibyajyotimishra
 */
public class LikeDao {
    private Connection connection;

    public LikeDao(Connection connection) {
        this.connection = connection;
    }
    
    public boolean createLikes(int blogId) {
        boolean isSuccessful = false;
        try {
            String query = "insert into likes(count, blogId) values(?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, 0);
            statement.setInt(2, blogId);
            statement.executeUpdate();
            isSuccessful = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }
    
    public int getAllLikes(int blogId) {
        int count = 0;
        try {
            String query = "select * from likes where blogId=?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, blogId);
             ResultSet result = statement.executeQuery();
             
             if(result.next()) {
                 count = result.getInt("count");
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public int setLikes(int blogId) {
        int totalLikes = 0;
        try {
            int count = getAllLikes(blogId);
            String query = "update likes set count=? where blogId=?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, count+1);
            statement.setInt(2, blogId);
            statement.executeUpdate();
            totalLikes = count + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalLikes;
    } 
}
