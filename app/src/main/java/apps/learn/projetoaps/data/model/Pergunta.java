package apps.learn.projetoaps.data.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pergunta {
    private int idPergunta;
    private String enunciado;
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
