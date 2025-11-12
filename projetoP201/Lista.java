package projetoP201;

import java.util.ArrayList;

public class Lista {
    ArrayList<Tarefa> taskList;
    
    public Lista() {
        this.taskList = new ArrayList<>();
    }
    public void adicionar(String tarefa) {
        taskList.add(new Tarefa(tarefa));
    }
    
    private boolean withinList(String length) {
        if (Integer.parseInt(length) > 0 && Integer.parseInt(length) <= taskList.size()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void mudar(String index, String newName) {
        if (withinList(index)) {
            taskList.get(Integer.parseInt(index)-1).changeName(newName);
        }
    }
    
    public void remover(String index) {
        if (withinList(index)) {
            taskList.remove(Integer.parseInt(index)-1);
        }
    }
    
    public void concluir(String index) {
        if (withinList(index)) {
            taskList.get(Integer.parseInt(index)-1).turnTrue();
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
    }
}