package com.example.secondactivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends Activity {
    private static final String TAG = "Second Activity Button";

    public static final String KEY = SecondActivity.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");

        Intent intent = getIntent();
        String message = "";

        if (intent.getAction() == Intent.ACTION_VIEW) {
            Uri data = intent.getData();
            message = data.toString();
        } else {

            message = intent.getStringExtra(MainActivity.MESSAGE);
        }

        setContentView(R.layout.activity_second);

        TextView label = (TextView)findViewById(R.id.intent_message);
        label.setText(message);
        Log.i(TAG,  "Started ");
    }

    protected void onClick(View view) {
        EditText textBox = (EditText)findViewById(R.id.response);
        String message = textBox.getText().toString();

        Intent responseIntent = new Intent();
        responseIntent.putExtra(SecondActivity.KEY, message);

        setResult(Activity.RESULT_OK, responseIntent);

        //Exits out of the activity
        finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Second Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Second Activity resumed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, " Second Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, " Second Activity destroyed");
    }

}
