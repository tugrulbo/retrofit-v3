package com.tugrulbo.retrofitv3.RestApi;

import com.tugrulbo.retrofitv3.Models.CommentDetails;
import com.tugrulbo.retrofitv3.Models.Comments;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/comments")
    Call<List<Comments>> getComments();

    @GET("/comments") Call<List<CommentDetails>> getCommentDetails(@Query("postId") String postId,@Query("id") String id);
}
