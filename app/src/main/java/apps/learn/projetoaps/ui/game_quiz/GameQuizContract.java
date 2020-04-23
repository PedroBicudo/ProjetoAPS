package apps.learn.projetoaps.ui.game_quiz;

import android.widget.Button;

import apps.learn.projetoaps.data.model.Alternativa;

public interface GameQuizContract {

    interface View {
        void changeQuestionWording(String title);
        void changeChoiceButton(Button button, Alternativa alternativa);
    }

    interface Presenter {}
}
