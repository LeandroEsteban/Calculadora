import java.util.Scanner;

public class ecuacion {

    public static void main(String[] args) {
        iniciar();
    }

    public static void  iniciar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los coeficientes y constantes del sistema:");
        System.out.print("A: ");
        double A = scanner.nextDouble();
        System.out.print("B: ");
        double B = scanner.nextDouble();
        System.out.print("C: ");
        double C = scanner.nextDouble();
        System.out.print("D: ");
        double D = scanner.nextDouble();
        System.out.print("E: ");
        double E = scanner.nextDouble();
        System.out.print("F: ");
        double F = scanner.nextDouble();

        resolverSistema(A, B, C, D, E, F);
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
