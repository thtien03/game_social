package com.example.nhom06_socialgamenetwork.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom06_socialgamenetwork.R;
import com.example.nhom06_socialgamenetwork.models.Discuss;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterDiscuss extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Discuss> list;
    public AdapterDiscuss(List<Discuss> list){
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_topic_discuss_no_img, parent, false);
            return new HolderNotImage(v);
        }else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_topic_discuss, parent, false);
            return new HolderImage(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Discuss discuss = list.get(position);
        if (discuss.getIdPic() == null){
            HolderNotImage holderNotImage = (HolderNotImage) holder;
            holderNotImage.title.setText(discuss.getTitle());
            holderNotImage.username.setText(discuss.getNamePost());
        }else {
            HolderImage holderImage = (HolderImage) holder;
            holderImage.title.setText(discuss.getTitle());
            holderImage.username.setText(discuss.getNamePost());
            Picasso.get().load(Uri.parse(discuss.getIdPic())).into(holderImage.imgPic);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Discuss discuss = list.get(position);
        if (discuss.getIdPic() == null) return 1;
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class HolderImage extends RecyclerView.ViewHolder{
        TextView username, title, clickToDiscuss;
        ImageView imgPic;
        public HolderImage(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.userNamePost);
            title = itemView.findViewById(R.id.titlePost);
            imgPic = itemView.findViewById(R.id.imageTopic);
            clickToDiscuss = itemView.findViewById(R.id.clickToDiscuss);
        }
    }
    public static class HolderNotImage extends RecyclerView.ViewHolder{
        TextView title, username, clickToDiscuss;
        public HolderNotImage(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titlePostNoImg);
            username = itemView.findViewById(R.id.userNamePostNoImg);
            clickToDiscuss = itemView.findViewById(R.id.clickToDiscussNoImg);
        }
    }
}
