package com.samplenativelist

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Field

class NativeListAdapter(private val context: Context): RecyclerView.Adapter<NativeListViewHolder>() {
    var data: List<DataItem> = emptyList()
    var placeholderImage: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NativeListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return NativeListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NativeListViewHolder, position: Int) {
        val drawable = ResourcesCompat.getDrawable(
            context.resources,
            getDrawableIdWithName(placeholderImage),
            null
        )
        holder.imageView.setImageDrawable(drawable)
        holder.label.text = data[position].description
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private fun getDrawableIdWithName(name: String): Int {
        val appResources: Resources = context.resources
        var resourceId = appResources.getIdentifier(name, "drawable", context.packageName)
        if (resourceId == 0) {
            // If drawable is not present in app's resources, check system's resources
            resourceId = getResId(name, android.R.drawable::class.java)
        }
        return resourceId
    }

    private fun getResId(resName: String, c: Class<*>): Int {
        return try {
            val idField: Field = c.getDeclaredField(resName)
            idField.getInt(idField)
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }
}
