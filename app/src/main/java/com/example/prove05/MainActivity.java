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
    public static final String EXTRA_BOOK = "com.example.prove05.MESSAGE";
    public static final String EXTRA_CHAPTER = "";
    public static final String EXTRA_VERSE = "";
    public static final String EXTRA_MESSAGE = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayBook(View view) {
        EditText editBook = (EditText) findViewById(R.id.bookName);
        String message = editBook.getText().toString();
        EditText editChapter = (EditText) findViewById(R.id.chapterNumber);
        message += " ";
        message += editChapter.getText().toString();
        EditText editVerse = (EditText) findViewById(R.id.verseNumber);
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

    private void loadBookmark() {
        SharedPreferences pref = getSharedPreferences("Data", Context.MODE_PRIVATE);
        EditText editBook = (EditText) findViewById(R.id.bookName);
        String book = pref.getString("Book","");
        editBook.setText(book);
        EditText editChapter = (EditText) findViewById(R.id.chapterNumber);
        editChapter.setText(pref.getString())
        message += editChapter.getText().toString();
        EditText editVerse = (EditText) findViewById(R.id.verseNumber);
    }
}