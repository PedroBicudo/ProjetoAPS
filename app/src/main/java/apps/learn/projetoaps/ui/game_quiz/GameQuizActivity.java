package apps.learn.projetoaps.ui.game_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import apps.learn.projetoaps.databinding.ActivityGameQuizBinding;

public class GameQuizActivity extends AppCompatActivity {

    private static final String TAG = "GameQuizActivity";
    private ActivityGameQuizBinding activityGameQuizBinding;
    private String correctChoice;


    public ActivityGameQuizBinding getActivityGameQuizBinding() {
        return activityGameQuizBinding;
    }

    public void setActivityGameQuizBinding(ActivityGameQuizBinding ActivityGameQuizBinding) {
        this.activityGameQuizBinding = ActivityGameQuizBinding;
    }

    public String getCorrectChoice() {
        return correctChoice;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setActivityGameQuizBinding(ActivityGameQuizBinding.inflate(getLayoutInflater()));
        setContentView(this.getActivityGameQuizBinding().getRoot());

        // Dummy values para demonstração
        correctChoice = "teste";
        String[] choices = {"teste", "a", "b", "c"};
        String enunciado = "Pergunta de teste?";

        this.changeQuestionTitleAndChoices(enunciado, choices);
    }

    private void changeQuestionTitleAndChoices(String questionTitle, String[] textChoices) {
        this.activityGameQuizBinding.question.setText(questionTitle);
        this.activityGameQuizBinding.firstChoice.setText(textChoices[0]);
        this.activityGameQuizBinding.secondChoice.setText(textChoices[1]);
        this.activityGameQuizBinding.thirdChoice.setText(textChoices[2]);
        this.activityGameQuizBinding.fourthChoice.setText(textChoices[3]);
    }
}
