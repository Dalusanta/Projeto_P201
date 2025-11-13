public class TarefaPrioridade extends Tarefa {
    int prioridade;
    
    public TarefaPrioridade(String titulo, String descricao, int prioridade) {
        super(titulo, descricao); 
        this.prioridade = prioridade;
        this.tipo = true; 
    }

    @Override
    public String toString() {
        return super.toString() + " | Prioridade: " + this.prioridade;
    }
}