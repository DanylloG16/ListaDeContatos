package org.example.serviços;

import java.util.ArrayList;
import java.util.List;

import org.example.modelos.Contato;

public class GerenciadorDeContatos {
    private List<Contato> contatos;
    private int idAtual;

    public GerenciadorDeContatos() {
        this.contatos = new ArrayList<>();
        this.idAtual = 1;
    }

    public void adicionarContato(String nome, String telefone, String email) {
        //eu tinha falado sobre o "Validator" na sua casa mas depois eu descobri que só existe em projetos mais avançados
        if (nome == null || nome.trim().isEmpty() || (telefone == null || telefone.trim().isEmpty()) && (email == null || email.trim().isEmpty())) {
            System.out.println("Dados do contato inválidos.");
            return;
        }
        Contato contato = new Contato();
        contato.setId(idAtual++);
        contato.setNome(nome);
        contato.setTelefone(telefone);
        contato.setEmail(email);
        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void imprimirContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }
        for (Contato contato : contatos) {
            System.out.println("ID: " + contato.getId() + ", Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone() + ", Email: " + contato.getEmail());
        }
    }

    public Contato buscarPorNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        System.out.println("Contato não encontrado.");
        return null;
    }

    public void removerContato(String nome) {
        Contato contato = buscarPorNome(nome);
        if (contato != null) {
            contatos.remove(contato);
            System.out.println("Contato removido com sucesso.");
        }
    }

    public void atualizarContato(int id, String novoNome, String novoTelefone, String novoEmail) {
        for (Contato contato : contatos) {
            if (contato.getId() == id) {
                contato.setNome(novoNome);
                contato.setTelefone(novoTelefone);
                contato.setEmail(novoEmail);
                System.out.println("Contato atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Contato não encontrado.");
    }
}

