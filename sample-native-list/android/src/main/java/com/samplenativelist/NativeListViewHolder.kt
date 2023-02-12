package com.samplenativelist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NativeListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView
    var label: TextView

    init {
        imageView = itemView.findViewById(R.id.sample_list_card_image)
        label = itemView.findViewById(R.id.sample_list_card_label)
    }
}
