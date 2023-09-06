package com.wave.entities;

/**
 *
 * @author dibyajyotimishra
 */
public class Like {
    private int id;
    private int count;
    private int blogId;

    public Like() {
    }

    public Like(int id, int count, int blogId) {
        this.id = id;
        this.count = count;
        this.blogId = blogId;
    }
    
    public Like( int count, int blogId) {
        this.count = count;
        this.blogId = blogId;
    }

    public int getId() {
        return id;
    }
    

    public int getBlogId() {
        return blogId;
    }

    public int getCount() {
        return count;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
