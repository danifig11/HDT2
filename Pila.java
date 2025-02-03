public interface Pila<T> {
    void push(T elemento);
    T pop();
    T peek();
    boolean estaVacia();
    int tamano();
}