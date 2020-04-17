package apps.learn.projetoaps.ui.game_menu;

import java.util.Stack;

import apps.learn.projetoaps.data.model.Pergunta;

public interface GameMenuContract {

    interface View {
        void hideStarButton();
        void hideProgressBar();
        void showProgressBar();
    }

    interface Presenter {
        Stack<Pergunta> getPerguntasFromDatabase();
        void openQuizActivity(Stack<Pergunta> perguntas);
    }
}
