
import java.util.Scanner;
import java.util.Random;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Random generator = new Random();

    // Configuración predeterminada
    static int repeticiones = 1;
    static int cantidadNumeros = 6;
    static int cantidadLetras = 14;
    static int cantidadOperaciones = 5;

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Jugar");
            System.out.println("2. Configuración");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    // La configuración queda fija durante la partida.
                    int repPartida = repeticiones;
                    int numPartida = cantidadNumeros;
                    int letrasPartida = cantidadLetras;
                    int opsPartida = cantidadOperaciones;

                    for (int i = 0; i < repPartida; i++) {
                        System.out.println("\n=== REPETICIÓN "
                                + (i + 1) + " DE " + repPartida + " ===");

                        cifraExacta(numPartida, opsPartida);
                        cuantasMasPalabrasMejor(letrasPartida);
                    }
                    break;

                case 2:
                    menuConfiguracion();
                    break;

                case 3:
                    System.out.println("Hasta pronto.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        sc.close();
    }

    // Leer un entero sin que el programa falle si se introduce texto.
    public static int leerEntero() {
        while (!sc.hasNextInt()) {
            System.out.println("Introduce un número entero válido.");
            sc.nextLine();
            System.out.print("Vuelve a intentarlo: ");
        }

        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    // Validar que un valor esté dentro de los límites permitidos.
    public static int leerValor(String mensaje, int minimo, int maximo) {
        int valor;

        do {
            System.out.print(mensaje);
            valor = leerEntero();

            if (valor < minimo || valor > maximo) {
                System.out.println("El valor debe estar entre "
                        + minimo + " y " + maximo + ".");
            }
        } while (valor < minimo || valor > maximo);

        return valor;
    }

    // Menú de configuración.
    public static void menuConfiguracion() {
        int opcion;

        do {
            System.out.println("\n=== CONFIGURACIÓN ===");
            System.out.println("1. Repeticiones: " + repeticiones);
            System.out.println("2. Cantidad de números: " + cantidadNumeros);
            System.out.println("3. Cantidad de letras: " + cantidadLetras);
            System.out.println("4. Cantidad de operaciones: "
                    + cantidadOperaciones);
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    repeticiones = leerValor(
                            "Repeticiones (1-20): ", 1, 20);
                    break;

                case 2:
                    cantidadNumeros = leerValor(
                            "Cantidad de números (1-10): ", 1, 10);
                    break;

                case 3:
                    cantidadLetras = leerValor(
                            "Cantidad de letras (8-26): ", 8, 26);
                    break;

                case 4:
                    cantidadOperaciones = leerValor(
                            "Cantidad de operaciones (1-20): ", 1, 20);
                    break;

                case 5:
                    System.out.println("Volviendo al menú principal.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // ==================== LA CIFRA EXACTA ====================

    public static void cifraExacta(int cantidad, int operaciones) {
        System.out.println("\n=== LA CIFRA EXACTA ===");
        System.out.println("Cada jugador realizará " + operaciones
                + " operaciones.");

        int[] numeros = generarNumeros(cantidad);
        jugar(numeros, operaciones);
    }

    public static int[] generarNumeros(int cantidad) {
        int[] numeros = new int[cantidad];

        System.out.println("Los números son:");

        for (int i = 0; i < cantidad; i++) {
            numeros[i] = generator.nextInt(10) + 1;
            System.out.println((i + 1) + ": " + numeros[i]);
        }

        int objetivo = generator.nextInt(900) + 100;
        System.out.println("El número objetivo es: " + objetivo);

        return numeros;
    }

    public static int seleccionNumeros(int[] numeros) {
        int opcion;

        do {
            System.out.print("Elige un número [1-"
                    + numeros.length + "]: ");
            opcion = leerEntero();

            if (opcion < 1 || opcion > numeros.length) {
                System.out.println("Opción no válida.");
            }
        } while (opcion < 1 || opcion > numeros.length);

        return numeros[opcion - 1];
    }

    public static double jugar(int[] numeros, int operaciones) {
        int[] resultados = new int[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("\nTurno del jugador " + (i + 1));
            int resultado = 0;

            for (int j = 1; j <= operaciones; j++) {
                System.out.println("Operación " + j);

                System.out.print("Elige el primer número: ");
                int num1 = seleccionNumeros(numeros);

                char operacion;

                while (true) {
                    System.out.print("Elige una operación (+, -, /, *): ");
                    String entrada = sc.nextLine().trim();

                    if (entrada.length() == 1
                            && "+-/*".indexOf(entrada.charAt(0)) >= 0) {
                        operacion = entrada.charAt(0);
                        break;
                    }

                    System.out.println(
                            "Operación no válida. Inténtalo de nuevo.");
                }

                System.out.print("Elige el segundo número: ");
                int num2 = seleccionNumeros(numeros);

                if (operacion == '/' && num2 == 0) {
                    System.out.println(
                            "No se puede dividir entre cero. Repite.");
                    j--;
                    continue;
                }

                switch (operacion) {
                    case '+':
                        resultado += num1 + num2;
                        break;

                    case '-':
                        resultado += num1 - num2;
                        break;

                    case '*':
                        resultado += num1 * num2;
                        break;

                    case '/':
                        resultado += num1 / num2;
                        break;
                }

                System.out.println("Resultado acumulado: " + resultado);
            }

            resultados[i] = resultado;
            System.out.println("Resultado final del jugador "
                    + (i + 1) + ": " + resultado);
        }

        System.out.println("\n=== RESULTADOS DE LA CIFRA EXACTA ===");
        System.out.println("Jugador 1: " + resultados[0]);
        System.out.println("Jugador 2: " + resultados[1]);

        if (resultados[0] > resultados[1]) {
            System.out.println("¡Gana el jugador 1!");
        } else if (resultados[1] > resultados[0]) {
            System.out.println("¡Gana el jugador 2!");
        } else {
            System.out.println("¡Empate!");
        }

        return Math.max(resultados[0], resultados[1]);
    }

    // ==================== LA PALABRA MÁS LARGA ====================

    public static void cuantasMasPalabrasMejor(int cantidadLetras) {
        System.out.println("\n=== LA PALABRA MÁS LARGA ===");

        String letras = generarLetras(cantidadLetras);
        mostrarLetras(letras);

        String[] palabras1 = new String[100];
        String[] palabras2 = new String[100];

        int cantidad1 = introducirPalabras(
                "Jugador 1", letras, palabras1);
        int cantidad2 = introducirPalabras(
                "Jugador 2", letras, palabras2);

        int incorrectas1 = comprobarPalabras("Jugador 1", cantidad1);
        int incorrectas2 = comprobarPalabras("Jugador 2", cantidad2);

        int puntos1 = calcularPuntos(cantidad1, incorrectas1);
        int puntos2 = calcularPuntos(cantidad2, incorrectas2);

        mostrarResultados(
                cantidad1, incorrectas1, puntos1,
                cantidad2, incorrectas2, puntos2);

        mostrarGanador(puntos1, puntos2);
    }

    // Generar letras garantizando cuatro vocales y cuatro consonantes.
    public static String generarLetras(int cantidad) {
        String vocales = "aeiou";
        String consonantes = "bcdfghjklmnpqrstvwxyz";
        String alfabeto = vocales + consonantes;

        StringBuilder letras = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            letras.append(
                    vocales.charAt(generator.nextInt(vocales.length())));
        }

        for (int i = 0; i < 4; i++) {
            letras.append(consonantes.charAt(
                    generator.nextInt(consonantes.length())));
        }

        while (letras.length() < cantidad) {
            letras.append(
                    alfabeto.charAt(generator.nextInt(alfabeto.length())));
        }

        // Mezclar las letras para que no aparezcan agrupadas.
        char[] resultado = letras.toString().toCharArray();

        for (int i = resultado.length - 1; i > 0; i--) {
            int j = generator.nextInt(i + 1);

            char temporal = resultado[i];
            resultado[i] = resultado[j];
            resultado[j] = temporal;
        }

        return new String(resultado);
    }

    public static void mostrarLetras(String letras) {
        System.out.println("Letras disponibles: " + letras);
    }

    public static int introducirPalabras(
            String jugador, String letras, String[] palabras) {

        int cantidad = 0;

        System.out.println("\nTurno de " + jugador);
        System.out.println("Escribe una palabra por línea.");
        System.out.println("Pulsa ENTER para terminar.");

        while (cantidad < palabras.length) {
            System.out.print("Palabra: ");

            String palabra = sc.nextLine().trim().toLowerCase();

            if (palabra.isEmpty()) {
                break;
            }

            if (!puedeFormarse(palabra, letras)) {
                System.out.println(
                        "La palabra contiene letras no disponibles.");
            } else if (repetida(palabra, palabras, cantidad)) {
                System.out.println("Ya has escrito esa palabra.");
            } else {
                palabras[cantidad] = palabra;
                cantidad++;
                System.out.println("Palabra guardada.");
            }
        }

        System.out.println(jugador + " ha escrito "
                + cantidad + " palabras.");

        return cantidad;
    }

    // Comprueba también que no se utilice una letra más veces
    // de las que aparece en las letras disponibles.
    public static boolean puedeFormarse(String palabra, String letras) {
        palabra = palabra.toLowerCase();
        letras = letras.toLowerCase();

        int[] disponibles = new int[26];

        for (int i = 0; i < letras.length(); i++) {
            char letra = letras.charAt(i);

            if (letra >= 'a' && letra <= 'z') {
                disponibles[letra - 'a']++;
            }
        }

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (letra < 'a' || letra > 'z') {
                System.out.println("Carácter no válido: " + letra);
                return false;
            }

            int indice = letra - 'a';

            if (disponibles[indice] == 0) {
                System.out.println(
                        "No hay suficientes letras disponibles: " + letra);
                return false;
            }

            disponibles[indice]--;
        }

        return true;
    }

    public static boolean repetida(
            String palabra, String[] palabras, int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            if (palabras[i].equals(palabra)) {
                return true;
            }
        }

        return false;
    }

    public static int comprobarPalabras(String jugador, int cantidad) {
        int incorrectas;

        System.out.println("\nEl oponente revisa las palabras de " + jugador);
        System.out.println("Si todas son correctas, introduce 0.");

        do {
            System.out.print(
                    "¿Cuántas palabras no existen o son incorrectas? ");

            incorrectas = leerEntero();

            if (incorrectas < 0 || incorrectas > cantidad) {
                System.out.println(
                        "Introduce un número entre 0 y " + cantidad + ".");
            }
        } while (incorrectas < 0 || incorrectas > cantidad);

        return incorrectas;
    }

    public static int calcularPuntos(int cantidad, int incorrectas) {
        return cantidad - incorrectas;
    }

    public static void mostrarResultados(
            int cantidad1, int incorrectas1, int puntos1,
            int cantidad2, int incorrectas2, int puntos2) {

        System.out.println("\n=== RESULTADOS FINALES ===");

        System.out.println("Jugador 1:");
        System.out.println("Palabras: " + cantidad1);
        System.out.println("Incorrectas: " + incorrectas1);
        System.out.println("Puntos: " + puntos1);

        System.out.println("\nJugador 2:");
        System.out.println("Palabras: " + cantidad2);
        System.out.println("Incorrectas: " + incorrectas2);
        System.out.println("Puntos: " + puntos2);
    }

    public static void mostrarGanador(int puntos1, int puntos2) {
        if (puntos1 > puntos2) {
            System.out.println("¡Gana el jugador 1!");
        } else if (puntos2 > puntos1) {
            System.out.println("¡Gana el jugador 2!");
        } else {
            System.out.println("¡Hay un empate!");
        }
    }
}
