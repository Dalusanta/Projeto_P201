package projetoP201;

import java.util.ArrayList;

public class Lista {
    ArrayList<Tarefa> taskList;
    
    public Lista() {
        this.taskList = new ArrayList<>();
    }
    public void adicionar(String titulo, String descricao) {
        taskList.add(new Tarefa(taskList.size(), titulo, descricao));
    }
    
    private boolean withinList(String length) {
        if (Integer.parseInt(length) >= 0 && Integer.parseInt(length) < taskList.size()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void mudarTitulo(String index, String newTitulo) {
        if (withinList(index)) {
            taskList.get(Integer.parseInt(index)).changeTitulo(newTitulo);
        }
    }
    
    public void mudarDesccricao(String index, String newDescricao) {
        if (withinList(index)) {
            taskList.get(Integer.parseInt(index)).changeDescricao(newDescricao);
        }
    }
    
    public void remover(String index) {
        if (withinList(index)) {
            taskList.remove(Integer.parseInt(index));
        }
    }
    
    public void concluir(String index) {
        if (withinList(index)) {
            taskList.get(Integer.parseInt(index)).turnTrue();
        }
    }
    
    public boolean emptyList() {
        return taskList.isEmpty();
    }
    
    public boolean hasSpecificTasks(int tipo) {
        if (tipo == 1) {
            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getState() == false) {
                    return true;
                }
            }
        } else if (tipo == 2) {
            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getState() == true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void showTituloFromTheList() {
        for(int i = 0; i < taskList.size(); i++) {
            System.out.println(taskList.get(i).getId()+". "+taskList.get(i).getTitulo()+" ("+taskList.get(i).getState()+")");
        }
    }
    
    public void showDescricaoDoTitulo(int id) {
        System.out.println(taskList.get(id).getDescricao());
    }
    
    /*
    public void showList(String escolha) {
        switch (escolha) {
            case "1":
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.println(i+1+". "+taskList.get(i).getName()+" ("+taskList.get(i).getState()+")");
                }
                break;
            case "2":
                if (hasSpecificTasks(1)) {
                    for (int i = 0; i < taskList.size(); i++) {
                        if (taskList.get(i).getState() == false) {
                            System.out.println(i+1+". "+taskList.get(i).getName());
                        }
                    }
                } else {
                    System.out.println("Nada na lista de pedente(s)");
                }
                break;
            case "3":
                if (hasSpecificTasks(2)) {
                    for (int i = 0; i < taskList.size(); i++) {
                        if (taskList.get(i).getState() == true) {
                            System.out.println(i+1+". "+taskList.get(i).getName());
                        }
                    }
                } else {
                    System.out.println("Nada na lista de concluido(s)");
                }
                break;
            default:
                System.out.println("Opção inválida");
        }
    
    }*/
}