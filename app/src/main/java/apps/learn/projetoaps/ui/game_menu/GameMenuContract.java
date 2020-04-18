package apps.learn.projetoaps.ui.game_menu;

import java.util.Stack;

import apps.learn.projetoaps.data.model.Pergunta;

public interface GameMenuContract {

    interface View extends android.view.View.OnClickListener {
        void showProgressBar();
        void disableStartGameButton();
        void openQuizActivity(Stack<Pergunta> perguntas);
    }

    interface Presenter {
        void startGameEvent();
    }
}
