package apps.learn.projetoaps;

public class Pergunta {
    private String enunciado;
    private Alternativa alternativas[] = new Alternativa[4];

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
        return this.alternativas;
    }
}
