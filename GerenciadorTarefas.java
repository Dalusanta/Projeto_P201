import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {

    private List<Tarefa> listaTarefas;

    public GerenciadorTarefas() {
        this.listaTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefa.setId(listaTarefas.size());
        listaTarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso! (ID: " + tarefa.getId() + ")");
    }

    public void removerTarefa(int id) {
        if (id >= 0 && id < listaTarefas.size()) {
            listaTarefas.remove(id);
            System.out.println("Tarefa removida com sucesso.");
            atualizarIds();
        } else {
            System.out.println("ID inválido! Nenhuma tarefa encontrada com esse ID.");
        }
    }

    private void atualizarIds() {
        for (int i = 0; i < listaTarefas.size(); i++) {
            listaTarefas.get(i).setId(i);
        }
        System.out.println("IDs das tarefas restantes foram atualizados.");
    }

    public void listarTarefas() {
        System.out.println("\n== Lista de Tarefas ==");
        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        for (Tarefa t : listaTarefas) {
            System.out.println(t);
        }
    }

    public Tarefa buscarTarefa(int id) {
        if (id >= 0 && id < listaTarefas.size()) {
            return listaTarefas.get(id);
        }
        return null;
    }
}
