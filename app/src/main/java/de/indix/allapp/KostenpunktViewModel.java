package de.indix.allapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.indix.allapp.AppDatabase;
import de.indix.allapp.KostenpunktDao;
import de.indix.allapp.Kostenpunkt;


public class KostenpunktViewModel extends AndroidViewModel {
    private final KostenpunktDao dao;
    private final LiveData<List<Kostenpunkt>> alleKostenpunkte;

    public KostenpunktViewModel(@NonNull Application application) {
        super(application);
        dao = AppDatabase.getInstance(application).kostenpunktDao();
        alleKostenpunkte = dao.getAll();
    }

    public LiveData<List<Kostenpunkt>> getAlleKostenpunkte() {
        return alleKostenpunkte;
    }

    public void insert(Kostenpunkt k) {
        dao.insert(k);
    }

    public void update(Kostenpunkt k) {
        dao.update(k);
    }

    public void delete(Kostenpunkt k) {
        dao.delete(k);
    }

    public Map<Integer, Double> berechneMonatskosten() {
        List<Kostenpunkt> liste = dao.getAllSync();
        Map<Integer, Double> monatsSummen = new HashMap<>();

        for (int i = 1; i <= 12; i++) monatsSummen.put(i, 0.0);

        for (Kostenpunkt k : liste) {
            for (int monat : k.abbuchungsmonate) {
                monatsSummen.put(monat, monatsSummen.get(monat) + k.betrag);
            }
        }

        return monatsSummen;
    }
}
