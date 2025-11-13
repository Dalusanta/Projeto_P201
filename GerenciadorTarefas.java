import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorTarefas {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Tarefa> listaTarefas = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = Integer.parseInt(scan.nextLine());

            switch (opcao) {
                case 1: adicionarTarefa(); break;
                case 2: removerTarefa(); break;
                case 3: listarTarefas(); break;
                case 4: editarStatusTarefa(); break;
                case 5:
                    System.out.println("Saindo do gerenciador. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("\n--- GERENCIADOR DE TAREFAS ---\n" +
                           "1. Adicionar Tarefa\n" +
                           "2. Remover Tarefa\n" +
                           "3. Listar Tarefas\n" +
                           "4. Editar Status da Tarefa\n" +
                           "5. Sair\n" +
                           "Escolha uma opção: ");
    }

    public static void adicionarTarefa() {
        System.out.println("\n== Adicionar Tarefa ==");
        System.out.print("Título: ");
        String titulo = scan.nextLine();
        System.out.print("Descrição: ");
        String descricao = scan.nextLine();
        System.out.print("Tipo da Tarefa (1 - Prioridade, 2 - Prazo): ");
        int tipo = Integer.parseInt(scan.nextLine());

        Tarefa novaTarefa;

        if (tipo == 1) {
            System.out.print("Digite a Prioridade (1 a 5, 1 = maior): ");
            int prioridade = Integer.parseInt(scan.nextLine());
            
            if(prioridade < 1) prioridade = 1;
            if(prioridade > 5) prioridade = 5;

            novaTarefa = new TarefaPrioridade(titulo, descricao, prioridade);
        } else {
            System.out.print("Digite a data do prazo (ex: DD/MM/AAAA): ");
            String data = scan.nextLine();
            
            novaTarefa = new TarefaPrazo(titulo, descricao, data);
        }

        novaTarefa.setId(listaTarefas.size());
        listaTarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso! (ID: " + novaTarefa.getId() + ")");
    }

    public static void removerTarefa() {
        System.out.println("\n== Remover Tarefa ==");
        System.out.print("Digite o ID da tarefa a ser removida: ");
        int id = Integer.parseInt(scan.nextLine());

        if (id >= 0 && id < listaTarefas.size()) {
            listaTarefas.remove(id);
            System.out.println("Tarefa removida com sucesso.");
            
            for (int i = 0; i < listaTarefas.size(); i++) {
                listaTarefas.get(i).setId(i);
            }
            System.out.println("IDs das tarefas restantes foram atualizados.");
            
        } else {
            System.out.println("ID inválido! Nenhuma tarefa encontrada com esse ID.");
        }
    }

    public static void listarTarefas() {
        System.out.println("\n== Lista de Tarefas ==");
        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        
        for (Tarefa t : listaTarefas) {
            System.out.println(t);
        }
    }

    public static void editarStatusTarefa() {
        System.out.println("\n== Editar Status da Tarefa ==");
        System.out.print("Digite o ID da tarefa para alterar o status: ");
        int id = Integer.parseInt(scan.nextLine());

        if (id >= 0 && id < listaTarefas.size()) {
            Tarefa tarefa = listaTarefas.get(id);
            
            System.out.println("Tarefa: " + tarefa.getTitulo());
            System.out.println("Status atual: " + (tarefa.isConcluido() ? "Concluída" : "Pendente"));
            
            System.out.print("Mudar status para (1 - Concluída, 2 - Pendente): ");
            int status = Integer.parseInt(scan.nextLine());
            
            if (status == 1) {
                tarefa.setConcluido(true);
                System.out.println("Status alterado para: Concluída");
            } else if (status == 2) {
                tarefa.setConcluido(false);
                System.out.println("Status alterado para: Pendente");
            } else {
                System.out.println("Opção de status inválida.");
            }

        } else {
            System.out.println("ID inválido! Nenhuma tarefa encontrada com esse ID.");
        }
    }
}