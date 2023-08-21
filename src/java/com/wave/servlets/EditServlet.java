/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.wave.servlets;

import com.wave.dao.UserDao;
import com.wave.entities.Message;
import com.wave.entities.User;
import com.wave.helpers.ConnectionProvider;
import com.wave.helpers.FileHandler;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author dibyajyotimishra
 */
@MultipartConfig
public class EditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String password = request.getParameter("password");
            Part image = request.getPart("profilePicture");
            String profilePicture = "";
            if (image.getSize() != 0) {
                profilePicture = image.getSubmittedFileName();
            }

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("currentUser");
            if (firstName != null && firstName.length() > 0) {
                user.setFirstName(firstName);
            }
            if (lastName != null && lastName.length() > 0) {
                user.setLastName(lastName);
            }
            if (password != null && password.length() > 0) {
                user.setPassword(password);
            }
            if ((profilePicture != null && profilePicture != "") && image.getSize() != 0) {
                user.setProfilePicture(profilePicture);
            }

            UserDao userDao = new UserDao(ConnectionProvider.getConnection());
            boolean isUpdateSuccessful = userDao.updateUserData(user);

            if (isUpdateSuccessful) {
                String path = request.getRealPath("/") + "images" + File.separator + user.getProfilePicture();
//                if(FileHandler.deleteFile(path)) {
                if (FileHandler.saveFile(image.getInputStream(), path)) {
//                        out.println("Success");
                    Message message = new Message("Yay!", "Profile Updated", "success", "alert-success");
                    session.setAttribute("message", message);

                }
//                }
            } else {
//                out.println("Fail");
                Message message = new Message("Holy guacamole!", "Update process failed.", "error", "alert-danger");      
                session.setAttribute("message", message);
            }
            response.sendRedirect("profile.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
