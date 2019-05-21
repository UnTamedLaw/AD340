package com.example.layouts;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ZombieMovieAdapter extends RecyclerView.Adapter<ZombieMovieAdapter.ViewHolder> {
    private String[] title;
    private int[] imageIds;

    public ZombieMovieAdapter(String[] text, int[] imageIds){
        this.title = title;
        this.imageIds = imageIds;
    }

    @Override
    public int getItemCount() {
        return title.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cView) {
            super(cView);
            cardView = cView;
        }
    }

    @Override
    public ZombieMovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.movie, parent, false);
        return new ViewHolder(cv);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageview = (ImageView)cardView.findViewById(R.id.img);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageview.setImageDrawable(drawable);
        imageview.setContentDescription(title[position]);
    }
}
