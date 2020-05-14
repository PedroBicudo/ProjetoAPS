package apps.learn.projetoaps.ui.game_score;

import android.util.Log;

import apps.learn.projetoaps.data.model.Jogador;

public class GameScorePresenter implements GameScoreContract.Presenter {

    private static final String TAG = "GameScorePresenter";
    private GameScoreActivity gameScoreActivity;

    public GameScorePresenter(GameScoreActivity gameScoreActivity) {
        this.gameScoreActivity = gameScoreActivity;
    }

    @Override
    public void adicionarNovoJogador() {
        String name = gameScoreActivity.getPlayerName();
        if (name.isEmpty()) {
            Log.i(TAG, "adicionarNovoJogador: Nome vazio, saindo...");
            return;
        }
        Jogador jogador = new Jogador();
        jogador.setNome(name);
        jogador.setResultado(100); // dummy
        Log.d(TAG, "adicionarNovoJogador: "+jogador.getNome()+" - "+jogador.getResultado());
    }


}
