public class TarefaPrazo extends Tarefa {
    
    protected String dataPrazo; 

    public TarefaPrazo(String titulo, String descricao, String dataPrazo) {
        super(titulo, descricao); 
        this.tipo = false; 
        this.dataPrazo = dataPrazo;
    }

    @Override
    public String toString() {
        return super.toString() + " | Prazo: " + this.dataPrazo;
    }
}