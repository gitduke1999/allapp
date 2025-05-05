package de.indix.allapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import de.indix.allapp.Kostenpunkt; 


@Dao
public interface KostenpunktDao {
    @Insert
    void insert(Kostenpunkt kostenpunkt);

    @Update
    void update(Kostenpunkt kostenpunkt);

    @Delete
    void delete(Kostenpunkt kostenpunkt);

    @Query("SELECT * FROM Kostenpunkt")
    LiveData<List<Kostenpunkt>> getAll();

    @Query("SELECT * FROM Kostenpunkt")
    List<Kostenpunkt> getAllSync();
}
