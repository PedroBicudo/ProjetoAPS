package apps.learn.projetoaps.ui.game_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import apps.learn.projetoaps.databinding.ActivityGameQuizBinding;

public class GameQuizActivity extends AppCompatActivity implements View.OnClickListener {

    static final private String TAG_BUTTON = "choiceButton";
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

    public void setCorrectChoice(String correctChoice) {
        this.correctChoice = correctChoice;
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

        this.setButtonListeners();
        this.changeQuestionTitleAndChoices(enunciado, choices);
    }
    
    @Override
    public void onClick(View v) {
        if (!(v instanceof Button)) return;
        if (activityGameQuizBinding.progressBar.getProgress() == 100) return;
        Button choice = (Button) v;

        Log.i(TAG_BUTTON, "O botão contendo \""+choice.getText()+"\" foi pressionado.");
        String backgroundAnswerColor;

        backgroundAnswerColor =
                choice.getText().equals(this.getCorrectChoice())?
                        "green":"red";

        activityGameQuizBinding.progressBar.setProgress(activityGameQuizBinding.progressBar.getProgress()+10);
        choice.setBackgroundColor(Color.parseColor(backgroundAnswerColor));
    }

    private void setButtonListeners() {
        this.activityGameQuizBinding.firstChoice.setOnClickListener(this);
        this.activityGameQuizBinding.secondChoice.setOnClickListener(this);
        this.activityGameQuizBinding.thirdChoice.setOnClickListener(this);
        this.activityGameQuizBinding.fourthChoice.setOnClickListener(this);
    }

    private void changeQuestionTitleAndChoices(String questionTitle, String[] textChoices) {
        this.activityGameQuizBinding.question.setText(questionTitle);
        this.activityGameQuizBinding.firstChoice.setText(textChoices[0]);
        this.activityGameQuizBinding.secondChoice.setText(textChoices[1]);
        this.activityGameQuizBinding.thirdChoice.setText(textChoices[2]);
        this.activityGameQuizBinding.fourthChoice.setText(textChoices[3]);
    }
}
