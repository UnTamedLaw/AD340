package com.lawk.async;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

//taken from google-developer-training + class video
public class CameraAsyncTaskLoader extends AsyncTaskLoader<String> {

    private String mQueryString;

    public CameraAsyncTaskLoader (Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }


    @Nullable
    @Override
    public String loadInBackground() {
        String cameraURL = "https://web6.seattle.gov/Travelers/api/Map/Data?zoomId=13&type=2";

        return NetworkConnection.getData(cameraURL);
    }
}
