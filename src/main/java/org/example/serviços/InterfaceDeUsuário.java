package org.example.serviços;

import java.util.Scanner;

import org.example.modelos.Contato;

public class InterfaceDeUsuário {

    private static GerenciadorDeContatos gerenciadorDeContatos = new GerenciadorDeContatos();
    
    // Método para iniciar a interface de linha de comando
    public static void iniciarInterfaceDeUsuario() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Gerenciador de Contatos ---");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Buscar contato");
            System.out.println("4. Remover contato");
            System.out.println("5. Atualizar contato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    limparTela();
                    gerenciadorDeContatos.adicionarContato(nome, telefone, email);
                    break;
                case 2:
                    limparTela();
                    gerenciadorDeContatos.imprimirContatos();
                    break;
                case 3:
                    System.out.print("Nome do contato para buscar: ");
                    nome = scanner.nextLine();
                    Contato encontrado = gerenciadorDeContatos.buscarPorNome(nome);
                    limparTela();
                    if (encontrado != null) {
                        System.out.println("Contato encontrado: ID: " + encontrado.getId() + ", Nome: " + encontrado.getNome() + ", Telefone: " + encontrado.getTelefone() + ", Email: " + encontrado.getEmail());
                    }else{
                        System.out.println("Nenhumm contato encontrado com esse nome!");
                    }
                    break;
                case 4:
                    System.out.print("Nome do contato para remover: ");
                    nome = scanner.nextLine();
                    limparTela();
                    gerenciadorDeContatos.removerContato(nome);
                    break;
                case 5:
                    System.out.print("ID do contato para atualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Novo Email: ");
                    String novoEmail = scanner.nextLine();
                    limparTela();
                    gerenciadorDeContatos.atualizarContato(id, novoNome, novoTelefone, novoEmail);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void limparTela() {
        //esse código pode ser encontrado na internet, não precisa focar muito em entender ele
        try {
            String sistemaOperacional = System.getProperty("os.name"); // Verifica o sistema operacional
    
            if (sistemaOperacional.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Comando para Windows
            } else {
                Runtime.getRuntime().exec("clear"); // Comando para Unix/Linux/MacOS
                System.out.print("\033[H\033[2J");  
                System.out.flush();  
            }
        } catch (Exception e) {
            // Em caso de erro, simplesmente pula o comando de limpar tela
            System.out.println("ERROR: Não foi possível limpar a tela");
        }
    }
}
