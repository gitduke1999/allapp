package de.indix.allapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import your.package.name.model.Kostenpunkt;
import your.package.name.model.MonatsConverter;
import your.package.name.data.KostenpunktDao; // Passe das Package an


@Database(entities = {Kostenpunkt.class}, version = 1)
@TypeConverters({MonatsConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract KostenpunktDao kostenpunktDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "kosten-db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
