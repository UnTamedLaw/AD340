package com.example.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTopLeft(View view) {
        Intent intent = new Intent(this, MovieActivity.class);
        startActivity(intent);
    }

    public void onClickTopRight(View view) {
        CharSequence text ="Hello, this app has 4 buttons";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }
    public void onClickBottomLeft(View view) {
        CharSequence text ="Hello, Kevin Law wrote this app";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }
    public void onClickBottomRight(View view) {
        CharSequence text ="Hello, this app is for AD 340";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }
}
