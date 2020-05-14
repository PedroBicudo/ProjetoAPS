package apps.learn.projetoaps.ui.game_score;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.Stack;

import apps.learn.projetoaps.R;
import apps.learn.projetoaps.data.model.Jogador;
import apps.learn.projetoaps.data.model.Pergunta;

public class GameScoreActivity extends AppCompatActivity implements GameScoreContract.View {

    private static final String TAG = "GameScoreActivity";
    private GameScorePresenter gameScorePresenter;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.view = getLayoutInflater().inflate(R.layout.fragment_insert_player_name, null);
        this.gameScorePresenter = new GameScorePresenter(GameScoreActivity.this);
        getAlertDialog().show();

    }

    @Override
    public AlertDialog getAlertDialog() {
        return new AlertDialog.Builder(GameScoreActivity.this)
                .setView(view)
                .setMessage("Insira o nome do player:")
                .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gameScorePresenter.adicionarNovoJogador();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create();
    }

    @Override
    public String getPlayerName() {
        return ((TextView) view.findViewById(R.id.edit_text_player_name)).getText().toString();
    }

    @Override
    public void populateRecyclerView(List<Jogador> jogadores) {

    }

    @Override
    public void openGameQuizActivity(Stack<Pergunta> perguntas) {}


}
