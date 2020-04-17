package apps.learn.projetoaps.ui.main;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import apps.learn.projetoaps.databinding.ActivityMainBinding;
import apps.learn.projetoaps.data.database.CriaBanco;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static final private String TAG_BUTTON = "choiceButton";
    private ActivityMainBinding activityMainBinding;
    private String correctChoice;
    CriaBanco db;


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

        db = new CriaBanco(this);

        ArrayList<Integer> resultDB = new ArrayList<>();

        ArrayList alt = db.gerarPergunta();

        Log.v("Banco", String.valueOf(alt));
        // Dummy values para demonstração
        correctChoice = "A";
        String[] choices = {"A", "B", "C", "D"};
        String enunciado = "Pergunta de teste?";

        this.setButtonListeners();
        this.changeQuestionTitleAndChoices(enunciado, choices);
    }

    @Override
    public void onClick(View v) {
        if (!(v instanceof Button)) return;
        if (activityMainBinding.progressBar.getProgress() == 100) return;
        Button choice = (Button) v;

        Log.i(TAG_BUTTON, "O botão contendo \""+choice.getText()+"\" foi pressionado.");
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
