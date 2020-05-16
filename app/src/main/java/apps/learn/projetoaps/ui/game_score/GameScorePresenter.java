package apps.learn.projetoaps.ui.game_score;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Stack;

import apps.learn.projetoaps.data.model.Jogador;
import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;
import apps.learn.projetoaps.ui.adapter.PlayersViewAdapter;

public class GameScorePresenter implements GameScoreContract.Presenter {

    private static final String TAG = "GameScorePresenter";
    private PlayersViewAdapter playersViewAdapter;
    private GameScoreActivity gameScoreActivity;

    public GameScorePresenter(GameScoreActivity gameScoreActivity) {
        this.gameScoreActivity = gameScoreActivity;
    }

    // TODO - Fazer acesso ao repositório
    @Override
    public void addNewPlayer() {
        String name = gameScoreActivity.getPlayerName();
        if (name.isEmpty()) {
            Log.i(TAG, "adicionarNovoJogador: Nome vazio, saindo...");
            return;
        }

        Jogador jogador = new Jogador();
        jogador.setNome(name);
        // TODO - Acessar o método de inserção do Room
        reloadPlayerList();
    }

    @Override
    public void loadPlayerList() {
        // TODO - Acessar o método de requisição de jogadores
        playersViewAdapter = new PlayersViewAdapter(new ArrayList<Jogador>());
        gameScoreActivity.setProgressBarGone();
        gameScoreActivity.populateRecyclerView(playersViewAdapter);
    }

    @Override
    public void reloadPlayerList() {
        this.gameScoreActivity.setProgressBarVisible();
        loadPlayerList();
    }

    @Override
    public void loadQuizQuestions() {
        this.gameScoreActivity.setProgressBarVisible();
        // TODO - Acessar o método de requisição de perguntas
        this.gameScoreActivity.openGameQuizActivity(new ArrayList<Quiz>());
    }


}
