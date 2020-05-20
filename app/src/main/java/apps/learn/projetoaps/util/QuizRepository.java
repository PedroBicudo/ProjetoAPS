package apps.learn.projetoaps.util;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import apps.learn.projetoaps.data.database.AppDatabase;
import apps.learn.projetoaps.data.database.QuestoesDAO;
import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.data.model.Jogador;
import apps.learn.projetoaps.data.model.Quiz;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class QuizRepository{

    private AppDatabase database;

    private QuestoesDAO questoesDAO;


    private List<String> QuizAlternativas = new ArrayList<>();
    private List<String> QuizPerguntas = new ArrayList<>();

    public QuizRepository(Context context){
        database = AppDatabase.getInstance(context.getApplicationContext());
    }

    public void insertNewScore(final String name, final int point) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                Jogador jogador = new Jogador();
                jogador.setNome(name);
                Log.d("InsertandoName", name);
                jogador.setResultado(point);
                Log.d("InsertandoResultado", String.valueOf(point));
                database.questoesDAO().insertNewScore(jogador);
            }
        }).observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("InsertandoSubscrito", String.valueOf(d));
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("DUMMY", "onError: "+e.getMessage());
            }
        });
    }

    public LiveData<List<Quiz>> getQuizQuestions(int[] id) {
        return database.questoesDAO().getPerguntasByIds(id);
    }

    public LiveData<List<Jogador>> getAllJogadores(){
        return database.questoesDAO().getAllJogadores();
    }

    public int[] getRandomizedIds(){
        Random random = new Random();
        List<Integer> ids = new ArrayList<>(10);

        while (ids.size() != 10) {
            int randomId = random.nextInt(100) + 1;
            if (!ids.contains(randomId)) {
                ids.add(randomId);
            }
        }
        int[] result = new int[10];

        for (int pos=0; pos < 10; pos++) {
            result[pos] = ids.get(pos);
        }

        return result;
    }

}
