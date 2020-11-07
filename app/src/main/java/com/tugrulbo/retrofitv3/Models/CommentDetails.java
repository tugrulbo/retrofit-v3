package com.tugrulbo.retrofitv3.Models;

public class CommentDetails {

    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;


    public CommentDetails(Integer postId, Integer id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
