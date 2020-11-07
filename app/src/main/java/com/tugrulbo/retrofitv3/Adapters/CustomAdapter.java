package com.tugrulbo.retrofitv3.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tugrulbo.retrofitv3.ItemDetails;
import com.tugrulbo.retrofitv3.Models.Comments;
import com.tugrulbo.retrofitv3.R;

import java.util.List;


public class CustomAdapter extends BaseAdapter {

    private List<Comments> mList;
    private Context context;
    private Activity activity;
    public CustomAdapter(List<Comments> mList, Context context, Activity activity) {
        this.mList = mList;
        this.context = context;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.list_items,parent,false);

        LinearLayout layoutList;
        layoutList = convertView.findViewById(R.id.main);
        TextView postId = convertView.findViewById(R.id.postID);
        TextView id = convertView.findViewById(R.id.id);
        TextView name = convertView.findViewById(R.id.name);
        TextView email = convertView.findViewById(R.id.email);
        TextView body = convertView.findViewById(R.id.body);

        postId.setText("Post ID: "+mList.get(position).getPostId());
        id.setText("ID: "+mList.get(position).getId());
        name.setText(mList.get(position).getName());
        email.setText(mList.get(position).getEmail());
        body.setText(mList.get(position).getBody());
        final String  _postID = mList.get(position).getPostId().toString();
        final String  _id = mList.get(position).getId().toString();

        layoutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ItemDetails.class);
                intent.putExtra("postId",_postID);
                intent.putExtra("Id",_id);
                activity.startActivity(intent);
            }
        });
        return convertView;
    }
}
