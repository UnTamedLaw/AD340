package com.example.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private AgeContent getAgeContent = new AgeContent();

    private static final String TAG = "Main Activity Button";
    private static final String TAG2 = "Age Activity Button";


    private static final int RECEIVE_MESSAGE_ACTIVITY_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, this.getLifecycle()
                .getCurrentState()
                .toString());    }

    public void SendMessage(View view) {
        Log.i(TAG,  "Button " + view.getId() + " clicked.");

        EditText messageSend=(EditText) findViewById(R.id.message);

        String messageString = messageSend.getText().toString();

        Intent intent = new Intent(this, ReceiveMessageActivity.class);

        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageString);
        startActivityForResult(intent, RECEIVE_MESSAGE_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == RECEIVE_MESSAGE_ACTIVITY_REQUEST_CODE  ) {
            if (resultCode == RESULT_OK) {
                String response = data.getStringExtra(ReceiveMessageActivity.KEY);

                TextView textView = (TextView)findViewById(R.id.responseText);
                textView.setText(response);
            }
        }
    }

    public void onClickSelectAge(View view) {
        Log.i(TAG2,  "Button " + view.getId() + " clicked.");

        TextView ages = (TextView) findViewById(R.id.ageText);


        Spinner listAges = (Spinner) findViewById(R.id.ageSpinner);

        String ageRange = String.valueOf(listAges.getSelectedItem());

        List<String> contentList = getAgeContent.getContent(ageRange);
        StringBuilder contentAdded = new StringBuilder();
        for (String content: contentList) {
            contentAdded.append(content).append('\n');
        }

        ages.setText(contentAdded);

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
