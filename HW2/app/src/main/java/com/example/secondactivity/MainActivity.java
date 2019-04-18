package com.example.secondactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity Button";
    private static final int RESULT_ID = 1;

    public static final String MESSAGE = "Question";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, this.getLifecycle()
                .getCurrentState()
                .toString());
    }

    protected void onClick(View button) {
        Log.i(TAG,  "Button " + button.getId() + " clicked.");

        EditText textbox = (EditText)findViewById(R.id.messybox);
        String message = textbox.getText().toString();

        if (message.contains("https:")) {
            Intent browseIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(message));
            startActivity(browseIntent);
        }else {
            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra(MESSAGE, message);

            startActivityForResult(intent, RESULT_ID); ;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_ID) {
            if (resultCode == RESULT_OK) {
                TextView label = (TextView)findViewById(R.id.message);
                String message = label.getText().toString();
                message += "\n\n" + data.getStringExtra(SecondActivity.KEY);
                label.setText(message);
            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Main Activity started");
        Log.i(TAG, this.getLifecycle().getCurrentState().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Main Activity resumed");
        Log.i(TAG, this.getLifecycle().getCurrentState().toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, " Main Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, " Main Activity destroyed");
    }

}
