package apps.learn.projetoaps.ui.game_quiz;

import android.widget.Button;

public class GameQuizPresenter implements GameQuizContract.Presenter {

    private GameQuizActivity gameQuizActivity;

    public GameQuizPresenter(GameQuizActivity gameQuizActivity) {
        this.gameQuizActivity = gameQuizActivity;
    }


    @Override
    public void changeCurrentPergunta() {
        
    }

    @Override
    public void isAlternativaCorreta(Button button) {

    }

    @Override
    public void verificarEscolhaEMudarPergunta(Button button) {

    }
}
