package com.example.blbliodb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Book.class}, version = 1)
public abstract class BiblioDatabase extends RoomDatabase {
    public abstract BookDao bookDao();

    private static volatile BiblioDatabase INSTANCE;

    static BiblioDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BiblioDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BiblioDatabase.class, "biblio_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
