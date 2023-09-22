import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            int opcion = obtenerEnteroPositivo(scanner);
            ejecutarMenu(opcion);

        }
    }

    public static void ejecutarMenu(int opcion){
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                realizarOperacionesAritmeticas(scanner);
                break;
            case 2:
                calcularPorcentaje(scanner);
                break;
            case 3:
                resolverEcuacionCuadratica(scanner);
                break;
            case 4:
                calcularEcuacionDeLaRecta(scanner);
                break;
            case 5:
                resolverSistemaDeEcuaciones(scanner);
                break;
            case 6:
                calcularPropiedadesDeFiguras(scanner);
                break;
            case 7:
                System.out.println("Saliendo del programa.");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }


    }
    public static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Operaciones aritméticas");
        System.out.println("2. Calcular porcentaje");
        System.out.println("3. Resolver ecuación cuadrática");
        System.out.println("4. Calcular ecuación de la recta");
        System.out.println("5. Resolver sistema de ecuaciones lineales");
        System.out.println("6. Calcular propiedades de figuras geométricas");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }
    public static void realizarOperacionesAritmeticas(Scanner scanner) {
        double numero1 = obtenerNumero(scanner, "Ingresa el primer número");
        double numero2 = obtenerNumero(scanner, "Ingresa el segundo número");

        double suma = sumar(numero1, numero2);
        double resta = restar(numero1, numero2);
        double multiplicacion = multiplicar(numero1, numero2);
        double division = dividir(numero1, numero2);

        double mayor = encontrarMayor(numero1, numero2);
        double menor = encontrarMenor(numero1, numero2);
        double potencia = calcularPotencia(numero1, numero2);

        mostrarResultados(suma, resta, multiplicacion, division, mayor, menor, potencia);
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
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return Double.POSITIVE_INFINITY;
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

    public static void calcularPorcentaje(Scanner scanner) {
        double numero = obtenerNumero(scanner, "Ingresa un número para calcular el porcentaje: ");
        double porcentaje = obtenerNumero(scanner,"Ingresa el porcentaje a calcular: ");

        double resultadoPorcentaje = calcularPorcentaje(numero, porcentaje);

        System.out.println(porcentaje + "% de " + numero + " es igual a " + resultadoPorcentaje);
    }

    public static double calcularPorcentaje(double numero, double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100.");
        }
        return (numero * porcentaje) / 100.0;
    }

    public static void resolverEcuacionCuadratica(Scanner scanner) {

        double A = obtenerNumero(scanner,"Ingrese el valor de A: ");
        double B = obtenerNumero(scanner,"Ingrese el valor de B: ");
        double C = obtenerNumero(scanner,"Ingrese el valor de C: ");

        calcularYMostrarSoluciones(A, B, C);
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

    public static void calcularEcuacionDeLaRecta(Scanner scanner) {
        double x1 = obtenerCoordenada(scanner, "x1");
        double y1 = obtenerCoordenada(scanner, "y1");

        double x2 = obtenerCoordenada(scanner, "x2");
        double y2 = obtenerCoordenada(scanner, "y2");

        double m = calcularPendiente(x1, y1, x2, y2);
        double b = calcularTerminoIndependiente(x1, y1, m);

        System.out.println("La ecuación de la recta es: Y = " + m + "X + " + b);
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
                scanner.nextLine();
            }
        }
    }

    public static double calcularPendiente(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }

    public static double calcularTerminoIndependiente(double x1, double y1, double m) {
        return y1 - m * x1;
    }
    public static double obtenerNumero(Scanner scanner, String nombre) {
        while (true) {
            try {
                System.out.print(nombre + ": ");
                double numero = scanner.nextDouble();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número.");
                scanner.next();
            }
        }
    }


    public static void resolverSistemaDeEcuaciones(Scanner scanner) {
        double A = obtenerNumero(scanner, "A");
        double B = obtenerNumero(scanner, "B");
        double C = obtenerNumero(scanner, "C");
        double D = obtenerNumero(scanner, "D");
        double E = obtenerNumero(scanner, "E");
        double F = obtenerNumero(scanner, "F");

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

    public static void calcularPropiedadesDeFiguras(Scanner scanner) {
        while (true) {
            System.out.println("\nElije una figura geométrica:");
            System.out.println("1. Cuadrado");
            System.out.println("2. Rectángulo");
            System.out.println("3. Círculo");
            System.out.println("4. Esfera");
            System.out.println("5. Cubo");
            System.out.println("6. Cono");
            System.out.println("0. Volver al menú principal");

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
                scanner.next();
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
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.next();
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                scanner.next();
            }
        }
    }

}
