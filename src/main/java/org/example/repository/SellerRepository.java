package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connect;
public class SellerRepository {
    public SellerRepository(){}
    public SellerRepository(Connection connection){
        this.connection = connection;
    }
    private Connection connection = connect();
    public boolean showSellerInformation(){
        String sql= "SELECT vendedor.nome,vendedor.salario " +
                    "FROM vendedor " +
                    "ORDER BY vendedor.salario DESC ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("Vendedor: " + result.getString("nome"));
                System.out.println("Salário: R$" + result.getDouble("salario"));
                System.out.println("--------------------");
            }
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean showEmailsThatContainZup(){
        String sql= "SELECT nome, email " +
                    "FROM vendedor " +
                    "WHERE email LIKE '%zup.com.br%' " +
                    "UNION " +
                    "SELECT nome, email " +
                    "FROM cliente " +
                    "WHERE email LIKE '%zup.com.br%' ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("Nome: " + result.getString("nome"));
                System.out.println("Email: " + result.getString("email"));
                System.out.println("--------------------");
            }
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}