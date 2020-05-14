package apps.learn.projetoaps.ui.game_score;

import android.app.AlertDialog;

import java.util.List;
import java.util.Stack;

import apps.learn.projetoaps.data.model.Jogador;
import apps.learn.projetoaps.data.model.Pergunta;

public interface GameScoreContract {

    interface View {
        AlertDialog getAlertDialog();
        String getPlayerName();
        void populateRecyclerView(List<Jogador> jogadores);
        void openGameQuizActivity(Stack<Pergunta> perguntas);
    }

    interface Presenter {
        void adicionarNovoJogador();

    }

}
