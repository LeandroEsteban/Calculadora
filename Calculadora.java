import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        double numero2 = scanner.nextDouble();

        double suma = sumar(numero1, numero2);
        double resta = restar(numero1, numero2);
        double multiplicacion = multiplicar(numero1, numero2);
        double division = dividir(numero1, numero2);

        double mayor = encontrarMayor(numero1, numero2);
        double menor = encontrarMenor(numero1, numero2);
        double potencia = calcularPotencia(numero1, numero2);

        mostrarResultados(suma, resta, multiplicacion, division, mayor, menor, potencia);

        scanner.close();
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b==0) {
            throw new ArithmeticException("No se pude dividir por cero.");
        }
        else{
            return a / b;
        }



    }

    public static double encontrarMayor(double a, double b) {
        return Math.max(a, b);
    }

    public static double encontrarMenor(double a, double b) {
        return Math.min(a, b);
    }

    public static double calcularPotencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public static void mostrarResultados(double suma, double resta, double multiplicacion, double division,
                                         double mayor, double menor, double potencia) {
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + division);

        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.println("Potencia: " + potencia);
    }
}