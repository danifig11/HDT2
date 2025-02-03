public class VectorStack<T> implements Pila<T> {
    private Object[] pila;
    private int tamano;

    public VectorStack() {
        pila = new Object[10]; // Capacidad 
        tamano = 0;
    }

    public void push(T elemento) {
        if (tamano == pila.length) {
            expandirCapacidad();
        }
        pila[tamano++] = elemento;
    }

    public T pop() {
        if (estaVacia()) {
            throw new RuntimeException("La pila esta vacia.");
        }
        return (T) pila[--tamano];
    }

    public T peek() {
        if (estaVacia()) {
            throw new RuntimeException("La pila esta vacia.");
        }
        return (T) pila[tamano - 1];
    }

    public boolean estaVacia() {
        return tamano == 0;
    }

    public int tamano() {
        return tamano;
    }

    private void expandirCapacidad() {
        Object[] nuevaPila = new Object[pila.length * 2];
        for (int i = 0; i < pila.length; i++) {
            nuevaPila[i] = pila[i];
        }
        pila = nuevaPila;
    }
}