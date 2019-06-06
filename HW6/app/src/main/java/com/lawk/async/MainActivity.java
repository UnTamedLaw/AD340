package com.lawk.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import android.support.v4.content.Loader;
import android.support.v4.app.LoaderManager;
import android.util.Log;


public class MainActivity extends AppCompatActivity
    implements LoaderManager.LoaderCallbacks<String>{
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<Camera> cameraArrayList;
    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cameraArrayList = new ArrayList<>();


        getSupportLoaderManager().restartLoader(0, null, this);

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle bundle) {
        String queryString = "";

        if (bundle != null) {
            queryString = bundle.getString("queryString");
        }
        return new CameraAsyncTaskLoader(this, queryString);
    }
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data){
        Log.i(TAG, "HAHA");
        try{
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("Features");


            for(int start = 0; start <jsonArray.length(); start++ ) {

                JSONObject object = jsonArray.getJSONObject(start);

                JSONArray cameras = object.getJSONArray("Cameras");
                JSONArray coordinates = object.getJSONArray("PointCoordinate");

                for (int start2 = 0; start2 < cameras.length(); start2++) {
                    JSONObject camera = cameras.getJSONObject(start2);
                    String cameraName = camera.getString("Description");
                    String imageURL = camera.getString("ImageUrl");
                    String type = camera.getString("Type");
                    cameraArrayList.add(new Camera(cameraName, imageURL, type));

                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        recyclerAdapter = new RecyclerAdapter(MainActivity.this, cameraArrayList);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

//    public void parseJSON(){
//        String cameraName = "camera1";
//        String imageURL = "California_SW_Hanford_NS.jpg";
//        String type = "sdot";
//        cameraArrayList.add(new Camera(cameraName, imageURL, type));
//        recyclerAdapter = new RecyclerAdapter(MainActivity.this, cameraArrayList);
//        recyclerView.setAdapter(recyclerAdapter);
//    }

}
