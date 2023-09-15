package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class SaleRepository {
    public SaleRepository(){}
    public SaleRepository(Connection connection){
        this.connection = connection;
    }
    private Connection connection = connect();
    public boolean displayAllSalesOverTenReais(){
        String sql = "SELECT produto.nome,venda.valor_total " +
                     "FROM produto,venda " +
                     "WHERE produto.id_produto = venda.id_produto " +
                     "AND venda.valor_total >= 10.00 ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("Produto: " + result.getString("nome"));
                System.out.println("Valor total: R$" + result.getDouble("valor_total"));
                System.out.println("----------------------------------");
            }
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean changeTheTotalValueOfSalesThatAreNullToZero(){
        String sql = "UPDATE venda " +
                     "SET valor_total = 0 " +
                     "WHERE valor_total IS NULL ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.executeUpdate();
            statement.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean registerSale(int amount,double total,int id_seller,int id_client,int id_product){
        String sql= "INSERT INTO venda (qtd_produto,valor_total,id_vendedor,id_cliente,id_produto) " +
                "VALUES (?,?,?,?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, amount);
            statement.setDouble(2, total);
            statement.setInt(3, id_seller);
            statement.setInt(4, id_client);
            statement.setInt(5, id_product);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}