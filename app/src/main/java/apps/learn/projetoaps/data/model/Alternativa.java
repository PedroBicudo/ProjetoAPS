package apps.learn.projetoaps.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.parceler.Parcel;

@Parcel
@Entity(tableName = "ALTERNATIVAS", primaryKeys = {"ID_ALTERNATIVA", "ID_PERGUNTA"})
public class Alternativa {

    @ColumnInfo(name = "ID_ALTERNATIVA")
    public int idAlternativa;

    @NonNull
    @ColumnInfo(name = "ID_PERGUNTA")
    private int idPergunta;


    @NonNull
    @ColumnInfo(name = "TEXTO")
    private String texto;

    @NonNull
    @ColumnInfo(name = "CORRETA")
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

    public int getCorreta() {
        return correta;
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
