import java.util.InputMismatchException;
import java.util.Scanner;

public class geometrico {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nElije una figura geométrica:");
            System.out.println("1. Cuadrado");
            System.out.println("2. Rectángulo");
            System.out.println("3. Círculo");
            System.out.println("4. Esfera");
            System.out.println("5. Cubo");
            System.out.println("6. Cono");
            System.out.println("0. Salir");

            int opcion = obtenerEnteroPositivo(scanner);

            switch (opcion) {
                case 1:
                    calcularCuadrado(scanner);
                    break;
                case 2:
                    calcularRectangulo(scanner);
                    break;
                case 3:
                    calcularCirculo(scanner);
                    break;
                case 4:
                    calcularEsfera(scanner);
                    break;
                case 5:
                    calcularCubo(scanner);
                    break;
                case 6:
                    calcularCono(scanner);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        }
    }


    public static void calcularCuadrado(Scanner scanner) {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = obtenerDoublePositivo(scanner);

        double area = lado * lado;
        double perimetro = 4 * lado;

        System.out.println("El área del cuadrado es: " + area);
        System.out.println("El perímetro del cuadrado es: " + perimetro);
    }

    public static void calcularRectangulo(Scanner scanner) {
        System.out.print("Ingrese la base del rectángulo: ");
        double base = obtenerDoublePositivo(scanner);

        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = obtenerDoublePositivo(scanner);

        double area = base * altura;
        double perimetro = 2 * (base + altura);

        System.out.println("El área del rectángulo es: " + area);
        System.out.println("El perímetro del rectángulo es: " + perimetro);
    }

    public static void calcularCirculo(Scanner scanner) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = obtenerDoublePositivo(scanner);

        double area = Math.PI * radio * radio;
        double perimetro = 2 * Math.PI * radio;

        System.out.println("El área del círculo es: " + area);
        System.out.println("El perímetro del círculo es: " + perimetro);
    }

    public static void calcularEsfera(Scanner scanner) {
        System.out.print("Ingrese el radio de la esfera: ");
        double radio = obtenerDoublePositivo(scanner);

        double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
        double areaSuperficie = 4 * Math.PI * Math.pow(radio, 2);

        System.out.println("El volumen de la esfera es: " + volumen);
        System.out.println("El área de la superficie de la esfera es: " + areaSuperficie);
    }

    public static void calcularCubo(Scanner scanner) {
        System.out.print("Ingrese el lado del cubo: ");
        double lado = obtenerDoublePositivo(scanner);

        double volumen = Math.pow(lado, 3);
        double areaSuperficie = 6 * Math.pow(lado, 2);

        System.out.println("El volumen del cubo es: " + volumen);
        System.out.println("El área de la superficie del cubo es: " + areaSuperficie);
    }

    public static void calcularCono(Scanner scanner) {
        System.out.print("Ingrese el radio del cono: ");
        double radio = obtenerDoublePositivo(scanner);

        System.out.print("Ingrese la altura del cono: ");
        double altura = obtenerDoublePositivo(scanner);

        double volumen = (1.0 / 3.0) * Math.PI * Math.pow(radio, 2) * altura;
        double areaSuperficie = Math.PI * radio * (radio + Math.sqrt(Math.pow(altura, 2) + Math.pow(radio, 2)));

        System.out.println("El volumen del cono es: " + volumen);
        System.out.println("El área de la superficie del cono es: " + areaSuperficie);
    }

    public static int obtenerEnteroPositivo(Scanner scanner) {
        int valor;
        while (true) {
            try {
                valor = scanner.nextInt();
                if (valor < 0) {
                    System.out.println("Por favor, ingrese un número positivo.");
                } else {
                    return valor;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }

    public static double obtenerDoublePositivo(Scanner scanner) {
        double valor;
        while (true) {
            try {
                valor = scanner.nextDouble();
                if (valor < 0) {
                    System.out.println("Por favor, ingrese un número positivo.");
                } else {
                    return valor;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }
}
