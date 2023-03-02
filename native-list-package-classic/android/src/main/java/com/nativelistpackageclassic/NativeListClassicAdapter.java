package com.nativelistpackageclassic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class NativeListClassicAdapter extends RecyclerView.Adapter<NativeListClassicViewHolder> {
    public List<ClassicDataItem> data = Collections.emptyList();
    public String placeholderImage = "";
    private final Context context;

    public NativeListClassicAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public NativeListClassicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_classic, parent, false);
        return new NativeListClassicViewHolder(itemView); 
    }

    @Override
    public void onBindViewHolder(NativeListClassicViewHolder holder, int position) {
        Drawable drawable = ResourcesCompat.getDrawable(
            context.getResources(),
            getDrawableIdWithName(placeholderImage),
            null
        );
        holder.imageView.setImageDrawable(drawable);
        holder.label.setText(data.get(position).description);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private int getDrawableIdWithName(String name) {
        Resources appResources = context.getResources();
        int resourceId = appResources.getIdentifier(name, "drawable", context.getPackageName());
        if (resourceId == 0) {
            // If drawable is not present in app's resources, check system's resources
            resourceId = getResId(name, android.R.drawable.class);
        }
        return resourceId;
    }

    private int getResId(String resName, Class c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
