import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayListStackTest {

    @Test
    public void testPushAndPop() {
        ArrayListStack<Integer> pila = new ArrayListStack<>();
        pila.push(10);
        pila.push(20);
        assertEquals(20, pila.pop());
        assertEquals(10, pila.pop());
    }

    @Test
    public void testPeek() {
        ArrayListStack<Integer> pila = new ArrayListStack<>();
        pila.push(30);
        pila.push(40);
        assertEquals(40, pila.peek());
        assertEquals(40, pila.pop());
    }

    @Test
    public void testEstaVacia() {
        ArrayListStack<Integer> pila = new ArrayListStack<>();
        assertTrue(pila.estaVacia());
        pila.push(5);
        assertFalse(pila.estaVacia());
    }

    @Test
    public void testTamano() {
        ArrayListStack<Integer> pila = new ArrayListStack<>();
        assertEquals(0, pila.tamano());
        pila.push(15);
        pila.push(25);
        assertEquals(2, pila.tamano());
    }
}