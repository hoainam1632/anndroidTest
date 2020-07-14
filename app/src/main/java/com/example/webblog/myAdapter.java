package com.example.webblog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewsHolder> {
    private Context context;
    private ArrayList<menu> arrMenu;

    public myAdapter(Context context, ArrayList<menu> arrMenu) {
        this.context = context;
        this.arrMenu = arrMenu;
    }

    @NonNull
    @Override
    public ViewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater minflater = LayoutInflater.from(context);
        View view = minflater.inflate(R.layout.item_menu, parent, false);
        return new ViewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewsHolder holder, int position) {
            final menu Menu = arrMenu.get(position);
            Picasso.get().load(Menu.getImg()).resize(500,180).into(holder.imgMenu);
            holder.txtTitle.setText(Menu.getTitle());
            holder.itemMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context , ListActivity.class);
                    intent.putExtra("name", Menu.getTitle());
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrMenu.size();
    }

    public class ViewsHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private ImageView imgMenu;
        private CardView itemMenu;
        public ViewsHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            imgMenu = (ImageView) itemView.findViewById(R.id.img_menu);
            itemMenu = (CardView) itemView.findViewById(R.id.cv_menu);
        }
    }
}
