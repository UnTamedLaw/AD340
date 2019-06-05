package com.example.layouts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

public class ViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView movieRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_view, container, false);

        String[] movieTitles = new String[Movie.movie.length];
        for (int titles = 0; titles < movieTitles.length; titles++){
            movieTitles[titles]  = Movie.movie[titles].getTitle();
        }

        int[] movieImages = new int[Movie.movie.length];
        for (int imageId = 0; imageId < movieImages.length; imageId++) {
            movieImages[imageId] = Movie.movie[imageId].getImageId();
        };

        MovieImageAdapter adapter = new MovieImageAdapter(movieTitles, movieImages);

        movieRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        movieRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new MovieImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.MOVIE_ID, position);
                getActivity().startActivity(intent);
            }
        });


        return movieRecycler;
    }
}
