package apps.learn.projetoaps.ui.game_quiz;

import android.widget.Button;

import apps.learn.projetoaps.data.model.Alternativa;

public interface GameQuizContract {

    interface View {
        void changePergunta(String title);
        void changeAlternativas(Alternativa[] alternativas);
        void changeButtonColor(Button button, String color);
        void resetButtonsColor();
        void openScoreActivity(int score);
    }

    interface Presenter {
        void changeCurrentPergunta();
        void isAlternativaCorreta(Button button);
    }
}
