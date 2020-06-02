package apps.learn.projetoaps.ui.game_quiz;

import android.view.View;
import android.widget.Button;

import apps.learn.projetoaps.data.model.Alternativa;

public interface GameQuizContract {

    interface View extends android.view.View.OnClickListener {
        void changePergunta(String title);
        void changeAlternativas(Alternativa[] alternativas);
        void changeButtonColor(Button button, String color);
        void changeProgressTimer(int progress);
        int getProgressCurrentValue();
        void resetButtonsColor();
        void openScoreActivity(int score);
    }

    interface Presenter {
        int CHOICE_TIME_VISUALIZATION = 300;
        int TIME_TO_ANSWER_MILISECONDS = 10000;
        int INTERVAL_TIME_TO_ANSWER_MILISECONDS = 1000;
        int INCREMENT_PROGRESS_BAR = 10;
        void changeCurrentPergunta();
        void startCountDownTimer();
        void isAlternativaCorreta(Button button);
        void verificarEscolhaEMudarPergunta(Button button);
    }
}
