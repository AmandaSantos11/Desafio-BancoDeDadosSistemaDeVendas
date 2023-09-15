import org.example.repository.ProductRepository;
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

public class ProductRepositoryTest {
    private ProductRepository productRepository;
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
        productRepository = new ProductRepository(connect);
    }

    @DisplayName("Testa se o registro de produto retorna true")
    @Test
    void t1()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean result = productRepository.registerProduct("Carambola",7.55);

        assertTrue(result);
    }

    @DisplayName("Testa se o registro de produto retorna exceção")
    @Test
    void t2()throws SQLException{
        when(statement.executeUpdate()).thenThrow(new SQLException("Exceção"));

        boolean result = productRepository.registerProduct("Kiwi",9.55);

        assertFalse(result);
    }
}