package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class ValidateLoginRepository {
    public ValidateLoginRepository(){}
    public ValidateLoginRepository(Connection connection){
        this.connection = connection;
    }
    private Connection connection = connect();
    public boolean validateLogin(String email,String cpf){
        String sql_client= "SELECT * FROM cliente WHERE email = ? AND cpf = ? ";
        String sql_seller= "SELECT * FROM vendedor WHERE email = ? AND cpf = ? ";
        try {
            PreparedStatement client_statement = connection.prepareStatement(sql_client);
            client_statement.setString(1, email);
            client_statement.setString(2, cpf);

            ResultSet result_client = client_statement.executeQuery();
            if (result_client.next()){
                return true;
            }

            PreparedStatement seller_statement = connection.prepareStatement(sql_seller);
            seller_statement.setString(1, email);
            seller_statement.setString(2, cpf);

            ResultSet result_seller = seller_statement.executeQuery();
            if (result_seller.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}