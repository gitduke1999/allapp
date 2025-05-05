package de.indix.allapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import de.indix.allapp.viewmodel.KostenpunktViewModel;

public class MonatskostenActivity extends AppCompatActivity {
    TextView textView;
    KostenpunktViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monatskosten);
        textView = findViewById(R.id.textView);

        viewModel = new ViewModelProvider(this).get(KostenpunktViewModel.class);

        Map<Integer, Double> kosten = viewModel.berechneMonatskosten();
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= 12; i++) {
            builder.append("Monat ").append(i).append(": ").append(kosten.get(i)).append("€\n");
        }

        textView.setText(builder.toString());
    }
}
