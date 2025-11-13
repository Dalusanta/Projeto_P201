public abstract class Tarefa {
    protected int id;
    protected String titulo;
    protected String descricao;
    protected boolean concluido;
    protected boolean tipo; // False = prazo e true = prioridade

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluido = false; 
    }

    public int getId() { 
        return id; 
    }
    public String getTitulo() {
        return titulo; 
    }
    public String getDescricao() { 
        return descricao; 
    }
    public boolean isConcluido() {
        return concluido;
    }
    public String getTipoStr() {
        return tipo ? "Prioridade" : "Prazo";
    }

    public void setId(int id) { this.id = id; }
    public void setConcluido(boolean concluido) { this.concluido = concluido; }

    @Override
    public String toString() {
        String status = concluido ? "Concluída" : "Pendente";
        return "ID: " + id + " | Tipo: " + getTipoStr() + " | Título: " + titulo + " | Descrição: " + descricao + " | Status: " + status;
    }
}