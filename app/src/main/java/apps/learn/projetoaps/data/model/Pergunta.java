package apps.learn.projetoaps.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity(tableName = "PERGUNTAS")
public class Pergunta {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID_PERGUNTA")
    private int idPergunta;

    @NonNull
    @ColumnInfo(name = "ENUNCIADO")
    private String enunciado;

    public void setIdPergunta(int idPergunta){ this.idPergunta = idPergunta; }

    public int getIdPergunta() { return idPergunta; }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getEnunciado() {
        return this.enunciado;
    }

}
