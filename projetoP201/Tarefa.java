package projetoP201;

public class Tarefa {
    final private int id;
    private String titulo;
    private String descricao;
    private boolean state;
    
    public Tarefa(int id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.state = false;
    }
    
    public int getId() {
        return id;
    }
    
    public boolean getState() {
        return state;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void turnTrue() {
        state = true;
    }
    
    public void changeTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void changeDescricao(String descricao) {
        this.descricao = descricao;
    }
}