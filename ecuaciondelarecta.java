import java.util.Scanner;

public class ecuaciondelarecta {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar(){
        Scanner scanner = new Scanner(System.in);

        double x1 = obtenerCoordenada(scanner, "x1");
        double y1 = obtenerCoordenada(scanner, "y1");

        double x2 = obtenerCoordenada(scanner, "x2");
        double y2 = obtenerCoordenada(scanner, "y2");

        double m = calcularPendiente(x1, y1, x2, y2);
        double b = calcularTerminoIndependiente(x1, y1, m);

        System.out.println("La ecuación de la recta es: Y = " + m + "X + " + b);

        scanner.close();
    }
    public static double obtenerCoordenada(Scanner scanner, String nombre) {
        while (true) {
            try {
                System.out.println("Ingrese la coordenada " + nombre + ": ");
                double valor = scanner.nextDouble();

                if (valor != 0) {
                    return valor;
                } else {
                    System.out.println("Error: " + nombre + " debe ser distinto de cero. Intente nuevamente.");
                }

            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un valor numérico válido. Intente nuevamente.");
                scanner.nextLine(); // Limpiar el búfer de entrada
            }
        }
    }

    public static double calcularPendiente(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    public static double calcularTerminoIndependiente(double x1, double y1, double m) {
        return y1 - m * x1;
    }

}
