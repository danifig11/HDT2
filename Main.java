public class Main {
    public static void main(String[] args) {
        try {
            String expresion = leerArchivo("datos.txt");

            // Seleccionar tipo de pila
            boolean usarArrayList = true; // Cambiar a true para usar ArrayListStack
            ICalculadora calc = new Calculadora(usarArrayList);

            int resultado = calc.evaluate(expresion);

            System.out.println("Expresión: " + expresion);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Error :( : " + e.getMessage());
        }
        
    }

    private static String leerArchivo(String nombreArchivo) throws Exception {
        String contenido = "";
        java.io.FileReader fr = new java.io.FileReader(nombreArchivo);
        java.io.BufferedReader br = new java.io.BufferedReader(fr);
        contenido = br.readLine();
        br.close();
        return contenido;
    }
}