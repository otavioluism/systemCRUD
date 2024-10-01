package br.com.rocket;

import java.util.List;

public class SistemaCadastro {
    public static void main(String[] args) {
        ConnectionDatabase.getConectar();
        ConnectionRepository repository = new ConnectionRepository();
//        Cadastro cadastro = new Cadastro();
//        cadastro.setIdade(25);
//        cadastro.setNome("teste");
//        cadastro.setId(1);

        Cadastro cadastroBusca = repository.buscarById(5);
        if (cadastroBusca != null) {
            System.out.println(String.format("Id=%d  Nome=%s  Idade=%d", cadastroBusca.getId(), cadastroBusca.getNome(), cadastroBusca.getIdade()));
        } else {
            System.out.println("Sistema não encontrou nenhum cliente");
        }

    }
}
