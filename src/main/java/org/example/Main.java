package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Contato> listContatos = new ArrayList<>(0);

    public static void main(String[] args) {

//        CRUD = CREATE (criar), READ (ler), UPDATE (atualizar), DELETE (apagar)

        List<Contato> contatos = new ArrayList<>(0);

        Contato contato = new Contato();
        contato.setNome("Fulano");
        contato.setTelefone("+55 (61) 99999-0000");
        contato.setEmail("fulano@email.com");
        contatos.add(contato);

        Contato contato1 = new Contato();
        contato1.setNome("Ciclano");
        contato1.setTelefone("+55 (61) 99999-1111");
        contato1.setEmail("ciclano@email.com");
        contatos.add(contato1);

        salvar(contatos);

        Contato contatoEncontrado = buscar("C");

        System.out.println("Telefone = " + contatoEncontrado.getTelefone());
        System.out.println("E-mail = " + contatoEncontrado.getEmail());

    }

    private static void salvar(Contato contato) {
        //TODO validar campos preenchidos
        listContatos.add(contato);
    }

    private static void salvar(List<Contato> contatos) {
        listContatos.addAll(contatos);
    }

    private static Contato buscar(String nome) {
        for(int i = 0; i < listContatos.size(); i++) {
            Contato contato = listContatos.get(i);
            if(contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }
}
