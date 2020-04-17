package apps.learn.projetoaps.ui.game_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Stack;

import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.databinding.ActivityGameMenuBinding;
import apps.learn.projetoaps.ui.main.MainActivity;

public class GameMenuActivity extends AppCompatActivity implements GameMenuContract.View {

    private ActivityGameMenuBinding activityGameMenuBinding;
    private GameMenuPresenter gameMenuPresenter;

    public ActivityGameMenuBinding getActivityGameMenuBinding() {
        return activityGameMenuBinding;
    }

    public void setActivityGameMenuBinding(ActivityGameMenuBinding activityGameMenuBinding) {
        this.activityGameMenuBinding = activityGameMenuBinding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGameMenuBinding = ActivityGameMenuBinding.inflate(getLayoutInflater());
        setContentView(activityGameMenuBinding.getRoot());

        gameMenuPresenter = new GameMenuPresenter(this);
        activityGameMenuBinding.startGame.setOnClickListener(this);
    }

    @Override
    public void hideStartButton() {
        activityGameMenuBinding.startGame.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        activityGameMenuBinding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void openQuizActivity(Stack<Pergunta> perguntas) {
        Intent intent = new Intent(GameMenuActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        hideStartButton();
        showProgressBar();
        Stack<Pergunta> perguntas = gameMenuPresenter.getPerguntasFromDatabase();
        openQuizActivity(perguntas);
    }
}
