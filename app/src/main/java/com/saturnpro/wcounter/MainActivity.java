package com.saturnpro.wcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.saturnpro.wcounter.REPLY";
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private TextView text;
    private TextView counterTxt;
    List<String> words;
    int count = 0;
    int i = 0;
    Intent replyIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.txt);
        counterTxt = findViewById(R.id.countertext);
        words = new ArrayList<>();
        words.add("hello");
        words.add("hi");
        words.add("cat");
        words.add("dog");
        words.add("drink");
        words.add("planet");
        words.add("space");
        words.add("kind");
        text.setText(words.get(0));
        counterTxt.setText(count+"");
        replyIntent = new Intent();
    }

    public void addToYesList(View view) {
        i++;
        if(i < words.size()) {
            String word = words.get(i);
            text.setText(word);
            count++;
            counterTxt.setText(count+"");
            if(TextUtils.isEmpty(word)) {
                setResult(RESULT_CANCELED, replyIntent);
            }
            else {
                replyIntent.putExtra(EXTRA_REPLY, words.get(i));
                setResult(RESULT_OK, replyIntent);
            }
        }
        else {
            text.setText("Слов больше нет");
        }
    }

    public void addToNoList(View view) {
        i++;
        if (i < words.size()) {
            String word = words.get(i);
            text.setText(word);
            if(TextUtils.isEmpty(word)) {
                setResult(RESULT_CANCELED, replyIntent);
            }
            else {
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        }
        else {
            text.setText("Слов больше нет");
        }
    }

    public void iknow(View view) {
        Intent i = new Intent(MainActivity.this, YesList.class);
        startActivityForResult(i, NEW_WORD_ACTIVITY_REQUEST_CODE);
    }

    public void idontknow(View view) {
        Intent i = new Intent(MainActivity.this,NoList.class);
        startActivity(i);
    }
}