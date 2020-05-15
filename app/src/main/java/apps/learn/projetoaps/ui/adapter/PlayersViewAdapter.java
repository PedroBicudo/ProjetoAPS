package apps.learn.projetoaps.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import apps.learn.projetoaps.data.model.Jogador;
import apps.learn.projetoaps.databinding.ActivityPlayerCardBinding;

public class PlayersViewAdapter extends RecyclerView.Adapter<PlayersViewAdapter.PlayerCard> {

    List<Jogador> jogadores;

    public PlayersViewAdapter(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    @NonNull
    @Override
    public PlayerCard onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ActivityPlayerCardBinding playerCardBinding;
        playerCardBinding = ActivityPlayerCardBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
                );

        return new PlayerCard(playerCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerCard holder, int position) {
        Jogador jogador = this.jogadores.get(position);
        holder.getActivityPlayerCardBinding().txtPlayerName.setText(jogador.getNome());
        holder.getActivityPlayerCardBinding().txtPlayerScore.setText(String.valueOf(jogador.getResultado()));
    }

    @Override
    public int getItemCount() {
        return jogadores.size();
    }

    public class PlayerCard extends RecyclerView.ViewHolder {

        private ActivityPlayerCardBinding activityPlayerCardBinding;

        public ActivityPlayerCardBinding getActivityPlayerCardBinding() {
            return activityPlayerCardBinding;
        }

        public void setActivityPlayerCardBinding(ActivityPlayerCardBinding activityPlayerCardBinding) {
            this.activityPlayerCardBinding = activityPlayerCardBinding;
        }

        public PlayerCard(@NonNull ActivityPlayerCardBinding activityPlayerCardBinding) {
            super(activityPlayerCardBinding.getRoot());
            this.setActivityPlayerCardBinding(activityPlayerCardBinding);
        }

    }
}
