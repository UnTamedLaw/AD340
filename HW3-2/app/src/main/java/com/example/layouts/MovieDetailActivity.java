package com.example.layouts;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class MovieDetailActivity extends AppCompatActivity {

    public static final String MOVIE_ID = "movieID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        int movieID = (Integer)getIntent().getExtras().get(MOVIE_ID);
        String movieName = Movie.movie[movieID].getTitle();
        TextView titleView = (TextView)findViewById(R.id.title);
        titleView.setText("Title: " + movieName);

        String year = String.valueOf(Movie.movie[movieID].getYear());
        TextView yearView = (TextView)findViewById(R.id.year);
        yearView.setText("Year: " + year);

        String director = String.valueOf(Movie.movie[movieID].getDirector());
        TextView directorView = (TextView)findViewById(R.id.director);
        directorView.setText("Director: " + director);

        String description = String.valueOf(Movie.movie[movieID].getDescription());
        TextView descriptionView = (TextView)findViewById(R.id.description);
        descriptionView.setText("Description: " + description);

    }

}
