package com.example.customadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter {
    Context ctx; ArrayList<User> users;

    public UserListAdapter(Context ctx, ArrayList<User> users) {
        this.ctx = ctx;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = users.get(position);

        convertView = LayoutInflater.from(ctx).inflate(R.layout.useritem, parent, false);

        TextView tvName = convertView.findViewById(R.id.name);
        TextView tvPhone = convertView.findViewById(R.id.phone);
        tvName.setText(user.name);
        tvPhone.setText(user.phone);

        ImageView userPic = convertView.findViewById(R.id.userpic);
        switch (user.gender) {
            case MAN: userPic.setImageResource(R.drawable.user_man); break;
            case WOMAN: userPic.setImageResource(R.drawable.user_woman); break;
            case UNKNOWN: userPic.setImageResource(R.drawable.user_unknown); break;
        }

        userPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.RED);
            }
        });

        return convertView;
    }
}
