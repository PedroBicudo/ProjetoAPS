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
        Alternativa alternativa = (Alternativa) button.getTag(button.getId());
        String color = alternativa.getCorreta()? "green": "red";
        this.gameQuizActivity.changeButtonColor(button, color);
    }

    @Override
    public void verificarEscolhaEMudarPergunta(Button button) {
        isAlternativaCorreta(button);
        changeCurrentPergunta();
    }
}
