package com.example.prove05;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

    private void saveBookmark() {
        SharedPreferences pref = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Book", MainActivity.EXTRA_BOOK.toString());
        editor.putString("Chapter", MainActivity.EXTRA_CHAPTER.toString());
        editor.putString("Verse", MainActivity.EXTRA_VERSE.toString());
        editor.commit();
        Log.v("TAG", "Preferences saved.");
    }
}