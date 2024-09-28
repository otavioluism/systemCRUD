package br.com.rocket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionDatabase {

    private static Connection conexao;

    public static void getConectar() {
        try {
            if (conexao == null){
                String url = "jdbc:postgresql://localhost:5432/postgres";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "admin");
                conexao = DriverManager.getConnection(url, props);
                System.out.println("Sistema conectado!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Connection getConexao() {
        return conexao;
    }
}
