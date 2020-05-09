package apps.learn.projetoaps.ui.game_quiz;

import android.util.Log;
import android.widget.Button;

import java.util.Stack;

import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.data.model.Pergunta;

public class GameQuizPresenter implements GameQuizContract.Presenter {

    private GameQuizActivity gameQuizActivity;
    private int score;

    public GameQuizPresenter(GameQuizActivity gameQuizActivity) {
        this.gameQuizActivity = gameQuizActivity;
        this.score = 0;
    }

    @Override
    public void changeCurrentPergunta() {}

    @Override
    public void isAlternativaCorreta(Button button) {
        Alternativa alternativa = (Alternativa) button.getTag(button.getId());
        String color;
        if (alternativa.getCorreta()) {
            score++;
            color = "green";

        } else {
            color = "red";

        }
        this.gameQuizActivity.changeButtonColor(button, color);
    }

    @Override
    public void verificarEscolhaEMudarPergunta(Button button) {
        isAlternativaCorreta(button);
        changeCurrentPergunta();
    }
}
