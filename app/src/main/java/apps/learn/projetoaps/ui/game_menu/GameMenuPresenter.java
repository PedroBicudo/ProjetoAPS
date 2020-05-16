package apps.learn.projetoaps.ui.game_menu;

import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;
import apps.learn.projetoaps.util.QuizRepository;

public class GameMenuPresenter implements GameMenuContract.Presenter {

    private GameMenuActivity gameMenuActivity;

    public GameMenuPresenter(GameMenuActivity gameMenuActivity) {
        this.gameMenuActivity = gameMenuActivity;
    }

    @Override
    public void loadQuizQuestions() {
        QuizRepository quizRepository = new QuizRepository(this.gameMenuActivity);
        int[] a = {1, 2, 3};
        quizRepository.getQuizQuestions(a)
                .observe(this.gameMenuActivity, new Observer<List<Quiz>>() {
                    @Override
                    public void onChanged(List<Quiz> quizzes) {
                        startGameEvent(quizzes);
                    }
                });
    }

    @Override
    public void startGameEvent(List<Quiz> quizzes) {
        gameMenuActivity.disableStartGameButton();
        gameMenuActivity.showProgressBar();
        gameMenuActivity.openQuizActivity(new ArrayList<Quiz>(quizzes));
    }

}
