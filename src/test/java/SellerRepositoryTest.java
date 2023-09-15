import org.example.repository.SellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SellerRepositoryTest {
    private SellerRepository sellerRepository;
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
        sellerRepository = new SellerRepository(connect);
    }

    @DisplayName("Testa se o mostrar informações dos vendedores retorna true")
    @Test
    void t1()throws SQLException{
        when(statement.executeQuery()).thenReturn(result);
        when(result.getString("nome")).thenReturn("Vendedor: Jose");
        when(result.getString("salario")).thenReturn("Salário: R$1200.00");

        boolean result = sellerRepository.showSellerInformation();

        assertTrue(result);
    }

    @DisplayName("Testa se o mostrar os email com 'zup' retorna true")
    @Test
    void t2()throws SQLException{
        when(statement.executeQuery()).thenReturn(result);
        when(result.getString("nome")).thenReturn("Nome: Eduardo");
        when(result.getString("email")).thenReturn("Email: eduardo.tales@zup.com.br");

        boolean result = sellerRepository.showEmailsThatContainZup();

        assertTrue(result);
    }
}