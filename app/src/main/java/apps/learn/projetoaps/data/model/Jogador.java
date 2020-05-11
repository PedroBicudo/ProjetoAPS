package apps.learn.projetoaps.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Jogador")
public class Jogador {

    @ColumnInfo(name = "ID_Jogador")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idJogador;

    @ColumnInfo(name = "Nome")
    @NonNull
    private String nome;

    @ColumnInfo(name = "Resultado")
    @NonNull
    private int resultado;

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
