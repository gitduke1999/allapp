package de.indix.allapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import de.indix.allapp.KostenpunktViewModel;
import de.indix.allapp.Kostenpunkt;


public class ErfassungsmaskeActivity extends AppCompatActivity {
    EditText name, kategorie, tag, betrag, monate;
    Button speichern;
    KostenpunktViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erfassungsmaske);

        name = findViewById(R.id.nameInput);
        kategorie = findViewById(R.id.kategorieInput);
        tag = findViewById(R.id.tagInput);
        betrag = findViewById(R.id.betragInput);
        monate = findViewById(R.id.monateInput);
        speichern = findViewById(R.id.speichernButton);

        viewModel = new ViewModelProvider(this).get(KostenpunktViewModel.class);

        speichern.setOnClickListener(v -> {
            Kostenpunkt k = new Kostenpunkt();
            k.name = name.getText().toString();
            k.kategorie = kategorie.getText().toString();
            k.abbuchungstag = Integer.parseInt(tag.getText().toString());
            k.betrag = Double.parseDouble(betrag.getText().toString());
            k.abbuchungsmonate = parseMonate(monate.getText().toString());

            viewModel.insert(k);
            finish();
        });
    }

    private List<Integer> parseMonate(String input) {
        List<Integer> result = new ArrayList<>();
        for (String s : input.split(",")) {
            result.add(Integer.parseInt(s.trim()));
        }
        return result;
    }
}
