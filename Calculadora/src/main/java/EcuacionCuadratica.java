import java.util.Scanner;

public class EcuacionCuadratica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de A: ");
        double A = scanner.nextDouble();

        System.out.print("Ingrese el valor de B: ");
        double B = scanner.nextDouble();

        System.out.print("Ingrese el valor de C: ");
        double C = scanner.nextDouble();

        calcularYMostrarSoluciones(A, B, C);

        scanner.close();
    }

    public static void calcularYMostrarSoluciones(double A, double B, double C) {
        double discriminante = calcularDiscriminante(A, B, C);

        if (discriminante > 0) {
            double x1 = calcularX1(A, B, discriminante);
            double x2 = calcularX2(A, B, discriminante);
            mostrarSoluciones(x1, x2);
        } else if (discriminante == 0) {
            double x = calcularX(A, B);
            mostrarSolucionDoble(x);
        } else {
            mostrarNoHaySolucionesReales();
        }
    }

    public static double calcularDiscriminante(double A, double B, double C) {
        return B * B - 4 * A * C;
    }

    public static double calcularX1(double A, double B, double discriminante) {
        return (-B + Math.sqrt(discriminante)) / (2 * A);
    }

    public static double calcularX2(double A, double B, double discriminante) {
        return (-B - Math.sqrt(discriminante)) / (2 * A);
    }

    public static double calcularX(double A, double B) {
        return -B / (2 * A);
    }

    public static void mostrarSoluciones(double x1, double x2) {
        System.out.println("Las soluciones son x1 = " + x1 + " y x2 = " + x2);
    }

    public static void mostrarSolucionDoble(double x) {
        System.out.println("La solución doble es x = " + x);
    }

    public static void mostrarNoHaySolucionesReales() {
        System.out.println("La ecuación no tiene soluciones reales.");
    }
}
