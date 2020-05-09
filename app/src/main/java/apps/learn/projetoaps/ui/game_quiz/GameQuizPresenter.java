package apps.learn.projetoaps.ui.game_quiz;

import android.util.Log;
import android.widget.Button;

import apps.learn.projetoaps.data.model.Alternativa;

public class GameQuizPresenter implements GameQuizContract.Presenter {

    private GameQuizActivity gameQuizActivity;

    public GameQuizPresenter(GameQuizActivity gameQuizActivity) {
        this.gameQuizActivity = gameQuizActivity;
    }


    @Override
    public void changeCurrentPergunta() {}

    @Override
    public void isAlternativaCorreta(Button button) {

    }

    @Override
    public void verificarEscolhaEMudarPergunta(Button button) {
        isAlternativaCorreta(button);
        changeCurrentPergunta();
    }
}
