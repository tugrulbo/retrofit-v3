package com.tugrulbo.retrofitv3.RestApi;


import com.tugrulbo.retrofitv3.Models.CommentDetails;
import com.tugrulbo.retrofitv3.Models.Comments;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<List<Comments>> getAllInfo(){
        Call<List<Comments>> call = getRestApiClient().getComments();
        return call;
    }

    public Call<List<CommentDetails>> getCommentDetailInfo(String postId,String id){
        Call<List<CommentDetails>> call = getRestApiClient().getCommentDetails(postId,id);
        return call;
    }


}
