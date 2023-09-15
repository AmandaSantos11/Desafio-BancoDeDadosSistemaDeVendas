import org.example.repository.ProductRepository;
import org.example.repository.SaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleRepositoryTest {
    private SaleRepository saleRepository;
    private Connection connect = mock(Connection.class);
    private PreparedStatement statement = mock(PreparedStatement.class);
    private ResultSet result = mock(ResultSet.class);

    @BeforeEach
    void setUp() {
        try {
            when(connect.prepareStatement(anyString())).thenReturn(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        saleRepository = new SaleRepository(connect);
    }

    @DisplayName("Testa se o mostrar produtos vendidos acima de R$10 retorna true")
    @Test
    void t1()throws SQLException{
        when(statement.executeQuery()).thenReturn(result);
        when(result.getString("nome")).thenReturn("Produto: jabuticaba");
        when(result.getString("valor_total")).thenReturn("Valor total: R$25.00");

        boolean result = saleRepository.displayAllSalesOverTenReais();

        assertTrue(result);
    }

    @DisplayName("Testa se o registro de venda retorna true")
    @Test
    void t2()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean result = saleRepository.registerSale(2,5.00,1,1,1);

        assertTrue(result);
    }

    @DisplayName("Testa se o registro de venda retorna exceção")
    @Test
    void t3()throws SQLException{
        when(statement.executeUpdate()).thenThrow(new SQLException("Exceção"));

        boolean result = saleRepository.registerSale(3,33.00,3,3,3);

        assertFalse(result);
    }

    @DisplayName("Testa se o alterar valor_total de nulo para zero retorna true")
    @Test
    void t4()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean result = saleRepository.changeTheTotalValueOfSalesThatAreNullToZero();

        assertTrue(result);
    }
}