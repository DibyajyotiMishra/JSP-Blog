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
            String query = "insert into users(firstName, lastName, email, password, registeredMonth, profilePicture) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRegisteredMonth());
            statement.setString(6, user.getProfilePicture());

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
                String userRegistrationMonth = result.getString("registeredMonth");
                int userId = result.getInt("id");
                String userPassword = result.getString("password");
                
                user.setFirstName(userFirstName);
                user.setLastName(userLastName);
                user.setEmail(userEmail);
                user.setProfilePicture(userImage);
                user.setRegisteredMonth(userRegistrationMonth);
                user.setUserId(userId);
                user.setPassword(userPassword);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public User getUserById(int userId) {
        User user = null;
        
        try {
            String query = "select * from users where id=?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();
            
            if(result.next()) {
                user = new User();
                String userFirstName = result.getString("firstName");
                String userLastName = result.getString("lastName");
                String userEmail = result.getString("email");
                String userImage = result.getString("profilePicture");
                String userRegistrationMonth = result.getString("registeredMonth");
                String userPassword = result.getString("password");
                
                user.setFirstName(userFirstName);
                user.setLastName(userLastName);
                user.setEmail(userEmail);
                user.setProfilePicture(userImage);
                user.setRegisteredMonth(userRegistrationMonth);
                user.setUserId(userId);
                user.setPassword(userPassword);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public boolean updateUserData(User user) {
        boolean isSuccessful = false;
        try {
           String query = "update users set firstName=?, lastName=?, password=?, profilePicture=? where id=?";
           PreparedStatement statement = this.connection.prepareStatement(query);
           statement.setString(1, user.getFirstName());
           statement.setString(2, user.getLastName());
           statement.setString(3, user.getPassword());
           statement.setString(4, user.getProfilePicture());
           statement.setInt(5, user.getUserId());
           
           statement.executeUpdate();
           isSuccessful = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccessful;
    }
}
