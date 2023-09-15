package org.example.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDB {
    private static final String url = "jdbc:postgresql://localhost:5432/desafio";
    private static final String user = "postgres";
    private static final String password = "1243";
    private static Connection connection;

    public static Connection connect(){
        try{
            connection = DriverManager.getConnection(url,user,password);

            if (connection != null){
                System.out.println("\nConectado ao servidor PostgreSQL com sucesso!\n");
            }
            else{
                System.out.println("A conexão com o servidor PostgreSQL falhou.");
            }
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}