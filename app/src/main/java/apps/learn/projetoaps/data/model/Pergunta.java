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

    @Ignore
    private Alternativa alternativas[] = new Alternativa[4];

    public void setIdPergunta(int idPergunta){ this.idPergunta = idPergunta; }

    public int getIdPergunta() { return idPergunta; }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public void setAlternativas(Alternativa alternativas[]) {
        this.alternativas = alternativas;
    }

    public Alternativa[] getAlternativas() {
        List<String> lista = Arrays.asList("0", "1", "2", "3");
        Collections.shuffle(lista);
        Alternativa retorno[] = new Alternativa[4];

        for (int i = 0; i < 4; i++) {
            retorno[i] = this.alternativas[Integer.parseInt(lista.get(i))];
        }

        return retorno;
    }
}
