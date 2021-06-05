package com.saturnpro.wcounter;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Words {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String world;

    public Words(@NonNull String world) {
        this.world = world;
    }

    public String getWorld() {
        return world;
    }
}
