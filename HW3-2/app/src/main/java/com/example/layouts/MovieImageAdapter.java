package com.example.layouts;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class MovieImageAdapter extends RecyclerView.Adapter<MovieImageAdapter.ViewHolder> {
    private String[] title;
    private int[] imageIds;
    private int[] year;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public MovieImageAdapter(String[] text, int[] imageIds, int[] years) {
        this.title = text;
        this.imageIds = imageIds;
        this.year = years;
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView view) {
            super(view);
            cardView = view;
        }
    }
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public MovieImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_cardview, parent, false);
        return new ViewHolder(cv);

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.img);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);

        imageView.setContentDescription(title[position]);

        TextView textView = (TextView)cardView.findViewById(R.id.text);
        textView.setText(title[position] + " " + year[position]);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}
