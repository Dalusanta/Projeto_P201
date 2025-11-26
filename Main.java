import java.util.Scanner;

public class Main {
    
    static Scanner scan = new Scanner(System.in);
    static GerenciadorTarefas gerenciador = new GerenciadorTarefas();

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            String input = scan.nextLine();
            
            try {
                int opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1: adicionar(); break;
                    case 2: remover(); break;
                    case 3: gerenciador.listarTarefas(); break;
                    case 4: editarStatus(); break;
                    case 5: editarDetalhes(); break;
                    case 6:
                        System.out.println("Saindo do gerenciador. Até logo!");
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números válidos para o menu.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("\n--- GERENCIADOR DE TAREFAS ---\n" +
                           "1. Adicionar Tarefa\n" +
                           "2. Remover Tarefa\n" +
                           "3. Listar Tarefas\n" +
                           "4. Editar Status\n" +
                           "5. Editar Detalhes\n" +
                           "6. Sair\n" +
                           "Escolha uma opção: ");
    }

    public static void adicionar() {
        System.out.println("\n== Adicionar Tarefa ==");
        try {
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
                novaTarefa = new TarefaPrioridade(titulo, descricao, prioridade);
            } else {
                System.out.print("Digite a data do prazo (ex: DD/MM/AAAA): ");
                String data = scan.nextLine();
                novaTarefa = new TarefaPrazo(titulo, descricao, data);
            }

            gerenciador.adicionarTarefa(novaTarefa);

        } catch (NumberFormatException e) {
            System.out.println("Erro de Entrada: Você digitou um texto/letra onde deveria ser um número.");
        } catch (PrioridadeException e) {
            System.out.println("Erro de Regra de Negócio: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    public static void remover() {
        System.out.println("\n== Remover Tarefa ==");
        System.out.print("Digite o ID da tarefa a ser removida: ");
        try {
            int id = Integer.parseInt(scan.nextLine());
            gerenciador.removerTarefa(id);
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ID deve ser um número inteiro.");
        }
    }

    public static void editarStatus() {
        System.out.println("\n== Editar Status da Tarefa ==");
        System.out.print("Digite o ID da tarefa: ");
        try {
            int id = Integer.parseInt(scan.nextLine());
            Tarefa tarefa = gerenciador.buscarTarefa(id);

            if (tarefa != null) {
                System.out.println("Tarefa: " + tarefa.getTitulo());
                System.out.println("Status atual: " + (tarefa.isConcluido() ? "Concluída" : "Pendente"));
                System.out.print("Mudar status para (1 - Concluída, 2 - Pendente): ");
                int status = Integer.parseInt(scan.nextLine());
                
                if (status == 1) tarefa.setConcluido(true);
                else if (status == 2) tarefa.setConcluido(false);
                else System.out.println("Opção inválida.");
                
                System.out.println("Status atualizado!");
            } else {
                System.out.println("ID não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida. Digite apenas números.");
        }
    }

    public static void editarDetalhes() {
        System.out.println("\n== Editar Detalhes da Tarefa ==");
        try {
            System.out.print("Digite o ID da tarefa: ");
            int id = Integer.parseInt(scan.nextLine());
            Tarefa tarefa = gerenciador.buscarTarefa(id);

            if (tarefa != null) {
                if (tarefa instanceof TarefaPrioridade) {
                    TarefaPrioridade tp = (TarefaPrioridade) tarefa;
                    System.out.println("Prioridade atual: " + tp.getPrioridade());
                    System.out.print("Nova prioridade (1-5): ");
                    int novaPrio = Integer.parseInt(scan.nextLine());
                    
                    tp.setPrioridade(novaPrio); 
                    System.out.println("Prioridade atualizada.");
                } 
                else if (tarefa instanceof TarefaPrazo) {
                    TarefaPrazo tp = (TarefaPrazo) tarefa;
                    System.out.println("Prazo atual: " + tp.getDataPrazo());
                    System.out.print("Novo prazo: ");
                    String novoPrazo = scan.nextLine();
                    tp.setDataPrazo(novoPrazo);
                    System.out.println("Prazo atualizado.");
                }
            } else {
                System.out.println("ID não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite apenas números para ID ou Prioridade.");
        } catch (PrioridadeException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
}