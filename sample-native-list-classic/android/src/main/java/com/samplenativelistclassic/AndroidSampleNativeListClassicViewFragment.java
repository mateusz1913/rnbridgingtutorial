package com.samplenativelistclassic;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

import java.util.ArrayList;
import java.util.List;

public class AndroidSampleNativeListClassicViewFragment extends Fragment {
    public static final String NAME = "AndroidSampleNativeListClassicView";
    private static final int NUM_OF_COLUMNS = 3;

    @Override
    public View onCreateView(
      LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_list_classic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.sample_list_classic);
        recyclerView.setLayoutManager(new GridLayoutManager(
                requireContext(),
                NUM_OF_COLUMNS,
                GridLayoutManager.VERTICAL,
                false
        ));
        recyclerView.setAdapter(new NativeListClassicAdapter(requireContext()));
    }

    public void setBackgroundColor(@Nullable Integer backgroundColor) {
        Integer color = backgroundColor;
        if (color == null) {
            color = Color.TRANSPARENT;
        }
        requireView().setBackgroundColor(color);
    }

    public void setData(ReadableArray data) {
        List<ClassicDataItem> listData = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            ReadableMap item = data.getMap(i);
            ClassicDataItem dataItem = new ClassicDataItem(item.getString("imageUrl"), item.getString("description"));
            listData.add(dataItem);
        }
        RecyclerView recyclerView = requireView().findViewById(R.id.sample_list_classic);
        ((NativeListClassicAdapter)recyclerView.getAdapter()).data = listData;
    }

    public void setOptions(ReadableMap options) {
        String placeholderImage = options.getString("placeholderImage");
        RecyclerView recyclerView = requireView().findViewById(R.id.sample_list_classic);
        ((NativeListClassicAdapter)recyclerView.getAdapter()).placeholderImage = placeholderImage;
    }

    public void scrollToItem(int index) {
        RecyclerView recyclerView = requireView().findViewById(R.id.sample_list_classic);
        recyclerView.smoothScrollToPosition(index);
    }
}
