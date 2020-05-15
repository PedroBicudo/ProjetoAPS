package apps.learn.projetoaps.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.data.model.Jogador;
import apps.learn.projetoaps.data.model.Pergunta;
import apps.learn.projetoaps.data.model.Quiz;
import io.reactivex.Observable;

@Dao
public interface QuestoesDAO {

    @Insert
    void insertNewScore(Jogador jogador);

    @Query("SELECT * FROM PERGUNTAS where ID_PERGUNTA IN (:id)")
    LiveData<List<Quiz>> getPerguntasByIds(int[] id);

    @Query("SELECT * FROM ALTERNATIVAS where ALTERNATIVAS.ID_PERGUNTA = :id")
    LiveData<List<Alternativa>> getAlternativasById(int id);

}
