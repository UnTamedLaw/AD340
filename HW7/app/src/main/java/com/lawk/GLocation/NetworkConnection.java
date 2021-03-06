package com.lawk.GLocation;

import android.net.Uri;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//public class NetworkConnection from class video
public class NetworkConnection {
    final static String TAG = "NETWORK_CONNECTION";

    public static String getData(String url) {
        try {
            return getData(new URL(url));
        } catch (MalformedURLException ex) {
            Log.e(TAG, "Malformed URI");
        }
        return null;
    }
    //Not needed for hw 6/7
//    public static String getData(String url, String... uriParams){
//        Uri.Builder builder = Uri.parse(url).buildUpon();
//
//        if ((uriParams.length % 2) != 0) {
//            Log.e(TAG, "Odd number of params");
//            return null;
//        }
//
//        for (int start = 0; start < uriParams.length; start +=2) {
//            builder.appendQueryParameter(uriParams[start], uriParams[start + 1]);
//        }
//        return getData(builder.build().toString());
//    }

    public static String getData(URL url) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String results = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            results = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return results;
    }
}
