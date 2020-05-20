package apps.learn.projetoaps.ui.game_quiz;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Stack;

import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;

public class GameQuizPresenter implements GameQuizContract.Presenter {

    private GameQuizActivity gameQuizActivity;
    private CountDownTimer timer;
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
            this.timer.cancel();
            this.getGameQuizActivity().openScoreActivity(this.score);

        } else {
            startCountDownTimer();
            Quiz quiz = this.getQuizzes().pop();
            Pergunta pergunta = quiz.getPergunta();
            Alternativa[] alternativas = quiz.getAlternativas().toArray(new Alternativa[0]);
            this.getGameQuizActivity().changePergunta(pergunta.getEnunciado());
            this.getGameQuizActivity().changeAlternativas(alternativas);
        }
    }

    @Override
    public void startCountDownTimer() {
        getGameQuizActivity().changeProgressTimer(0);

        if (this.timer != null) {
            this.timer.cancel();

        } else {
            this.timer = new CountDownTimer(TIME_TO_ANSWER_MILISECONDS, INTERVAL_TIME_TO_ANSWER_MILISECONDS) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int currentPercentage = gameQuizActivity.getProgressCurrentValue();
                    gameQuizActivity.changeProgressTimer(currentPercentage + INCREMENT_PROGRESS_BAR);
                }

                @Override
                public void onFinish() {
                    changeCurrentPergunta();
                }
            };
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timer.start();
            }
        }, WAIT_TIME_START_TIMER);

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
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gameQuizActivity.resetButtonsColor();
                changeCurrentPergunta();
            }
        }, CHOICE_TIME_VISUALIZATION);

    }
}
