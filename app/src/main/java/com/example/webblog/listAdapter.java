package com.example.webblog;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewsHolder> {
    private Context context;
    private ArrayList<listContent> mContent;

    public listAdapter(Context context, ArrayList<listContent> mContent) {
        this.context = context;
        this.mContent = mContent;
    }

    @NonNull
    @Override
    public ViewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(context);
        View v = myInflater.inflate(R.layout.list_content, parent, false);
        return new ViewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewsHolder holder, int position) {
            listContent myListContent = mContent.get(position);
            holder.txtTitle2.setText(myListContent.getTitle());
            holder.txtDate.setText(myListContent.getDate());
            Picasso.get().load(myListContent.getImg())
                    .resize(200,200)
                    .into(holder.imgTitle);
    }

    @Override
    public int getItemCount() {
        return mContent.size();
    }

    public class ViewsHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle2, txtDate;
        private ImageView imgTitle;
        public ViewsHolder(@NonNull View itemView) {
            super(itemView);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtTitle2 = itemView.findViewById(R.id.txt_Title2);
            imgTitle = itemView.findViewById(R.id.img_title);
        }
    }
}
