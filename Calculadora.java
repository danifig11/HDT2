public class Calculadora implements ICalculadora {
    private Pila<Integer> pila;

    public Calculadora(boolean usarArrayList) {
        if (usarArrayList) {
            this.pila = new ArrayListStack<Integer>();
        } else {
            this.pila = new VectorStack<Integer>();
        }
    }

    public int evaluate(String expression) throws Exception {
        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);

            if (c >= '0' && c <= '9') {
                int num = 0;
                while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                pila.push(num);
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                if (pila.tamano() < 2) {
                    throw new Exception("Error: Expresion no valida, faltan operandos :(");
                }
                int operandoB = pila.pop();
                int operandoA = pila.pop();
                int resultado = operar(operandoA, operandoB, c);
                pila.push(resultado);
            } else if (c != ' ') {
                throw new Exception("Error: Caracter no valido en la expresión: " + c);
            }
            i++;
        }
        if (pila.tamano() != 1) {
            throw new Exception("Error: Expresion no valido, hay operandos sin operar :(");
        }
        return pila.pop();
    }

    private int operar(int a, int b, char operador) throws Exception {
        if (operador == '+') return a + b;
        if (operador == '-') return a - b;
        if (operador == '*') return a * b;
        if (operador == '/') {
            if (b == 0) throw new Exception("Error: Estas dividiendo entre cero :(");
            return a / b;
        }
        if (operador == '%') return a % b;
        throw new Exception("Operador no encontrado :(");
    }
}