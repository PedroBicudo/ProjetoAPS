package apps.learn.projetoaps.ui.game_score;

import android.graphics.ComposePathEffect;
import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import apps.learn.projetoaps.data.database.AppDatabase;
import apps.learn.projetoaps.data.model.Jogador;
import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;
import apps.learn.projetoaps.ui.adapter.PlayersViewAdapter;
import apps.learn.projetoaps.util.QuizRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class GameScorePresenter implements GameScoreContract.Presenter {

    private static final String TAG = "GameScorePresenter";
    private PlayersViewAdapter playersViewAdapter;
    private GameScoreActivity gameScoreActivity;
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    public GameScorePresenter(GameScoreActivity gameScoreActivity) {
        this.gameScoreActivity = gameScoreActivity;
    }

    // TODO - Fazer acesso ao repositório
    @Override
    public void addNewPlayer() {
        String name = gameScoreActivity.getPlayerName();
        int score = gameScoreActivity.getPlayerScore();
        if (name.isEmpty()) {
            Log.i(TAG, "adicionarNovoJogador: Nome vazio, saindo...");
            return;
        }
        QuizRepository quizRepository = new QuizRepository(this.gameScoreActivity);
        quizRepository.insertNewScore(name, score);
        reloadPlayerList();
    }

    @Override
    public void loadPlayerList(List<Jogador> jogadores) {
        playersViewAdapter = new PlayersViewAdapter(new ArrayList<>(jogadores));
        gameScoreActivity.setProgressBarGone();
        gameScoreActivity.populateRecyclerView(playersViewAdapter);
    }

    @Override
    public void getQuizJogadores() {
        this.gameScoreActivity.setProgressBarVisible();
        QuizRepository quizRepository = new QuizRepository(this.gameScoreActivity);
        quizRepository.getAllJogadores()
                .observe(this.gameScoreActivity, new Observer<List<Jogador>>() {
                    @Override
                    public void onChanged(List<Jogador> jogadors) {
                        loadPlayerList(jogadors);
                    }
                });
    }

    @Override
    public void reloadPlayerList() {
        getQuizJogadores();
    }

    @Override
    public void loadQuizQuestions() {
        QuizRepository quizRepository = new QuizRepository(this.gameScoreActivity);
        int[] a = {1, 2, 3, 5};
        quizRepository.getQuizQuestions(a)
                .observe(this.gameScoreActivity, new Observer<List<Quiz>>() {
                    @Override
                    public void onChanged(List<Quiz> quizzes) {
                        restartGameEvent(quizzes);
                    }
                });
    }

    @Override
    public void restartGameEvent(List<Quiz> quizzes) {
        this.gameScoreActivity.setProgressBarGone();
        this.gameScoreActivity.openGameQuizActivity(new ArrayList<Quiz>(quizzes));
    }

}
