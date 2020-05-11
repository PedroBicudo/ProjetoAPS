package apps.learn.projetoaps.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Alternativas")
public class Alternativa {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "ID_Enunciado")
    private int idPergunta;

    @ColumnInfo(name = "Alternativas")
    private String texto;

    @ColumnInfo(name = "Correta")
    private int correta;

    public void setIdPergunta(int idPergunta) { this.idPergunta = idPergunta;}

    public int getIdPergunta() {return this.idPergunta;}

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getTexto(){
        return this.texto;
    }

    public void setCorreta(int correta) {
        this.correta = correta;
    }
    public boolean isCorreta(){
        boolean retorno;
        if (correta == 0){
            retorno = false;
        } else {
            retorno = true;
        }
        return retorno;
    }
}
