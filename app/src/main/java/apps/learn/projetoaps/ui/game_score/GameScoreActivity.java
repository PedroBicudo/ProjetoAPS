package apps.learn.projetoaps.ui.game_score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;
import apps.learn.projetoaps.R;
import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;
import apps.learn.projetoaps.databinding.ActivityGameScoreBinding;
import apps.learn.projetoaps.ui.adapter.PlayersViewAdapter;
import apps.learn.projetoaps.ui.game_quiz.GameQuizActivity;

public class GameScoreActivity extends AppCompatActivity implements GameScoreContract.View {

    private ActivityGameScoreBinding activityGameScoreBinding;
    private static final String TAG = "GameScoreActivity";
    private GameScorePresenter gameScorePresenter;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGameScoreBinding = ActivityGameScoreBinding.inflate(getLayoutInflater());
        setContentView(activityGameScoreBinding.getRoot());

        this.gameScorePresenter = new GameScorePresenter(GameScoreActivity.this);
        this.gameScorePresenter.loadPlayerList();

        this.view = getLayoutInflater().inflate(R.layout.fragment_insert_player_name, null);
        getAlertDialog().show();

        this.activityGameScoreBinding.btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameScorePresenter.loadQuizQuestions();
            }
        });
    }

    @Override
    public AlertDialog getAlertDialog() {
        return new AlertDialog.Builder(GameScoreActivity.this)
                .setView(view)
                .setMessage("Insira o nome do player:")
                .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gameScorePresenter.addNewPlayer();
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
    public void setProgressBarGone() {
        this.activityGameScoreBinding.progressBar.setVisibility(ProgressBar.GONE);
    }

    @Override
    public void setProgressBarVisible() {
        this.activityGameScoreBinding.progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void populateRecyclerView(PlayersViewAdapter playersViewAdapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.activityGameScoreBinding.listPlayersRank.setAdapter(playersViewAdapter);
        this.activityGameScoreBinding.listPlayersRank.setLayoutManager(layoutManager);
    }

    @Override
    public void openGameQuizActivity(ArrayList<Quiz> quizzes) {
        Intent intent = new Intent(GameScoreActivity.this, GameQuizActivity.class);
        intent.putExtra("quizQuestions", quizzes);
        startActivity(intent);
        finish();
    }

}
