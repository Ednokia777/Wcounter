package com.saturnpro.wcounter;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Words words);

    @Query("DELETE FROM word_table")
    void deleteAll();

    //тут мы получаем весь список слов
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Words>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Words[] words);

}
