package projetoP201;

public class Tarefa {
    private String name;
    private boolean state;
    
    public Tarefa(String name) {
        this.name = name;
        this.state = false;
    }
    
    public boolean getState() {
        return state;
    }
    
    public String getName() {
        return name;
    }
    
    public void turnTrue() {
        state = true;
    }
    
    public void changeName(String name) {
        this.name = name;
    }
}