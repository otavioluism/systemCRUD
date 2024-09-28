package br.com.rocket;

import java.sql.Connection;
import java.util.List;

public class ConnectionRepository {

    private static Connection conexao;

    public ConnectionRepository() {
        conexao = ConnectionDatabase.getConexao();

    }

    public void salvar(Cadastro cadastro) {}
    public void alterar(Cadastro cadastro) {}
    public void excluir(Cadastro cadastro) {}
    public List<Cadastro> listar() {
        return null;
    }
    public Cadastro buscar(Integer Id){
        return null;
    }
}
