package com.example.prove05;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BookChosen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_chosen);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        String TAG = "secondTAG";
        Log.v(TAG, "Received intent with " + message);
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);
    }

    public void saveBookmark(View view) {
        Intent intent = getIntent();
        SharedPreferences pref = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Book", intent.getStringExtra(MainActivity.EXTRA_BOOK));
        editor.putString("Chapter", intent.getStringExtra(MainActivity.EXTRA_CHAPTER));
        editor.putString("Verse", intent.getStringExtra(MainActivity.EXTRA_VERSE));
        editor.apply();
        Log.v("TAG", "Bookmark " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
                                + " saved.");
    }
}