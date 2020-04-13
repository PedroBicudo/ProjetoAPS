package apps.learn.projetoaps.data.model;

public class Alternativa {
    private String texto;
    private boolean correta;

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getTexto(){
        return this.texto;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
    public boolean getCorreta(){
        return this.correta;
    }
}
