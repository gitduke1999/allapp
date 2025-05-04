package de.indix.allapp;

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