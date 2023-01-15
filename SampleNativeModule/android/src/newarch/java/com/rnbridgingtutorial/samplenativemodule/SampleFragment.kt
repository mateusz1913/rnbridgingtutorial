package com.rnbridgingtutorial.samplenativemodule

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class SampleFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        val frameLayout = FrameLayout(requireContext())
        frameLayout.setPadding(16, 16, 16, 16)

        val textView = TextView(requireContext())
        textView.text = "Welcome to Android Fragments with React Native."

        frameLayout.addView(textView)

        return frameLayout
    }

    fun setBackgroundColor(backgroundColor: Int?) {
        requireView().setBackgroundColor(backgroundColor ?: Color.TRANSPARENT)
    }
}
