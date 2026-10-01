import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Tarefa> listaDeTarefas = new ArrayList<>();
        int opcao = 0;

        do {
            System.out.println("\n==================================");
            System.out.println("   SISTEMA AVANÇADO DE TAREFAS     ");
            System.out.println("==================================");
            System.out.println("1. Adicionar nova tarefa");
            System.out.println("2. Listar todas as tarefas");
            System.out.println("3. Listar apenas tarefas PENDENTES");
            System.out.println("4. Concluir tarefa");
            System.out.println("5. Remover tarefa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String desc = sc.nextLine();
                    
                    System.out.println("Escolha a prioridade (1 - BAIXA, 2 - MEDIA, 3 - ALTA): ");
                    int escolhaPrio = sc.nextInt();
                    Prioridade prio = Prioridade.BAIXA;
                    
                    if (escolhaPrio == 2) prio = Prioridade.MEDIA;
                    else if (escolhaPrio == 3) prio = Prioridade.ALTA;
                    
                    listaDeTarefas.add(new Tarefa(desc, prio));
                    System.out.println(">>> Tarefa adicionada com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- TODAS AS TAREFAS ---");
                    if (listaDeTarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (int i = 0; i < listaDeTarefas.size(); i++) {
                            System.out.println(i + " - " + listaDeTarefas.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- TAREFAS PENDENTES ---");
                    boolean temPendentes = false;
                    for (int i = 0; i < listaDeTarefas.size(); i++) {
                        Tarefa t = listaDeTarefas.get(i);
                        if (!t.isConcluida()) {
                            System.out.println(i + " - " + t);
                            temPendentes = true;
                        }
                    }
                    if (!temPendentes) {
                        System.out.println("Parabéns! Não há tarefas pendentes.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- CONCLUIR TAREFA ---");
                    if (listaDeTarefas.isEmpty()) {
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.print("Digite o número da tarefa que deseja concluir: ");
                        int indice = sc.nextInt();
                        if (indice >= 0 && indice < listaDeTarefas.size()) {
                            listaDeTarefas.get(indice).concluir();
                            System.out.println(">>> Tarefa marcada como concluída!");
                        } else {
                            System.out.println(">>> Índice inválido!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n--- REMOVER TAREFA ---");
                    if (listaDeTarefas.isEmpty()) {
                        System.out.println("A lista está vazia.");
                    } else {
                        System.out.print("Digite o número da tarefa que deseja remover: ");
                        int indice = sc.nextInt();
                        if (indice >= 0 && indice < listaDeTarefas.size()) {
                            listaDeTarefas.remove(indice);
                            System.out.println(">>> Tarefa removida com sucesso!");
                        } else {
                            System.out.println(">>> Índice inválido!");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println(">>> Opção inválida! Escolha entre 1 e 6.");
            }

        } while (opcao != 6);

        sc.close();
    }
}