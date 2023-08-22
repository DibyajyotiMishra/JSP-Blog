package com.wave.entities;

/**
 *
 * @author dibyajyotimishra
 */
public class Blog {
    private int blogId;
    private String blogTitle;
    private String blogContent;
    private String blogImage;
    private int categoryId;
    private int authorId;
    private String createdOn;

    public Blog() {
    }

    public Blog(int blogId, String blogTitle, String blogContent, String blogImage, int categoryId, int authorId, String createdOn) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.blogImage = blogImage;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.createdOn = createdOn;
    }
    
    
    public Blog(String blogTitle, String blogContent, String blogImage, int categoryId, int authorId, String createdOn) {
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.blogImage = blogImage;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.createdOn = createdOn;
    }

    public int getBlogId() {
        return blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
