package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class ClientRepository {
    public ClientRepository(){}
    public ClientRepository(Connection connection){
        this.connection = connection;
    }
    private Connection connection = connect();
    public boolean deleteClient(String cpf){
        String sql = "DELETE FROM cliente WHERE cpf = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean registerClient(String name,String email,String cpf,String address){
        String sql= "INSERT INTO cliente (nome,email,cpf,endereco) VALUES (?,?,?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, cpf);
            statement.setString(4, address);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean clientShopping(String cpf){
        String sql= "SELECT produto.nome,venda.qtd_produto,venda.valor_total " +
                    "FROM cliente " +
                    "INNER JOIN venda ON cliente.id_cliente = venda.id_cliente " +
                    "INNER JOIN produto ON produto.id_produto = venda.id_produto " +
                    "WHERE cliente.cpf = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,cpf);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("Produto: " + result.getString("nome"));
                System.out.println("Quantidade: " + result.getString("qtd_produto"));
                System.out.println("Valor total: R$" + result.getString("valor_total"));
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