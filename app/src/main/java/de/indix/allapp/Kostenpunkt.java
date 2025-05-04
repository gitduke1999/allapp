package de.indix.allapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

@Entity
public class Kostenpunkt {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String kategorie;
    public int abbuchungstag;
    public double betrag;

    @TypeConverters(MonatsConverter.class)
    public List<Integer> abbuchungsmonate;
}