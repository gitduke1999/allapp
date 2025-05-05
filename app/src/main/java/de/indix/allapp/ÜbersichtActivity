package de.indix.allapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import de.indix.allapp.viewmodel.KostenpunktViewModel;
import de.indix.allapp.adapter.KostenpunktAdapter;


public class ÜbersichtActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    KostenpunktViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uebersicht);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(KostenpunktViewModel.class);

        viewModel.getAlleKostenpunkte().observe(this, kostenpunkte -> {
            recyclerView.setAdapter(new KostenpunktAdapter(kostenpunkte, viewModel));
        });
    }
}
