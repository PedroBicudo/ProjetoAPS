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

            }
        });
    }

    public LiveData<List<Quiz>> getQuizQuestions(int[] id) {
        return database.questoesDAO().getPerguntasByIds(id);
    }

    public LiveData<List<Jogador>> getAllJogador(Context context){
        AppDatabase.getInstance(context).questoesDAO().getAllJogadores()
                .observe((LifecycleOwner) context, new Observer<List<Jogador>>() {
                    @Override
                    public void onChanged(List<Jogador> jogadors) {
                        if (jogadors.size() == 0){
                            Log.d("InsertandoQuery", "Ta vazio!!!");
                        }else {
                            Log.d("InsertandoQuery", jogadors.get(0).getNome());
                        }
                    }
                });
        return null;
    }

    public List<String> getQuizAlternativas(Context context, int[] id) {
        AppDatabase.getInstance(context).questoesDAO().getAlternativasById(id[0])
                .observeForever(new Observer<List<Alternativa>>() {
                    @Override
                    public void onChanged(List<Alternativa> alternativas) {
                        Log.d("TestandoAlternativas", "onChanged: "+alternativas.get(0).getTexto());
                        QuizAlternativas.add(alternativas.get(0).getTexto());
                        Log.d("TestandoAlternativas", String.valueOf(QuizAlternativas));
                    }
                });
        return QuizAlternativas;
    }

    public int[] getRandomizedIds(){
        Random random = new Random();
        int[] id = new int[10];
        int parametro = 0;
        int i = 0;
        while (i != 10){
            int num = random.nextInt(100) + 1;
            if (parametro == 0){
                id[i] = num;
            }
            while (contains(num, id) == true && parametro !=0){
                num = random.nextInt(100) + 1;
            }
            id[i] = num;
            parametro += 1;
            i ++;
        }
        return id;
    }

    private boolean contains(int elemento, int[] a){
        for (int num : a) {
            if(num==elemento){
                return true;
            }
        }
        return false;
    }

}
