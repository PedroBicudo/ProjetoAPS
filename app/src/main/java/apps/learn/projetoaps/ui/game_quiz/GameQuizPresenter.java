package apps.learn.projetoaps.ui.game_quiz;

import android.util.Log;
import android.widget.Button;

import java.util.Stack;

import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.data.model.Pergunta;

public class GameQuizPresenter implements GameQuizContract.Presenter {

    private GameQuizActivity gameQuizActivity;
    private Stack<Pergunta> perguntas;
    private int score;

    public GameQuizActivity getGameQuizActivity() {
        return gameQuizActivity;
    }

    public void setGameQuizActivity(GameQuizActivity gameQuizActivity) {
        this.gameQuizActivity = gameQuizActivity;
    }

    public Stack<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(Stack<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public GameQuizPresenter(GameQuizActivity gameQuizActivity, Stack<Pergunta> perguntas) {
        this.setGameQuizActivity(gameQuizActivity);
        this.setPerguntas(perguntas);
        this.setScore(0);
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
