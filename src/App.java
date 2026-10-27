import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Random generator = new Random();
    public static void main(String[] args) {

    /*MOSTRAR EL TITULO DEL CONCURSO */
    mostrarTitulo();

    int opcion;
/* PANEL PARA ELEGIR EL MODO DE JUEGO */
        do {
            /*MOSTAR EL MENÚ */
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:laPalabraMasLarga();
                case 2:laCalculadoraHumana();
                case 3:
                case 4:
            
            
                default:
            }

                    for (int i = 0; i < repPartida; i++) {
                        System.out.println("\n=== REPETICIÓN "
                                + (i + 1) + " DE " + repPartida + " ===");

                        cifraExacta(numPartida, opsPartida);
                        cuantasMasPalabrasMejor(letrasPartida);
                    }

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

/* FUNCIÓN PARA MOSTRAR EL TÍTULO DEL JUEGO */

public static void mostrarTitulo() {

    String rosa = "\u001B[95m";
    String azul = "\u001B[94m";
    String verde = "\u001B[92m";
    String reset = "\u001B[0m";

    // CIFRAS EN ROSA
    System.out.println(rosa +
        " █████  █████  █████  █████   ███   █████\n" +
        "██        █    ██     ██  ██ ██ ██ ██    \n" +
        "██        █    ████   █████  █████  ████ \n" +
        "██        █    ██     ██ ██  ██ ██     ██\n" +
        " █████  █████  ██     ██  ██ ██ ██ █████ "
        + reset);

    System.out.println();

    // Y EN AZUL CENTRADA
    System.out.println(azul +
        "                 ██   ██\n" +
        "                  ██ ██ \n" +
        "                   ███  \n" +
        "                    █   \n" +
        "                    █   "
        + reset);

    System.out.println();

    // LETRAS EN VERDE
    System.out.println(verde +
        "██     █████ ███████ █████   ███   █████\n" +
        "██     ██      █    ██  ██ ██ ██ ██    \n" +
        "██     ████    █    █████  █████  ████ \n" +
        "██     ██      █    ██ ██  ██ ██     ██\n" +
        "██████ █████   █    ██  ██ ██ ██ █████ "
        + reset);

    System.out.println();
}


/* FUNCIÓN PARA MOSTRAR EL MENÚ PRINCIPAL */

public static void mostrarMenu() {

    String rosa = "\u001B[95m";
    String verde = "\u001B[92m";
    String azul = "\u001B[94m";
    String amarillo = "\u001B[93m";
    String reset = "\u001B[0m";

    System.out.println(azul + "======================================" + reset);
    System.out.println(amarillo + "          MENU PRINCIPAL          " + reset);
    System.out.println(azul + "======================================" + reset);

    System.out.println();
    System.out.println(rosa + "       [1] MODO CONCURSO" + reset);
    System.out.println(verde + "       [2] MODO RAPIDO" + reset);
    System.out.println(azul + "       [3] AJUSTES" + reset);
    System.out.println(amarillo + "       [4] SALIR" + reset);
    System.out.println();

    System.out.println(azul + "======================================" + reset);
    System.out.print(amarillo + "  SELECCIONA UNA OPCION [1-4]: " + reset);
}




/* SEGUNDO JUEGO: LA PALABRA MÁS LARGA */

public static int laPalabraMasLarga() {

    System.out.println("Bienvenidos a La Palabra Más Larga");

    // Generar las mismas 10 letras para ambos jugadores
    String letras = letrasAleatorias();

    int puntos1 = 0;
    int puntos2 = 0;

    System.out.println("Con estas letras disponibles tienes que formar la palabra más larga, sin repetir el uso de las letras:");

    // TURNO DEL JUGADOR 1
    puntos1 = turnoJugador(1, letras);

    // TURNO DEL JUGADOR 2
    puntos2 = turnoJugador(2, letras);

    // MOSTRAR RESULTADOS
    mostrarGanador(puntos1, puntos2);

    // DEVOLVER EL GANADOR DE LA PRUEBA
    if (puntos1 > puntos2) {
        return 1;
    } else if (puntos2 > puntos1) {
        return 2;
    } else {
        return 0;
    }
}


/* FUNCIÓN PARA GENERAR LAS VOCALES Y CONSONANTES ALEATORIAS */

public static String letrasAleatorias() {

    String vocales = "aeiou";
    String consonantes = "bcdfghjklmnñpqrstvwxyz";
    String abecedario = vocales + consonantes;
    String letras = "";

    // GENERAR 4 VOCALES
    for (int i = 0; i < 4; i++) {
        int posicion = generator.nextInt(vocales.length());
        char vocal = vocales.charAt(posicion);
        letras += vocal;
    }

    // GENERAR 4 CONSONANTES
    for (int i = 0; i < 4; i++) {
        int posicion = generator.nextInt(consonantes.length());
        char consonante = consonantes.charAt(posicion);
        letras += consonante;
    }

    // GENERAR 2 LETRAS ADICIONALES
    for (int i = 0; i < 2; i++) {
        int posicion = generator.nextInt(abecedario.length());
        char letra = abecedario.charAt(posicion);
        letras += letra;
    }

    return letras;
}


/* FUNCIÓN PARA COMPROBAR QUE LA PALABRA
   SE PUEDE FORMAR CON LAS LETRAS DISPONIBLES */

public static boolean comprobarPalabra(String palabra, String letras) {

    // RECORRER CADA LETRA DE LA PALABRA
    for (int i = 0; i < palabra.length(); i++) {

        char letra = palabra.charAt(i);

        // BUSCAR LA LETRA ENTRE LAS DISPONIBLES
        int posicion = letras.indexOf(letra);

        // SI LA LETRA NO EXISTE, DEVOLVER FALSE
        if (posicion == -1) {
            return false;
        }

        // SUSTITUIR LA LETRA UTILIZADA POR *
        // PARA QUE NO PUEDA VOLVER A UTILIZARSE
        letras = letras.substring(0, posicion) + "*" + letras.substring(posicion + 1);
    }

    // TODAS LAS LETRAS ESTÁN DISPONIBLES
    return true;
}


/* FUNCIÓN PARA REALIZAR EL TURNO DE CADA JUGADOR */

public static int turnoJugador(int jugador, String letras) {

    String verde = "\u001B[92m";
    String reset = "\u001B[0m";

    int rival;

    // DETERMINAR QUIÉN COMPRUEBA LA PALABRA
    if (jugador == 1) {
        rival = 2;
    } else {
        rival = 1;
    }

    // MOSTRAR EL TURNO EN VERDE
    System.out.println();
    System.out.println(verde + "========== JUGADOR " + jugador
            + " ==========" + reset);

    System.out.println("Letras disponibles: " + letras);
    System.out.println("Adelante jugador " + jugador);
    System.out.println("Forma la palabra más larga:");

    String palabra = sc.next().toLowerCase();

    // PRIMERO COMPROBAR AUTOMÁTICAMENTE LAS LETRAS
    if (comprobarPalabra(palabra, letras) == false) {
        System.out.println("No puedes formar esa palabra con las letras disponibles.");
        System.out.println("Has perdido tu turno.");
        return 0;
    }

    // SI LAS LETRAS SON CORRECTAS, PREGUNTAR AL RIVAL
    System.out.println("La palabra se puede formar correctamente.");
    System.out.println("Jugador " + rival
            + ", ¿la palabra existe en español?");
    System.out.println("Responde true o false:");

    boolean correcta = sc.nextBoolean();

    // SI EL RIVAL DICE QUE LA PALABRA NO EXISTE
    if (correcta == false) {
        System.out.println("La palabra no es correcta.");
        System.out.println("Has perdido tu turno.");
        return 0;
    }

    // CALCULAR LOS PUNTOS
    int puntos = palabra.length();

    System.out.println("Palabra válida.");
    System.out.println("Has conseguido " + puntos + " puntos.");

    return puntos;
}


/* FUNCIÓN PARA MOSTRAR LOS RESULTADOS Y EL GANADOR */

public static void mostrarGanador(int puntos1, int puntos2) {

    String verde = "\u001B[92m";
    String reset = "\u001B[0m";

    // MOSTRAR RESULTADOS EN VERDE
    System.out.println();
    System.out.println(verde
            + "========== RESULTADOS =========="
            + reset);

    System.out.println("Jugador 1: " + puntos1 + " puntos");
    System.out.println("Jugador 2: " + puntos2 + " puntos");

    if (puntos1 > puntos2) {
        System.out.println("Ha ganado el jugador 1");

    } else if (puntos2 > puntos1) {
        System.out.println("Ha ganado el jugador 2");

    } else {
        System.out.println("Empate");
    }
}


/* TERCER JUEGO: LA CALCULADORA HUMANA */

public static int laCalculadoraHumana() {

    String verde = "\u001B[92m";
    String reset = "\u001B[0m";

    System.out.println();
    System.out.println(verde + "========== LA CALCULADORA HUMANA ==========" + reset);

    System.out.println("Bienvenidos a La Calculadora Humana");
    System.out.println("Resuelve las operaciones lo más rápido posible.");
    System.out.println("Cada error supone 20 segundos de penalización.");

    // NÚMERO DE OPERACIONES POR JUGADOR
    int operaciones = 5;

    // TURNO DEL JUGADOR 1
    double tiempo1 = turnoCalculadora(1, operaciones);

    // TURNO DEL JUGADOR 2
    double tiempo2 = turnoCalculadora(2, operaciones);

    // MOSTRAR RESULTADOS
    System.out.println();
    System.out.println(verde + "========== RESULTADOS ==========" + reset);

    System.out.println("Jugador 1: " + tiempo1 + " segundos");
    System.out.println("Jugador 2: " + tiempo2 + " segundos");

    // COMPARAR LOS TIEMPOS
    if (tiempo1 < tiempo2) {
        System.out.println(verde + "Ha ganado el jugador 1" + reset);
        return 1;

    } else if (tiempo2 < tiempo1) {
        System.out.println(verde + "Ha ganado el jugador 2" + reset);
        return 2;

    } else {
        System.out.println(verde + "Empate" + reset);
        return 0;
    }
}


/* FUNCIÓN PARA REALIZAR EL TURNO DE CADA JUGADOR */

public static double turnoCalculadora(int jugador, int operaciones) {

    String verde = "\u001B[92m";
    String rojo = "\u001B[91m";
    String reset = "\u001B[0m";

    System.out.println();
    System.out.println(verde + "========== JUGADOR " + jugador
            + " ==========" + reset);

    // GENERAR NÚMERO INICIAL ENTRE 1 Y 100
    double numero = generator.nextInt(100) + 1;

    int errores = 0;

    System.out.println("Número inicial: " + numero);
    System.out.println("Pulsa ENTER cuando estés preparado.");

    sc.nextLine();

    // COMENZAR A MEDIR EL TIEMPO
    long inicio = System.nanoTime();

    for (int i = 1; i <= operaciones; i++) {

        // GENERAR OPERACIÓN ALEATORIA
        int operacion = generator.nextInt(4) + 1;

        int valor;
        double resultado = 0;

        System.out.println();
        System.out.println(verde + "========== OPERACIÓN " + i
                + " DE " + operaciones + " ==========" + reset);

        switch (operacion) {

            case 1:
                // SUMA: NÚMERO DE DOS CIFRAS
                valor = generator.nextInt(90) + 10;
                resultado = numero + valor;

                System.out.println(numero + " + " + valor + " = ?");
                break;

            case 2:
                // RESTA: NÚMERO DE DOS CIFRAS
                valor = generator.nextInt(90) + 10;
                resultado = numero - valor;

                System.out.println(numero + " - " + valor + " = ?");
                break;

            case 3:
                // MULTIPLICACIÓN: NÚMERO DE UNA CIFRA
                valor = generator.nextInt(9) + 1;
                resultado = numero * valor;

                System.out.println(numero + " * " + valor + " = ?");
                break;

            case 4:
                // DIVISIÓN: NÚMERO DE UNA CIFRA
                valor = generator.nextInt(9) + 1;
                resultado = numero / valor;

                System.out.println(numero + " / " + valor + " = ?");
                break;
        }

        // RESPUESTA DEL JUGADOR
        System.out.print("Tu respuesta: ");
        double respuesta = sc.nextDouble();

        // COMPROBAR LA RESPUESTA
        if (Math.abs(respuesta - resultado) < 0.000001) {
            System.out.println(verde + "¡Correcto!" + reset);

        } else {
            System.out.println(rojo + "Incorrecto." + reset);
            errores++;
        }

        System.out.println("Resultado correcto: " + resultado);

        // EL RESULTADO CORRECTO PASA A SER EL NUEVO NÚMERO
        numero = resultado;
    }

    // DETENER EL TIEMPO
    long fin = System.nanoTime();

    // CONVERTIR NANOSEGUNDOS A SEGUNDOS
    double tiempo = (fin - inicio) / 1000000000.0;

    // CALCULAR PENALIZACIONES
    int penalizacion = errores * 20;

    double tiempoFinal = tiempo + penalizacion;

    // MOSTRAR RESULTADOS DEL TURNO
    System.out.println();
    System.out.println(verde + "========== FIN DEL TURNO ==========" + reset);

    System.out.println("Tiempo empleado: " + tiempo + " segundos");
    System.out.println("Respuestas incorrectas: " + errores);
    System.out.println("Penalización: " + penalizacion + " segundos");
    System.out.println(verde + "Tiempo final: " + tiempoFinal
            + " segundos" + reset);

    sc.nextLine(); // Limpiar el salto de línea pendiente

    return tiempoFinal;
}

}
