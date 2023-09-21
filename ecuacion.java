import java.util.InputMismatchException;
import java.util.Scanner;

public class ecuacion {

    public static void main(String[] args) {
        iniciar();
    }

    public static void  iniciar(){
        Scanner scanner = new Scanner(System.in);

        double A = obtenerNumero(scanner, "A");
        double B = obtenerNumero(scanner, "B");
        double C = obtenerNumero(scanner, "C");
        double D = obtenerNumero(scanner, "D");
        double E = obtenerNumero(scanner, "E");
        double F = obtenerNumero(scanner, "F");

        resolverSistema(A, B, C, D, E, F);
    }

    public static double obtenerNumero(Scanner scanner, String nombre) {
        while (true) {
            System.out.print(nombre + ": ");
            try {
                double numero = scanner.nextDouble();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }

    public static void resolverSistema(double A, double B, double C, double D, double E, double F) {
        double determinante = A * E - B * D;

        if (determinante != 0) {
            double x = (C * E - B * F) / determinante;
            double y = (A * F - C * D) / determinante;

            System.out.println("La solución es:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        } else {
            System.out.println("El sistema no tiene solución única.");
        }
    }
}

