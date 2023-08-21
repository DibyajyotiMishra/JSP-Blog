package com.wave.entities;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author dibyajyotimishra
 */
public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePicture;
    private String registeredMonth;

    LocalDate date = LocalDate.now();
    Month month = date.getMonth();
    int year = date.getYear();

    public User(int userId, String firstName, String lastName, String email, String password, String profilePicture) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.registeredMonth = "Member since " + month.toString() + "," + year;
    }

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profilePicture= "default.png";
        this.registeredMonth = "Member since " + month.toString() + "," + year;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getRegisteredMonth() {
        return registeredMonth;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setRegisteredMonth(String regsiteredMonth) {
        this.registeredMonth = regsiteredMonth;
    }

}
