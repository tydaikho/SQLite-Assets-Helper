package com.gazman.assetsdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gazman.db.callbacks.MainThreadCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.textBox);

        UsersDataBase usersDataBase = new UsersDataBase(this);
        usersDataBase.getUsers1(new MainThreadCallback<ArrayList<UserData>>() {
            @Override
            protected void onResponse(ArrayList<UserData> responseData) {
                textView.setText(responseData.toString());
            }
        });
    }
}
