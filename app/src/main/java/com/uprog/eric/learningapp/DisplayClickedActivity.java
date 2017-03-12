package com.uprog.eric.learningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayClickedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_clicked);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_BUTTON_CLICKED);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.country_flag);

        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.addView(textView);
        linear.addView(imageView);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_clicked);
        layout.addView(linear);

    }
}
