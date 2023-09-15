import org.example.service.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationServiceTest {
    ValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService =  new ValidationService();
    }

    @DisplayName("Testa CPF válido")
    @Test
    void t1() {
        assertTrue(validationService.validateCpf("12345678901"));
    }

    @DisplayName("Testa CPF inválido com letras")
    @Test
    void t2() {
        assertFalse(validationService.validateCpf("123a5678l01"));
    }

    @DisplayName("Testa CPF inválido em branco")
    @Test
    void t3() {
        assertFalse(validationService.validateCpf(""));
    }

    @DisplayName("Testa CPF inválido com caracter especial")
    @Test
    void t4() {
        assertFalse(validationService.validateCpf("123.456.789.10"));
    }

    @DisplayName("Testa CPF inválido com mais de 11 digitos")
    @Test
    void t5() {
        assertFalse(validationService.validateCpf("123456789001"));
    }

    @DisplayName("Testa EMAIL válido")
    @Test
    void t6() {
        assertTrue(validationService.validateEmail("amanda.souza@zup.com.br"));
    }

    @DisplayName("Testa EMAIL inválido com menos de três caracter")
    @Test
    void t7() {
        assertFalse(validationService.validateEmail("a@"));
    }

    @DisplayName("Testa EMAIL inválido em branco")
    @Test
    void t8() {
        assertFalse(validationService.validateEmail(""));
    }

    @DisplayName("Testa EMAIL inválido sem o '@' ")
    @Test
    void t9() {
        assertFalse(validationService.validateEmail("amanda.gmail.com"));
    }

    @DisplayName("Testa EMAIL inválido sem o '.com'")
    @Test
    void t10() {
        assertFalse(validationService.validateEmail("lola@yahoo"));
    }

    @DisplayName("Testa NOME válido")
    @Test
    void t11() {
        assertTrue(validationService.validateName("amanda"));
    }

    @DisplayName("Testa NOME inválido com números")
    @Test
    void t12() {
        assertFalse(validationService.validateName("aman2"));
    }

    @DisplayName("Testa NOME inválido em branco")
    @Test
    void t13() {
        assertFalse(validationService.validateName(""));
    }

    @DisplayName("Testa NOME inválido com caracter especial")
    @Test
    void t14() {
        assertFalse(validationService.validateEmail("amanda@aa."));
    }

    @DisplayName("Testa NOME inválido com menos de 3 caractere")
    @Test
    void t15() {
        assertFalse(validationService.validateEmail("aa"));
    }

    @DisplayName("Testa ENDEREÇO válido")
    @Test
    void t16() {
        assertTrue(validationService.validateAddress("rua joao,113"));
    }

    @DisplayName("Testa ENDEREÇO inválido com caractere especial")
    @Test
    void t17() {
        assertFalse(validationService.validateAddress("rua neves !@"));
    }

    @DisplayName("Testa PREÇO válido")
    @Test
    void t18() {
        assertTrue(validationService.validatePrice(1));
    }

    @DisplayName("Testa PREÇO inválido com valor zero")
    @Test
    void t19() {
        assertFalse(validationService.validatePrice(0));
    }

    @DisplayName("Testa QUANTIDADE válida")
    @Test
    void t20() {
        assertTrue(validationService.validateAmount(1));
    }

    @DisplayName("Testa QUANTIDADE inválida com valor zero")
    @Test
    void t21() {
        assertFalse(validationService.validateAmount(0));
    }

    @DisplayName("Testa TOTAL válido")
    @Test
    void t22() {
        assertTrue(validationService.validateTotal(10.00));
    }

    @DisplayName("Testa TOTAL inválido com valor zero")
    @Test
    void t23() {
        assertFalse(validationService.validateAmount(0));
    }

    @DisplayName("Testa ID válido")
    @Test
    void t24() {
        assertTrue(validationService.validateId(1));
    }

    @DisplayName("Testa ID inválido com valor zero")
    @Test
    void t25() {
        assertFalse(validationService.validateId(0));
    }
}