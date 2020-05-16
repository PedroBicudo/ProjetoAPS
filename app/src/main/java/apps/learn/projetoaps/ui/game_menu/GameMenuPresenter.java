package apps.learn.projetoaps.ui.game_menu;

import java.util.Stack;

import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;

public class GameMenuPresenter implements GameMenuContract.Presenter {

    private GameMenuActivity gameMenuActivity;

    public GameMenuPresenter(GameMenuActivity gameMenuActivity) {
        this.gameMenuActivity = gameMenuActivity;
    }

    // TODO - Adicionar método Util para obter perguntas do banco de dados
    @Override
    public void startGameEvent() {
        gameMenuActivity.disableStartGameButton();
        gameMenuActivity.showProgressBar();
        gameMenuActivity.openQuizActivity(new Stack<Quiz>());
    }
}
