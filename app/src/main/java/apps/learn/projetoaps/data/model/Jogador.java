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
    public int id_jogador;

    @ColumnInfo(name = "Nome")
    @NonNull
    public String nome;

    @ColumnInfo(name = "Resultado")
    @NonNull
    public int resultado;

    public int getId_jogador() {
        return id_jogador;
    }

    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

}
