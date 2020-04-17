package apps.learn.projetoaps.ui.game_menu;

import java.util.Stack;

import apps.learn.projetoaps.data.model.Pergunta;

public interface GameMenuContract {

    interface GameMenuView {
        void hideStarButton();
        void hideProgressBar();
        void showProgressBar();
    }

    interface GameMenuPresenter {
        Stack<Pergunta> getPerguntasFromDatabase();
        void openQuizActivity(Stack<Pergunta> perguntas);
    }
}
