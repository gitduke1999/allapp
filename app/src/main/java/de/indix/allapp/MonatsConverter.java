package de.indix.allapp;

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