package de.indix.allapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import de.indix.allapp.Kostenpunkt;
import de.indix.allapp.KostenpunktViewModel;
import de.indix.allapp.R;

public class KostenpunktAdapter extends RecyclerView.Adapter<KostenpunktAdapter.ViewHolder> {
    private final List<Kostenpunkt> kostenpunkte;
    private final KostenpunktViewModel viewModel;

    public KostenpunktAdapter(List<Kostenpunkt> kostenpunkte, KostenpunktViewModel viewModel) {
        this.kostenpunkte = kostenpunkte;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kostenpunkt, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Kostenpunkt k = kostenpunkte.get(position);
        holder.name.setText(k.name);
        holder.betrag.setText(k.betrag + " €");

        holder.itemView.setOnLongClickListener(v -> {
            viewModel.delete(k);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return kostenpunkte.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, betrag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.kostenpunktName);
            betrag = itemView.findViewById(R.id.kostenpunktBetrag);
        }
    }
}
