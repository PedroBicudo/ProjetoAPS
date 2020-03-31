package apps.learn.projetoaps;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import apps.learn.projetoaps.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding activityMainBinding;
    private String correctChoice;

    public ActivityMainBinding getActivityMainBinding() {
        return activityMainBinding;
    }

    public void setActivityMainBinding(ActivityMainBinding activityMainBinding) {
        this.activityMainBinding = activityMainBinding;
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
        this.setActivityMainBinding(ActivityMainBinding.inflate(getLayoutInflater()));
        setContentView(this.getActivityMainBinding().getRoot());

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
        if (activityMainBinding.progressBar.getProgress() == 100) return;
        Button choice = (Button) v;
        String backgroundAnswerColor;

        backgroundAnswerColor =
                choice.getText().equals(this.getCorrectChoice())?
                        "green":"red";

        activityMainBinding.progressBar.setProgress(activityMainBinding.progressBar.getProgress()+10);
        choice.setBackgroundColor(Color.parseColor(backgroundAnswerColor));
    }

    private void setButtonListeners() {
        this.activityMainBinding.firstChoice.setOnClickListener(this);
        this.activityMainBinding.secondChoice.setOnClickListener(this);
        this.activityMainBinding.thirdChoice.setOnClickListener(this);
        this.activityMainBinding.fourthChoice.setOnClickListener(this);
    }

    private void changeQuestionTitleAndChoices(String questionTitle, String[] textChoices) {
        this.activityMainBinding.question.setText(questionTitle);
        this.activityMainBinding.firstChoice.setText(textChoices[0]);
        this.activityMainBinding.secondChoice.setText(textChoices[1]);
        this.activityMainBinding.thirdChoice.setText(textChoices[2]);
        this.activityMainBinding.fourthChoice.setText(textChoices[3]);
    }
}
