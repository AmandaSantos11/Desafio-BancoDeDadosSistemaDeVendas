import org.example.repository.ClientRepository;
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

public class ClientRepositoryTest {
    private ClientRepository clientRepository;
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
        clientRepository = new ClientRepository(connect);
    }

    @DisplayName("Testa se quando o cliente é excluido retorna true")
    @Test
    void t1()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean result = clientRepository.deleteClient("00000000000");

        assertTrue(result);
    }

    @DisplayName("Testa se o registro de cliente retorna true")
    @Test
    void t2()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean result = clientRepository.registerClient("Pamela","pam@gmail.com",
                "90909090909","rua dos navios");

        assertTrue(result);
    }

    @DisplayName("Testa se o registro de cliente lança exceção")
    @Test
    void t3()throws SQLException{
        when(statement.executeUpdate()).thenThrow(new SQLException("Exceção"));

        boolean result = clientRepository.registerClient("Gabriel","gab@gmail.com",
                "12121212121","rua dos cantos neve");

        assertFalse(result);
    }

    @DisplayName("Testa se o exibir compras do cliente retorna true")
    @Test
    void t4()throws SQLException{
        when(statement.executeQuery()).thenReturn(result);
        when(result.getString("nome")).thenReturn("Produto: batata");
        when(result.getString("qtd_produto")).thenReturn("Quantidade: 5");
        when(result.getString("valor_total")).thenReturn("Valor total: R$15.00");

        boolean result = clientRepository.clientShopping("15151515155");

        assertTrue(result);
    }
}