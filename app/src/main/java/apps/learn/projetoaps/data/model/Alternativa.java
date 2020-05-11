package apps.learn.projetoaps.data.model;

public class Alternativa {
    private int idPergunta;
    private String texto;
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
