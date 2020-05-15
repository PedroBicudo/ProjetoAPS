package apps.learn.projetoaps.util;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import apps.learn.projetoaps.data.database.AppDatabase;
import apps.learn.projetoaps.data.database.QuestoesDAO;
import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.data.model.Jogador;
import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;

public class QuizRepository{

    private AppDatabase database;

    private QuestoesDAO questoesDAO;

    private List<String> QuizAlternativas = new ArrayList<>();
    private List<String> QuizPerguntas = new ArrayList<>();

    public QuizRepository(Context context){
        database = AppDatabase.getInstance(context.getApplicationContext());
    }

    public void insertNewScore(String name, int point) {
        Jogador jogador = new Jogador();
        jogador.setNome(name);
        jogador.setResultado(point);
        questoesDAO.insertNewScore(jogador);
    }

    public LiveData<List<Quiz>> getQuizQuestions(int[] id) {
        return database.questoesDAO().getPerguntasByIds(id);
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
