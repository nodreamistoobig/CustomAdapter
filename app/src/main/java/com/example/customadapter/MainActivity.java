package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    UserListAdapter adapter;
    ListView listView;
    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        User[] usersData = new User[0];

        InputStream input = null;
        try {
            input = getAssets().open("userList.json");
            Reader reader = new InputStreamReader(input, "UTF-8");
            Gson gson = new Gson();
            usersData = gson.fromJson(reader, User[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        users.addAll(Arrays.asList(usersData));

        adapter = new UserListAdapter(this, users);
        listView.setAdapter(adapter);
    }

    public void onSortName(View v){
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.name.compareTo(u2.name);
            }
        };;
        Collections.sort(users, comparator);
        adapter.notifyDataSetChanged();
    }

    public void onSortPhone(View v){
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.phone.compareTo(u2.phone);
            }
        };;
        Collections.sort(users, comparator);
        adapter.notifyDataSetChanged();
    }

    public void onSortGender(View v){
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.gender.compareTo(u2.gender);
            }
        };;
        Collections.sort(users, comparator);
        adapter.notifyDataSetChanged();
    }
}