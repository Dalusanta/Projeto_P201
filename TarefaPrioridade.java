public class TarefaPrioridade extends Tarefa {
    
    private int prioridade; 
    
    public TarefaPrioridade(String titulo, String descricao, int prioridade) throws PrioridadeException {
        super(titulo, descricao); 
        this.tipo = true; 
        setPrioridade(prioridade); 
    }

    public void setPrioridade(int prioridade) throws PrioridadeException {
        if (prioridade < 1 || prioridade > 5) {
            throw new PrioridadeException("A prioridade deve ser um número entre 1 e 5.");
        }
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return super.toString() + " | Prioridade: " + this.prioridade;
    }
}
