package com.samplenativescreen

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SampleNativeActivity: AppCompatActivity() {
    private lateinit var header: TextView
    private lateinit var input: EditText
    private lateinit var button: Button
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_native)

        toolbar = findViewById(R.id.sample_native_toolbar)
        header = findViewById(R.id.sample_native_header)
        input = findViewById(R.id.sample_native_input)
        button = findViewById(R.id.sample_native_button)

        setSupportActionBar(toolbar)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        toolbar.navigationIcon?.setTint(Color.MAGENTA)
        toolbar.setTitleTextColor(Color.MAGENTA)

        val args = intent.extras
        val headerText = args?.getString("header")

        if (headerText != null) {
            header.text = headerText
        }

        input.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                button.performClick()
                true
            } else {
                false
            }
        }

        button.setOnClickListener { submit() }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val data = Intent()
                data.putExtra("success", false)
                setResult(RESULT_OK, data)
                finish()
            }
        })
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            val firstResponder = currentFocus
            if (firstResponder is EditText) {
                dismissKeyboard(firstResponder, ev.rawX, ev.rawY)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    private fun submit() {
        val data = Intent()
        data.putExtra("text", input.text.toString())
        data.putExtra("success", true)
        setResult(RESULT_OK, data)
        finish()
    }

    private fun dismissKeyboard(focusedView: View, x: Float, y: Float) {
        val location = IntArray(2)
        focusedView.getLocationOnScreen(location)

        if (
            x > location[0] && x < (location[0] + focusedView.width) &&
                    y > location[1] && y < (location[1] + focusedView.height)
        ) {
            return
        }

        focusedView.clearFocus()
        ViewCompat.getWindowInsetsController(focusedView)?.hide(WindowInsetsCompat.Type.ime())
    }
}
