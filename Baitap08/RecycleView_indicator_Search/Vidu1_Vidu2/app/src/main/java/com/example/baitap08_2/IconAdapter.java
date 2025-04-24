package com.example.baitap08_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconHolder> {
    private final Context context;
    private List<IconModel> iconList;

    public IconAdapter(Context context, List<IconModel> iconList) {
        this.context = context;
        this.iconList = iconList;
    }

    @NonNull
    @Override
    public IconHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_icon_promotion, parent, false);
        return new IconHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconHolder holder, int position) {
        IconModel icon = iconList.get(position);
        holder.imageView.setImageResource(icon.getImgId());
        holder.textView.setText(icon.getDesc());
    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }

    public void setFilteredList(List<IconModel> filteredList) {
        this.iconList = filteredList;
        notifyDataSetChanged();
    }

    public static class IconHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public IconHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImgIcon);
            textView = itemView.findViewById(R.id.tvIcon);
        }
    }
}