import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void testEvaluateExpression() throws Exception {
        Calculadora calc = new Calculadora(false); // Usando VectorStack
        int resultado = calc.evaluate("1 2 + 4 * 3 +");
        assertEquals(15, resultado); // Resultado esperado: 15
    }

    @Test
    public void testExpressionWithDivision() throws Exception {
        Calculadora calc = new Calculadora(false); // Usando VectorStack
        int resultado = calc.evaluate("8 4 / 2 +");
        assertEquals(4, resultado); // Resultado esperado: 4
    }

    @Test
    public void testDivisionPorCero() {
        Calculadora calc = new Calculadora(false);
        Exception exception = assertThrows(Exception.class, () -> {
            calc.evaluate("1 0 /");
        });
        assertTrue(exception.getMessage().contains("División entre cero"));
    }

    @Test
    public void testExpressionWithInvalidCharacters() {
        Calculadora calc = new Calculadora(false);
        Exception exception = assertThrows(Exception.class, () -> {
            calc.evaluate("1 2 @ +");
        });
        assertTrue(exception.getMessage().contains("Carácter inválido"));
    }

    @Test
    public void testExpressionWithInsufficientOperands() {
        Calculadora calc = new Calculadora(false);
        Exception exception = assertThrows(Exception.class, () -> {
            calc.evaluate("1 +");
        });
        assertTrue(exception.getMessage().contains("faltan operandos"));
    }
}