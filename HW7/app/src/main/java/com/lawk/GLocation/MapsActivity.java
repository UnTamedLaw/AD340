package com.lawk.GLocation;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.maps.OnMapReadyCallback;

//Followed the in class notes and video to produce the following code!

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "GET_LOCATION_ACTIVITY";
    public static final String POSITION_ID = "positionID";
    private FusedLocationProviderClient mapsLocationClient;
    private boolean mapsLocationPermissionGranted = false;
    private GoogleMap gMap;
    private double x;
    private double y;
    private String name;
    private String url;
    private String type;
    private String imageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapsLocationClient = LocationServices.getFusedLocationProviderClient(this);

        //get access to map as a fragment.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //We want access to the map thats inside the fragment
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.x = bundle.getDouble("X");
        this.y = bundle.getDouble("Y");
        this.name = bundle.getString("Name");


    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        if (mapsLocationPermissionGranted) {
            Task location = mapsLocationClient.getLastLocation();
            location.addOnCompleteListener(new OnCompleteListener<Location>() {

                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location currentLocation = task.getResult();
                    if (currentLocation != null) {
                        String latLong = String.format("Lat: %f, Long: %f",
                                currentLocation.getLatitude(),
                                currentLocation.getLongitude());

                        gMap.setMyLocationEnabled(true);
                        gMap.getUiSettings().setMyLocationButtonEnabled(true);

                        //Update the map
                        LatLng marker = new LatLng(currentLocation.getLatitude(),
                                currentLocation.getLongitude());

                        gMap.addMarker(new MarkerOptions().position(marker).title("Current Location"));

                        LatLng cameraLocation = new LatLng(x,y);
                        gMap.addMarker(new MarkerOptions().position(cameraLocation)
                                .title("Camera Location: " + name));

                        gMap.moveCamera(CameraUpdateFactory.newLatLng(cameraLocation));
                        gMap.animateCamera(CameraUpdateFactory.zoomTo(6));


                    } else {
                        Log.e(TAG, "Location is null...");
                    }
                }
            });
        }
    }
    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mapsLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{ Manifest.permission.ACCESS_COARSE_LOCATION },
                    1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        mapsLocationPermissionGranted = false;
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mapsLocationPermissionGranted = true;
                    getLocation();

                }
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        getLocationPermission();
        getLocation();

    }
}

