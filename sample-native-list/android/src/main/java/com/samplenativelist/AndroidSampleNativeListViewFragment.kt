package com.samplenativelist

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.bridge.ReadableMap

class AndroidSampleNativeListViewFragment: Fragment() {
    override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.sample_list)
        recyclerView.layoutManager = GridLayoutManager(
            requireContext(),
            NUM_OF_COLUMNS,
            GridLayoutManager.VERTICAL,
            false
        )
        recyclerView.adapter = NativeListAdapter(requireContext())
    }

    fun setBackgroundColor(backgroundColor: Int?) {
        requireView().setBackgroundColor(backgroundColor ?: Color.TRANSPARENT)
    }

    fun setData(data: ReadableArray) {
        val listData = mutableListOf<DataItem>()
        for (i in 0 until data.size()) {
            val item = data.getMap(i)
            listData.add(DataItem(item.getString("imageUrl")!!, item.getString("description")!!))
        }
        val recyclerView: RecyclerView = requireView().findViewById(R.id.sample_list)
        (recyclerView.adapter as NativeListAdapter).data = listData
        (recyclerView.adapter as NativeListAdapter).notifyDataSetChanged()
    }

    fun setOptions(options: ReadableMap) {
        val placeholderImage = options.getString("placeholderImage")!!
        val recyclerView: RecyclerView = requireView().findViewById(R.id.sample_list)
        (recyclerView.adapter as NativeListAdapter).placeholderImage = placeholderImage
    }

    fun scrollToItem(index: Int) {
        val recyclerView: RecyclerView = requireView().findViewById(R.id.sample_list)
        recyclerView.smoothScrollToPosition(index)
    }

    companion object {
        const val NAME = "AndroidSampleNativeListView"
        private const val NUM_OF_COLUMNS = 3
    }
}
