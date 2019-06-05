package com.example.layouts;

public class Movie {
    private String title;
    private int imageId;


    public static final Movie[] movie = {
            new Movie("Night Of the Comet", R.drawable.night_of_comet),
            new Movie("Dead Snow", R.drawable.dead_snow),
            new Movie("Cemetery Man", R.drawable.cemetary_man),
            new Movie("28 Weeks Later", R.drawable.weeks_later),
            new Movie("Night of the Creeps", R.drawable.night_of_the_creeps),
            new Movie("ParaNorman", R.drawable.paranorman_movie_image),
            new Movie("ZombieLand", R.drawable.zombieland),
            new Movie("Planet Terror", R.drawable.planet_terror_),
            new Movie("Train to Busan", R.drawable.train_to_busan_movie_image)

    };
    private Movie(String name, int imageId){
        this.title =  name;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }
}
