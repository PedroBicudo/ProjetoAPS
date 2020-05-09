package apps.learn.projetoaps.ui.game_quiz;

import apps.learn.projetoaps.data.model.Alternativa;

public interface GameQuizContract {

    interface View {
        void changePergunta(String title);
        void changeAlternativas(Alternativa[] alternativas);
    }

    interface Presenter {}
}
