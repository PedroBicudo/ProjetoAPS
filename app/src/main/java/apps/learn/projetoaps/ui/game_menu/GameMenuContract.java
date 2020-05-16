package apps.learn.projetoaps.ui.game_menu;

import java.util.ArrayList;
import java.util.Stack;

import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;

public interface GameMenuContract {

    interface View extends android.view.View.OnClickListener {
        void showProgressBar();
        void disableStartGameButton();
        void openQuizActivity(ArrayList<Quiz> quizzes);
    }

    interface Presenter {
        void startGameEvent();
    }
}
