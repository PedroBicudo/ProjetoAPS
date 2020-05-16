package apps.learn.projetoaps.ui.game_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Stack;

import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;
import apps.learn.projetoaps.databinding.ActivityGameQuizBinding;
import apps.learn.projetoaps.ui.game_score.GameScoreActivity;

public class GameQuizActivity extends AppCompatActivity implements GameQuizContract.View {

    private static final String TAG = "GameQuizActivity";
    private ActivityGameQuizBinding activityGameQuizBinding;
    private GameQuizPresenter gameQuizPresenter;

    public GameQuizPresenter getGameQuizPresenter() {
        return gameQuizPresenter;
    }

    public void setGameQuizPresenter(GameQuizPresenter gameQuizPresenter) {
        this.gameQuizPresenter = gameQuizPresenter;
    }

    public ActivityGameQuizBinding getActivityGameQuizBinding() {
        return activityGameQuizBinding;
    }

    public void setActivityGameQuizBinding(ActivityGameQuizBinding ActivityGameQuizBinding) {
        this.activityGameQuizBinding = ActivityGameQuizBinding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setActivityGameQuizBinding(ActivityGameQuizBinding.inflate(getLayoutInflater()));
        setContentView(this.getActivityGameQuizBinding().getRoot());
        ArrayList<Quiz> quizzes = new ArrayList<>();

        // Dummy alternativas
        Alternativa[] alternativas = new Alternativa[4];
        for (int pos=0; pos < alternativas.length; pos++) {
            alternativas[pos] = new Alternativa();
            alternativas[pos].setTexto("Alternativa "+(pos+1));
            alternativas[pos].setCorreta(0);
        }
        alternativas[3].setCorreta(1);
        changeAlternativas(alternativas);

        this.initListeners();
        this.setGameQuizPresenter(new GameQuizPresenter(this, quizzes));
    }

    public void initListeners() {
        ArrayList<View> views = this.getActivityGameQuizBinding().choices.getTouchables();

        for (View view: views) {
            view.setOnClickListener(this);
        }
    }

    @Override
    public void changePergunta(String title) {
        this.getActivityGameQuizBinding().question.setText(title);
    }

    @Override
    public void changeAlternativas(Alternativa[] alternativas) {
        ArrayList<View> views = this.getActivityGameQuizBinding().choices.getTouchables();

        for (int pos=0; pos < views.size(); pos++) {
            Button choice = (Button) views.get(pos);
            Alternativa alternativa = alternativas[pos];
            choice.setText(alternativa.getTexto());
            choice.setTag(choice.getId(), alternativa);
        }
    }

    @Override
    public void changeButtonColor(Button button, String color) {
        button.setBackgroundColor(Color.parseColor(color));
    }

    @Override
    public void resetButtonsColor() {
        Button defaultButton = new Button(this);
        ArrayList<View> views = this.getActivityGameQuizBinding().choices.getTouchables();

        for (View view: views) {
            Button choice = (Button) view;
            choice.setBackground(defaultButton.getBackground());
        }
    }

    @Override
    public void openScoreActivity(int score) {
        Intent intent = new Intent(GameQuizActivity.this, GameScoreActivity.class);
        intent.putExtra("player_score", score);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        this.getGameQuizPresenter().verificarEscolhaEMudarPergunta((Button) v);
    }
}
