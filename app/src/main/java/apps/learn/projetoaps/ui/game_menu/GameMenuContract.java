package apps.learn.projetoaps.ui.game_menu;

import java.util.Stack;

import apps.learn.projetoaps.data.model.Pergunta;

public interface GameMenuContract {

    interface View {
        void hideStartButton();
        void showProgressBar();
    }

    interface Presenter extends android.view.View.OnClickListener {
        Stack<Pergunta> getPerguntasFromDatabase();
        void openQuizActivity(Stack<Pergunta> perguntas);
    }
}
