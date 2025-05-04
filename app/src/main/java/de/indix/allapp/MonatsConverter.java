package de.indix.allapp;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MonatsConverter {
    @TypeConverter
    public String fromList(List<Integer> list) {
        return new Gson().toJson(list);
    }

    @TypeConverter
    public List<Integer> toList(String value) {
        Type listType = new TypeToken<List<Integer>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
}