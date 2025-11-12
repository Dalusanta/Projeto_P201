package projetoP201;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        boolean verdade = true;
        
        System.out.println("Lista to-do: ");
        while(verdade) {
            System.out.println("");
            System.out.println("(1) - Ver a lista");
            System.out.println("(2) - Adicionar a lista");
            System.out.println("(3) - Mudar elemento da lista");
            System.out.println("(4) - Marcar como concluído");
            System.out.println("(5) - Remover da lista");
            System.out.println("(6) - Sair");
            String escolha = scanner.nextLine();
            
            switch(escolha) {
                case "1":
                    if (!lista.emptyList()) {
                        System.out.println("(1) - Lista geral;");
                        System.out.println("(2) - Lista de pedencia(s)");
                        System.out.println("(3) - Lista de concluído(s)");
                        lista.showList(scanner.nextLine());
                    } else {
                        System.out.println("Lista vazia");
                    }
                    break;
                case "2":
                    System.out.print("O que voce quer adicionar: ");
                    lista.adicionar(scanner.nextLine());
                    break;
                case "3":
                    if (!lista.emptyList()) {
                        lista.showList("1");
                        System.out.print("Qual item voce quer alterar: ");
                        String index = scanner.nextLine();
                        System.out.print("Para que voce quer mudar: ");
                        lista.mudar(index, scanner.nextLine());
                    } else {
                        System.out.println("Lista vazia, não há o que mudar");
                    }
                    break;
                case "4":
                    if (lista.hasSpecificTasks(1)) {
                        lista.showList("2");
                        System.out.print("Qual voce concluiu: ");
                        lista.concluir(scanner.nextLine());
                    } else {
                        System.out.println("Nada na lista de pedencia");
                    }
                    break;
                case "5":
                    lista.showList("1");
                    if (!lista.emptyList()) {
                        System.out.print("Qual voce quer remover: ");
                        lista.remover(scanner.nextLine());
                    }
                    break;
                case "6":
                    verdade = false;
                    break;
                default:
                    System.out.println("Nada foi selecionado");
            }
        }
    }
}