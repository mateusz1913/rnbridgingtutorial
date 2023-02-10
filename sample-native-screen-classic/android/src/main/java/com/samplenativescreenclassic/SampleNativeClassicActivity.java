package com.samplenativescreenclassic;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class SampleNativeClassicActivity extends AppCompatActivity {
    private TextView header;
    private EditText input;
    private Button button;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_native_classic);

        toolbar = findViewById(R.id.sample_native_classic_toolbar);
        header = findViewById(R.id.sample_native_classic_header);
        input = findViewById(R.id.sample_native_classic_input);
        button = findViewById(R.id.sample_native_classic_button);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon != null) {
            navigationIcon.setTint(Color.MAGENTA);
        }
        toolbar.setTitleTextColor(Color.MAGENTA);

        Bundle args = getIntent().getExtras();
        String headerText = null;
        if (args != null) {
            headerText = args.getString("header");
        }

         if (headerText != null) {
             header.setText(headerText);
         }

         input.setOnEditorActionListener((v, actionId, event) -> {
             if (actionId == EditorInfo.IME_ACTION_DONE) {
                 button.performClick();
                 return true;
             }
             return false;
         });

         button.setOnClickListener(v -> submit());

         getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
             @Override
             public void handleOnBackPressed() {
                 Intent data = new Intent();
                 data.putExtra("success", false);
                 setResult(RESULT_OK, data);
                 finish();
             }
         });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View firstResponder = getCurrentFocus();
            if (firstResponder instanceof EditText) {
                dismissKeyboard(firstResponder, ev.getRawX(), ev.getRawY());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }

    private void submit() {
        Intent data = new Intent();
        data.putExtra("text", input.getText().toString());
        data.putExtra("success", true);
        setResult(RESULT_OK, data);
        finish();
    }

    private void dismissKeyboard(View focusedView, float x, float y) {
        int[] location = new int[2];
        focusedView.getLocationOnScreen(location);

        if (
            x > location[0] && x < (location[0] + focusedView.getWidth()) &&
                    y > location[1] && y < (location[1] + focusedView.getHeight())
        ) {
            return;
        }

        focusedView.clearFocus();
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(focusedView);
        if (windowInsetsController != null) {
            windowInsetsController.hide(WindowInsetsCompat.Type.ime());
        }
    }
}
