package com.tugrulbo.retrofitv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.tugrulbo.retrofitv3.Adapters.CustomAdapter;
import com.tugrulbo.retrofitv3.Models.Comments;
import com.tugrulbo.retrofitv3.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    List<Comments> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        request();
    }

    public void initialize(){
        mListView =(ListView) findViewById(R.id.listView);
    }

    public void request(){
        mList = new ArrayList<>();
        Call<List<Comments>> call = ManagerAll.getInstance().getAllInfo();
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if(response.isSuccessful()){
                    mList = response.body();
                    CustomAdapter customAdapter = new CustomAdapter(mList, getApplicationContext(),MainActivity.this);
                    mListView.setAdapter(customAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}