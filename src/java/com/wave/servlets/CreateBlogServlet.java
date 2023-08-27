package com.wave.servlets;

import com.wave.dao.BlogDao;
import com.wave.entities.Blog;
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
public class CreateBlogServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            String blogTitle = request.getParameter("blogTitle");
            String blogContent = request.getParameter("blogContent");
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            Part file = request.getPart("blogImage");
            String blogImage = file.getSubmittedFileName();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("currentUser");
            int authorId = user.getUserId();
            
            Blog blog = new Blog(blogTitle, blogContent, blogImage, categoryId, authorId);
            BlogDao blogDao = new BlogDao(ConnectionProvider.getConnection());
            if(blogDao.saveBlog(blog)) {
                String path = request.getServletContext().getRealPath("/") + "blog_images" + File.separator + blogImage;
                FileHandler.saveFile(file.getInputStream(), path);
                out.println("success");
            } else {
                out.println("fail");
            }
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
