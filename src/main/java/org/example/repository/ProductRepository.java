package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class ProductRepository {
    public ProductRepository(){}
    public ProductRepository(Connection connection){
        this.connection = connection;
    }
    private Connection connection = connect();
    public boolean registerProduct(String name,double price){
        String sql= "INSERT INTO produto (nome,preco) VALUES (?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}