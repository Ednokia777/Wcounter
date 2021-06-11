package com.saturnpro.wcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class NoList extends AppCompatActivity {
    private WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_list);
        RecyclerView recyclerViewNo = findViewById(R.id.listNo);
        final WordListAdapter adapter = new WordListAdapter(new WordListAdapter.WordDiff());
        recyclerViewNo.setAdapter(adapter);
        recyclerViewNo.setLayoutManager(new LinearLayoutManager(this));
        //mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        mWordViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(this, words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);
        });
        Words words = new Words(getIntent().getStringExtra(MainActivity.EXTRA_NO));
        mWordViewModel.insert(words);
        Log.d("proverka", mWordViewModel.toString());
    }
}