package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_BOOK = "book";
    public static final String EXTRA_CHAPTER = "chapter";
    public static final String EXTRA_VERSE = "verse";
    public static final String EXTRA_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayBook(View view) {
        EditText editBook = findViewById(R.id.bookName);
        String message = editBook.getText().toString();
        EditText editChapter = findViewById(R.id.chapterNumber);
        message += " ";
        message += editChapter.getText().toString();
        EditText editVerse = findViewById(R.id.verseNumber);
        message += ":";
        message += editVerse.getText().toString();
        String TAG = "mainTAG";
        Log.v(TAG, "About to create intent with " + message);
        Intent intent = new Intent(this, BookChosen.class);
        intent.putExtra(EXTRA_BOOK, editBook.getText().toString());
        intent.putExtra(EXTRA_CHAPTER, editChapter.getText().toString());
        intent.putExtra(EXTRA_VERSE, editVerse.getText().toString());
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void loadBookmark(View view) {
        SharedPreferences pref = getSharedPreferences("Data", Context.MODE_PRIVATE);
        EditText editBook = findViewById(R.id.bookName);
        String book = pref.getString("Book","");
        editBook.setText(book);
        EditText editChapter = findViewById(R.id.chapterNumber);
        editChapter.setText(pref.getString("Chapter", ""));
        EditText editVerse = findViewById(R.id.verseNumber);
        editVerse.setText(pref.getString("Verse", ""));
        Log.v("TAG", "Scripture " + editBook.getText() + " " + editChapter.getText() + ":"
                                + editVerse.getText() + " loaded.");
    }
}