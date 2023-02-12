package com.samplenativelistclassic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class NativeListClassicViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView label;

    public NativeListClassicViewHolder(View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.sample_list_classic_card_image);
        this.label = itemView.findViewById(R.id.sample_list_classic_card_label);
    }
}
