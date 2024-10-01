package br.com.rocket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConnectionRepository {

    private static Connection conexao;

    public ConnectionRepository() {
        conexao = ConnectionDatabase.getConexao();

    }

    public void incluir(Cadastro cadastro) {
        try{
            String querySqlInsert = "INSERT INTO public.tab_cadastro (nome, idade) VALUES (?, ?)";

//           Classe responsável por manipular os dados com JDBC, inserir, atualizar, deletar
            PreparedStatement pst = conexao.prepareStatement(querySqlInsert);
            pst.setString(1 , cadastro.getNome()); // primeiro parametro da query ?
            pst.setInt(2, cadastro.getIdade()); // segundo parametro da query ?
            pst.execute();
            System.out.println("Cadastro inserido com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void alterar(Cadastro cadastro) {
        try {
            String querySqlUpdate = "UPDATE public.tab_cadastro SET nome=?, idade=? WHERE id=?";

//           Classe responsável por manipular os dados com JDBC, inserir, atualizar, deletar
            PreparedStatement pst = conexao.prepareStatement(querySqlUpdate);
            pst.setString(1 , cadastro.getNome()); // primeiro parametro da query ?
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());// segundo parametro da query ?
            pst.execute(); // utiliza-se o execute para todos as query que mudam o status do banco de dados
            System.out.println("Cadastro alterado com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void excluir(Integer id) {
        try {
            String querySqlUpdate = "DELETE FROM public.tab_cadastro WHERE id=?";

//           Classe responsável por manipular os dados com JDBC, inserir, atualizar, deletar
            PreparedStatement pst = conexao.prepareStatement(querySqlUpdate);
            pst.setInt(1 , id); // primeiro parametro da query ?// segundo parametro da query ?
            pst.execute();
            System.out.println("Cadastro excluído com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public List<Cadastro> listar() {
        List<Cadastro> lista = new ArrayList<>();
        try{
            String querySqlSelect = "SELECT id, nome, idade FROM public.tab_cadastro";
//           Classe responsável por manipular os dados com JDBC, inserir, atualizar, deletar
            PreparedStatement pst = conexao.prepareStatement(querySqlSelect);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");

                Cadastro cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);
                lista.add(cadastro);
            }
            System.out.println("Cadastro selecionado os elementos com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    public Cadastro buscarById(Integer id){
        Cadastro cadastro = null;
        try{
            String querySqlSelect = "SELECT id, nome, idade FROM public.tab_cadastro WHERE id=?";
//           Classe responsável por manipular os dados com JDBC, inserir, atualizar, deletar
            PreparedStatement pst = conexao.prepareStatement(querySqlSelect);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery(); // todas consultas que selecionam
            if (result.next()) {
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");

                cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);
            }
            System.out.println("Cadastro selecionado com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cadastro;
    }
}
