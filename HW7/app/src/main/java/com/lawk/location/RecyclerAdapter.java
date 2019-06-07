package com.lawk.location;

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
        View v = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int position) {
        Camera currentCamera = cameraList.get(position);
        String imageUrl = currentCamera.getImageURL();
        String cameraName = currentCamera.getCameraName();
        String type = currentCamera.getType();
        String url;
        viewHolder.textView.setText(cameraName);

        if (type.equals("sdot")) {
            url = "https://www.seattle.gov/trafficcams/images/" + imageUrl;

        } else {
            url = "https://www.images.wsdot.wa.gov/nw/" + imageUrl;
        }

        Picasso.get().load(url).fit().centerCrop().into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return cameraList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.camera_name);
        }
    }
    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
