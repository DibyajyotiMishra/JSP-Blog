package com.wave.dao;

import com.wave.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dibyajyotimishra
 */
public class UserDao {

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }
    
    
    // Save user data.
    public boolean saveUserData(User user) {
        boolean isSuccessful = false;
        try { 
            String query = "insert into users(firstName, lastName, email, password) values(?, ?, ?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());

            statement.executeUpdate();

            isSuccessful = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccessful;
    }
    
    
    // Get an user
    public User getUserByEmailAndPassword(String email, String password) {
        User user = null;
        
        try {
            String query = "select * from users where email=? and password=?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            
            if(result.next()) {
                user = new User();
                String userFirstName = result.getString("firstName");
                String userLastName = result.getString("lastName");
                String userEmail = email;
                String userImage = result.getString("profilePicture");
                
                user.setFirstName(userFirstName);
                user.setLastName(userLastName);
                user.setEmail(userEmail);
                user.setProfilePicture(userImage);
                
                
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
}
