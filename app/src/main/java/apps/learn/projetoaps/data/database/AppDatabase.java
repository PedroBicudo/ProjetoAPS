package apps.learn.projetoaps.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import apps.learn.projetoaps.data.model.Alternativa;
import apps.learn.projetoaps.data.model.Jogador;
import apps.learn.projetoaps.data.model.Pergunta;

@Database(entities = {Alternativa.class, Pergunta.class, Jogador.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "APS65.db";
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    AppDatabase.class,
                    DB_NAME)
                    .createFromAsset("database/APS.db")
                    .build();
        }
        return instance;
    }
    public abstract QuestoesDAO questoesDAO();
}
