package com.saturnpro.wcounter;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.Arrays;
import java.util.List;

class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Words>> mAllWords;

    WordRepository(Application application) {
        WordRoomDataBase db = WordRoomDataBase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    LiveData<List<Words>> getAllWords() {
        return mAllWords;
    }
    void insert(Words word) {
        WordRoomDataBase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }

    //метод getAllWord не работает так как я добавляю слова только при откртии активити
    //нужно добавлять insert в майнактивити, при нажатии на кнопку.
}