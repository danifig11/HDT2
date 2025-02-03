import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VectorStackTest {

    @Test
    public void testPushAndPop() {
        VectorStack<Integer> pila = new VectorStack<>();
        pila.push(10);
        pila.push(20);
        assertEquals(20, pila.pop());
        assertEquals(10, pila.pop());
    }

    @Test
    public void testPeek() {
        VectorStack<Integer> pila = new VectorStack<>();
        pila.push(30);
        pila.push(40);
        assertEquals(40, pila.peek());
        assertEquals(40, pila.pop());
    }

    @Test
    public void testEstaVacia() {
        VectorStack<Integer> pila = new VectorStack<>();
        assertTrue(pila.estaVacia());
        pila.push(5);
        assertFalse(pila.estaVacia());
    }

    @Test
    public void testTamano() {
        VectorStack<Integer> pila = new VectorStack<>();
        assertEquals(0, pila.tamano());
        pila.push(15);
        pila.push(25);
        assertEquals(2, pila.tamano());
    }
}