package com.lawk.GLocation;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Camera> cameraList;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }


    public RecyclerAdapter(Context context, ArrayList<Camera> cameraList) {
        this.context = context;
        this.cameraList = cameraList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView)LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int position) {

        CardView cardView = viewHolder.cardView;
        ImageView imageView = cardView.findViewById(R.id.image_view);
        TextView textView = cardView.findViewById(R.id.camera_name);
        Camera currentCamera = cameraList.get(position);
        String imageUrl = currentCamera.getImageURL();
        String cameraName = currentCamera.getCameraName();
        String type = currentCamera.getType();
        textView.setText(cameraName);

        String url;

        if (type.equals("sdot")) {
            url = "https://www.seattle.gov/trafficcams/images/" + imageUrl;

        } else {
            url = "https://www.images.wsdot.wa.gov/nw/" + imageUrl;
        }

        Picasso.get().load(url).fit().centerCrop().into(imageView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cameraList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;


        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;

        }
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}


