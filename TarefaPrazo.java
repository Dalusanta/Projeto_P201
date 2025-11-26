public class TarefaPrazo extends Tarefa {
    
    private String dataPrazo; 

    public TarefaPrazo(String titulo, String descricao, String dataPrazo) {
        super(titulo, descricao); 
        this.tipo = false; 
        this.dataPrazo = dataPrazo;
    }

    public void setDataPrazo(String dataPrazo) {
        this.dataPrazo = dataPrazo;
    }
    
    public String getDataPrazo() {
        return dataPrazo;
    }

    @Override
    public String toString() {
        return super.toString() + " | Prazo: " + this.dataPrazo;
    }
}
