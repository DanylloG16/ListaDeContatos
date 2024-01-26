package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Contato> listContatos = new ArrayList<>(0);

    public static void main(String[] args) {
//        CRUD = CREATE (criar), READ (ler), UPDATE (atualizar), DELETE (apagar)
        List<Contato> contatos = new ArrayList<>(0);


         salvar("danyllo", "asdasd", "asdasd");
        // deletar("Ciclano");

        //  deletar("Fulano");

        //listContatos.clear();

        //Contato contatoEncontrado = buscar("Ciclano");

        // buscar mesmo se for maisculo ou minusculo

        imprimir();
//
       Contato novoContato = new Contato();
        novoContato.setNome("00");
        novoContato.setTelefone("000");
        novoContato.setEmail("000");
//
//        atualizar("Fulano", novoContato);
//


//        imprimir()

        atualizar("Danyllo", novoContato);
        imprimir();

        salvar("ASA", "777", "777");

        Contato novoContato1 = new Contato();
        novoContato.setNome("011");
        novoContato.setTelefone("010");
        novoContato.setEmail("010");


       imprimir();

    }
    private static boolean validar(Contato contato){
        return contato != null && !contato.getNome().trim().isEmpty() && (!contato.getEmail().trim().isEmpty() || !contato.getTelefone().trim().isEmpty());
    }
    private static void salvar( String nome, String email, String telefone) {
        int id = gerarId();
        Contato novoContato = new Contato();
        novoContato.setId(id);
        novoContato.setNome(nome);
        novoContato.setEmail(email);
        novoContato.setTelefone(telefone);

        if (validar(novoContato)) {
            listContatos.add(novoContato);
            System.out.println("Contato salvo com sucesso!");
        } else {
            System.out.println("Nome, email ou telefone inválido. Contato não pode ser salvo.");
        }
    }



    private static int gerarId(){
       int quantidade = listContatos.size();
       quantidade ++;
       return quantidade;
    }

   // private static boolean nomeUnico(Contato novoContato) {
     //   String novoNome = novoContato.getNome().toLowerCase();



    private static void imprimir(){
        System.out.println("...................................");
        for (int o = 0; o < listContatos.size(); o++) {
            Contato c = listContatos.get(o);
            System.out.println("Telefone = " + c.getTelefone());
            System.out.println("E-mail = " + c.getEmail());
            System.out.println("nome = " + c.getNome());
            System.out.println(" ID = " + c.getId());
        }
    }
    private static Contato buscar(String nome) {
        for (int i = 0; i < listContatos.size(); i++) {
            Contato contato = listContatos.get(i);
            if (contato.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return contato;
            }
        }
        return null;
    }
    private static void deletar(String nome) {
        for (int j = 0; j < listContatos.size(); j++) {
            Contato contato = listContatos.get(j);
            if (contato.getNome().equals(nome)) {
                listContatos.remove(j);

            }
        }
    }
    private static void atualizar(String nome , Contato novoContato) {
            Contato contato = buscar(nome);
            if (contato != null && validar(novoContato) ) {
                contato.setNome(novoContato.getNome());
                contato.setEmail(novoContato.getEmail());
                contato.setTelefone(novoContato.getTelefone());

            }else{
                System.out.println("Nome, email ou telefone inválido. Contato não pode ser salvo.");
            }
    }
}
















