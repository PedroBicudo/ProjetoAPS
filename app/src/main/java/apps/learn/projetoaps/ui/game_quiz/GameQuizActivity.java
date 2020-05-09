package apps.learn.projetoaps.ui.game_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.databinding.ActivityGameQuizBinding;

public class GameQuizActivity extends AppCompatActivity implements GameQuizContract.View {

    private static final String TAG = "GameQuizActivity";
    private ActivityGameQuizBinding activityGameQuizBinding;

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

    }

    @Override
    public void changePergunta(String title) {
        this.getActivityGameQuizBinding().question.setText(title);
    }

    @Override
    public void changeAlternativas(Alternativa[] alternativas) {

    }

    @Override
    public void changeButtonColor(Button button, String color) {

    }

    @Override
    public void resetButtonsColor() {

    }

    @Override
    public void openScoreActivity(int score) {

    }

    @Override
    public void onClick(View v) {

    }
}
