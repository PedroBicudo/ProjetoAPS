package apps.learn.projetoaps.ui.game_quiz;

import android.view.View;
import android.widget.Button;

import apps.learn.projetoaps.data.model.Alternativa;

public interface GameQuizContract {

    interface View extends android.view.View.OnClickListener {
        void changePergunta(String title);
        void changeAlternativas(Alternativa[] alternativas);
        void changeButtonColor(Button button, String color);
        void resetButtonsColor();
        void openScoreActivity(int score);
    }

    interface Presenter {
        int CHOICE_TIME_VISUALIZATION = 300;
        void changeCurrentPergunta();
        void isAlternativaCorreta(Button button);
        void verificarEscolhaEMudarPergunta(Button button);
    }
}
