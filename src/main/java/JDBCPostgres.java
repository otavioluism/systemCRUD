import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBCPostgres {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "admin");
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Sistema conectado!");

            String querySql = "INSERT INTO public.tab_cadastro (nome, idade) VALUES (?, ?)";
            String nome = "Otávio Luis Martins";
            Integer idadade = 26;

//           Classe responsável por manipular os dados com JDBC, inserir, atualizar, deletar
            PreparedStatement pst = conn.prepareStatement(querySql);
            pst.setString(1 , nome);
            pst.setInt(2, idadade);
            pst.execute();
            System.out.println("Cadastro inserido com sucesso!");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
