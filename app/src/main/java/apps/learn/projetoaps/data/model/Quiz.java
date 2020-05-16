package apps.learn.projetoaps.data.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import org.parceler.Parcel;
import org.parceler.ParcelPropertyConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Parcel
public class Quiz {

    @Embedded
    private Pergunta pergunta;

    @ParcelPropertyConverter(QuizAlternativasParcelConverter.class)
    @Relation(parentColumn = "ID_PERGUNTA", entityColumn = "ID_PERGUNTA")
    private List<Alternativa> alternativas;

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public List<Alternativa> getAlternativas() {
        List<String> lista = Arrays.asList("0", "1", "2", "3");
        Collections.shuffle(lista);
        ArrayList<Alternativa> retorno = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            retorno.add(this.alternativas.get(Integer.parseInt(lista.get(i))));
        }

        return retorno;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
}
