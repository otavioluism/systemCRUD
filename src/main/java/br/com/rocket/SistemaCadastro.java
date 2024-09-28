package br.com.rocket;

public class SistemaCadastro {
    public static void main(String[] args) {
        ConnectionDatabase.getConectar();
        ConnectionRepository repository = new ConnectionRepository();
        Cadastro cadastro = new Cadastro();
        cadastro.setIdade(25);
        cadastro.setNome("Alemao");
        repository.salvar(cadastro);
    }
}
