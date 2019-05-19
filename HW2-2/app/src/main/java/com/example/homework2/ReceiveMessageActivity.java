package com.example.homework2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class ReceiveMessageActivity extends Activity {

    public static final String EXTRA_MESSAGE = "message";
    public static final String KEY = ReceiveMessageActivity.class.toString();

    private static final String TAG = "Second Activity Button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        String messageSend = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageString = (TextView) findViewById(R.id.message);
        messageString.setText(messageSend);
        Log.i(TAG,  "Started ");

    }

    protected void onClickRespond(View view) {
        Log.i(TAG,  "Button " + view.getId() + " clicked.");

        EditText textBox = (EditText)findViewById(R.id.response);
        String message = textBox.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(ReceiveMessageActivity.KEY, message );
        setResult(Activity.RESULT_OK, intent);

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
