package com.saturnpro.wcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_YES = "com.saturnpro.wcounter.YES";
    public static final String EXTRA_NO = "com.saturnpro.wcounter.NO";
    private TextView text;
    private TextView counterTxt;
    List<String> words;
    int count = 0;
    int i = 0;
    Intent intentYes;
    Intent intentNo;

    //test
    private WordViewModel mWordViewModel;

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
        counterTxt.setText(count+"");
        intentYes = new Intent(MainActivity.this, YesList.class);
        intentNo = new Intent(MainActivity.this, NoList.class);

        //test
        mWordViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(WordViewModel.class);
    }

    public void addToYesList(View view) {
        if(i < words.size()) {
            String word = words.get(i);
            text.setText(word);
            count++;
            counterTxt.setText(count+"");
            i++;
            //нужно делать insert каждого слова в базу данных.
            Words www = new Words(word);
            mWordViewModel.insert(www);
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
            intentNo.putExtra(EXTRA_NO, word);
        }
        else {
            text.setText("Слов больше нет");
        }
    }

    public void iknow(View view) {
        startActivity(intentYes);
    }

    public void idontknow(View view) {
        Toast.makeText(this, "Кнопка пока что закрыта", Toast.LENGTH_SHORT).show();
    }
}