package com.tugrulbo.retrofitv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.tugrulbo.retrofitv3.Models.CommentDetails;
import com.tugrulbo.retrofitv3.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDetails extends AppCompatActivity {

    public String postId;
    public String id;
    List<CommentDetails> mCommentDetails;

    TextView t_postId;
    TextView t_id;
    TextView t_name;
    TextView t_email;
    TextView t_body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        initialize();
        getPostIDId();
        request();
    }

    public void initialize(){
        t_postId = (TextView)findViewById(R.id.postID);
        t_id =(TextView)findViewById(R.id.id);
        t_name =(TextView)findViewById(R.id.name);
        t_email =(TextView)findViewById(R.id.email);
        t_body =(TextView)findViewById(R.id.body);
    }

    public void getPostIDId(){
        Bundle bundle = getIntent().getExtras();
        postId = bundle.getString("postId");
        id = bundle.getString("Id");
    }


    public void request(){
        mCommentDetails = new ArrayList<>();
        Call<List<CommentDetails>> call = ManagerAll.getInstance().getCommentDetailInfo(postId,id);
        call.enqueue(new Callback<List<CommentDetails>>() {
            @Override
            public void onResponse(Call<List<CommentDetails>> call, Response<List<CommentDetails>> response) {
                if(response.isSuccessful()){
                    mCommentDetails = response.body();
                    getPostIDId();
                    setText(mCommentDetails);
                }
            }

            @Override
            public void onFailure(Call<List<CommentDetails>> call, Throwable t) {

            }
        });
    }
    public void setText(List<CommentDetails> list){
        t_postId.setText("Post id: "+list.get(0).getPostId());
        t_id.setText("id: "+list.get(0).getId());
        t_name.setText(list.get(0).getName());
        t_email.setText(list.get(0).getEmail());
        t_body.setText(list.get(0).getBody());
    }
}