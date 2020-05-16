package apps.learn.projetoaps.ui.game_quiz;

import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Stack;

import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;

public class GameQuizPresenter implements GameQuizContract.Presenter {

    private GameQuizActivity gameQuizActivity;
    private Stack<Quiz> quizzes;
    private int score;

    public GameQuizActivity getGameQuizActivity() {
        return gameQuizActivity;
    }

    public void setGameQuizActivity(GameQuizActivity gameQuizActivity) {
        this.gameQuizActivity = gameQuizActivity;
    }

    public Stack<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(ArrayList<Quiz> quizzes) {
        Stack<Quiz> quizStack = new Stack<>();
        for (Quiz quiz: quizzes) {
            quizStack.add(quiz);
        }
        this.quizzes = quizStack;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public GameQuizPresenter(GameQuizActivity gameQuizActivity, ArrayList<Quiz> quizzes) {
        this.setGameQuizActivity(gameQuizActivity);
        this.setQuizzes(quizzes);
        this.setScore(0);
    }

    @Override
    public void changeCurrentPergunta() {
        if (this.getQuizzes().isEmpty()) {
            // TODO - Adicionar para a mudança de activities.
            int dummyScore = 100;
            this.getGameQuizActivity().openScoreActivity(dummyScore);

        } else {
            Quiz quiz = this.getQuizzes().pop();
            Pergunta pergunta = quiz.getPergunta();
            Alternativa[] alternativas = quiz.getAlternativas().toArray(new Alternativa[0]);
            this.getGameQuizActivity().changePergunta(pergunta.getEnunciado());
            this.getGameQuizActivity().changeAlternativas(alternativas);
        }
    }

    @Override
    public void isAlternativaCorreta(Button button) {
        Alternativa alternativa = (Alternativa) button.getTag(button.getId());
        String color;
        if (alternativa.isCorreta()) {
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
