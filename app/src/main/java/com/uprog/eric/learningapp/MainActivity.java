package com.uprog.eric.learningapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.uprog.eric.MESSAGE";
    public final static String EXTRA_BUTTON_CLICKED = "com.uprog.eric.BUTTON_CLICKED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        editor.putString(getString(R.string.saved_message), message);
        editor.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
        EditText editText = (EditText) findViewById(R.id.edit_message);
        editText.setText("");
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void clickedOne(View view){
        /*Intent intent = new Intent(this, DisplayClickedActivity.class);
        intent.putExtra(EXTRA_BUTTON_CLICKED, getResources().getString(R.string.clicked_one));
        startActivity(intent);*/
        EditText editText = (EditText) findViewById(R.id.edit_message);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String message = sharedPref.getString(getString(R.string.saved_message),null);
        editText.setText(message);
    }
    public void clickedTwo(View view){
        Intent intent = new Intent(this, DisplayClickedActivity.class);
        intent.putExtra(EXTRA_BUTTON_CLICKED, getResources().getString(R.string.clicked_two));
        startActivity(intent);
    }
}
