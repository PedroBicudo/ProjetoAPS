package apps.learn.projetoaps.ui.game_score;
import android.app.AlertDialog;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;
import apps.learn.projetoaps.ui.adapter.PlayersViewAdapter;

public interface GameScoreContract {

    interface View extends android.view.View.OnClickListener {
        AlertDialog getAlertDialog();
        String getPlayerName();
        void setProgressBarGone();
        void setProgressBarVisible();
        void populateRecyclerView(PlayersViewAdapter playersViewAdapter);
        void openGameQuizActivity(ArrayList<Quiz> quizzes);
    }

    interface Presenter {
        void addNewPlayer();
        void loadPlayerList();
        void reloadPlayerList();
        void restartGameEvent(List<Quiz> quizzes);
        void loadQuizQuestions();
    }

}
