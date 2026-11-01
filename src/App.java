import java.util.Random;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Random generator = new Random();
    // Variables de configuración
    static int repeticiones = 1;
    static int cantidadNumeros = 6;
    static int cantidadLetras = 10;
    static int cantidadOperaciones = 5;

    public static void main(String[] args) {

        /*MOSTRAR EL TITULO DEL CONCURSO */
        mostrarTitulo();

        int opcion;

        /* PANEL PARA ELEGIR EL MODO DE JUEGO */
        do {
            /*MOSTRAR EL MENÚ */
            mostrarMenu();
            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    // MODO CONCURSO
                    for (int i = 0; i < repeticiones; i++) {
                        System.out.println("\\n=== REPETICIÓN "
                                + (i + 1) + " DE " + repeticiones + " ===");
                        cifraExacta();
                        laPalabraMasLarga();
                        laCalculadoraHumana();
                        cuantasMasPalabrasMejor(cantidadLetras);
                    }
                    break;

                case 2:
                    modoRapido();
                    break;

                case 3:
                    menuConfiguracion();
                    break;

                case 4:
                    System.out.println("Hasta pronto.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

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
public static void modoRapido(){
    int opcion = 0;
    do{
        System.out.println("[1] La cifra exacta");
        System.out.println("[2] La palabra más larga");
        System.out.println("[3] La calculadora humana");
        System.out.println("[4] Prueba original");
        System.out.println("[5] Salir al menu principal");
        System.out.print("Elige una opcion [1-4]: ");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                cifraExacta();
                break;
            case 2:
                laPalabraMasLarga();
                break;
            case 3:
                laCalculadoraHumana();
                break;
            case 4:
                cuantasMasPalabrasMejor(opcion);
                break;
            case 5:
                System.out.println("Saliendo al menu principal");
                break;
        }
    }while(opcion != 5);
}

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
                System.out.println("El valor debe estar entre " + minimo + " y " + maximo + ".");
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
            System.out.println("4. Cantidad de operaciones: " + cantidadOperaciones);
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    repeticiones = leerValor("Repeticiones (1-20): ", 1, 20);
                    break;

                case 2:
                    cantidadNumeros = leerValor("Cantidad de números (1-10): ", 1, 10);
                    break;

                case 3:
                    cantidadLetras = leerValor("Cantidad de letras (8-26): ", 8, 26);
                    break;

                case 4:
                    cantidadOperaciones = leerValor("Cantidad de operaciones (1-20): ", 1, 20);
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

    public static void cifraExacta() {

        int objetivo = generator.nextInt(900) + 100;

        int[] numeros = new int[6];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = generator.nextInt(10) + 1;
        }

        System.out.println("===== CIFRA EXACTA =====");
        System.out.println("Numero objetivo: " + objetivo);

        System.out.println("\nNumeros a elegir:");

        mostrarNumeros(numeros);

        // Turno del jugador 1
        System.out.println("\n===== TURNO JUGADOR 1 =====");
        double resultado1 = jugar(numeros);

        // Turno del jugador 2
        System.out.println("\n===== TURNO JUGADOR 2 =====");
        double resultado2 = jugar(numeros);

        // Calcular diferencias
        double diferencia1 = Math.abs(objetivo - resultado1);
        double diferencia2 = Math.abs(objetivo - resultado2);

        System.out.println("\n===== RESULTADOS =====");

        System.out.println("Numero objetivo: " + objetivo);

        System.out.println("Resultado jugador 1: " + resultado1);
        System.out.println("Diferencia: " + diferencia1);

        System.out.println("Resultado jugador 2: " + resultado2);
        System.out.println("Diferencia: " + diferencia2);

        // Determinar ganador
        if (diferencia1 < diferencia2) {
            System.out.println("\n¡GANA EL JUGADOR 1!");

        } else if (diferencia2 < diferencia1) {
            System.out.println("\n¡GANA EL JUGADOR 2!");

        } else {
            System.out.println("\n¡EMPATE!");
        }
    }

    // Funcion para jugar las cinco operaciones
    public static double jugar(int[] numeros) {

        double resultado = 0;

        for (int i = 1; i <= 5; i++) {

            System.out.println("\nOperacion " + i);

            mostrarNumeros(numeros);

            if (i == 1) {

                // Primera operacion: seleccionar dos numeros
                int posicion1 = pedirPosicion(numeros.length);
                int numero1 = numeros[posicion1];

                int posicion2 = pedirPosicion(numeros.length);
                int numero2 = numeros[posicion2];

                resultado = operar(numero1, numero2);

            } else {

                // Siguientes operaciones: seleccionar un numero
                System.out.println("Resultado anterior: " + resultado);

                int posicion = pedirPosicion(numeros.length);
                int numero = numeros[posicion];

                resultado = operar(resultado, numero);
            }

            System.out.println("Resultado obtenido: " + resultado);
        }

        return resultado;
    }

    // Mostrar la lista de numeros
    public static void mostrarNumeros(int[] numeros) {

        System.out.println("Lista de numeros:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.println((i + 1) + ". " + numeros[i]);
        }
    }

    // Pedir la posicion de un numero
    public static int pedirPosicion(int longitud) {

        int posicion;

        do {
            System.out.print("Selecciona la posicion del numero (1-"
                    + longitud + "): ");

            posicion = sc.nextInt();

            if (posicion < 1 || posicion > longitud) {
                System.out.println("Posicion incorrecta. Intentalo de nuevo.");
            }

        } while (posicion < 1 || posicion > longitud);

        return posicion - 1;
    }

    // Realizar una operacion matematica
    public static double operar(double num1, double num2) {

    int opcion = 0;

    System.out.println("\nSelecciona una operacion:");
    System.out.println("1. Suma");
    System.out.println("2. Resta");
    System.out.println("3. Multiplicacion");
    System.out.println("4. Division");

    do {

        System.out.print("Opcion: ");

        if (sc.hasNextInt()) {
            opcion = sc.nextInt();
        } else {
            System.out.println("Debes introducir un numero entero.");
            sc.next();
            opcion = 0;
            continue;
        }

        if (opcion < 1 || opcion > 4) {
            System.out.println("Operacion incorrecta.");
        }

        if (opcion == 4 && num2 == 0) {
            System.out.println("No se puede dividir entre cero.");
            opcion = 0;
        }

    } while (opcion < 1 || opcion > 4);

    switch (opcion) {

        case 1:
            return num1 + num2;

        case 2:
            return num1 - num2;

        case 3:
            return num1 * num2;

        case 4:
            return num1 / num2;

        default:
            return 0;
    }
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

    public static int introducirPalabras(String jugador, String letras, String[] palabras) {

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

        System.out.println(jugador + " ha escrito " + cantidad + " palabras.");

        return cantidad;
    }

    // Comprueba también que no se utilice una letra más veces
    // de las que aparece en las letras disponibles.
    public static boolean puedeFormarse(String palabra, String letras) {
        palabra = palabra.toLowerCase();
        letras = letras.toLowerCase();

        int[] disponibles = new int[Character.MAX_VALUE + 1];

        for (int i = 0; i < letras.length(); i++) {
            char letra = letras.charAt(i);
            disponibles[letra]++;
        }

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (!Character.isLetter(letra)) {
                System.out.println("Carácter no válido: " + letra);
                return false;
            }

            if (disponibles[letra] == 0) {
                System.out.println(
                        "No hay suficientes letras disponibles: " + letra);
                return false;
            }

            disponibles[letra]--;
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

}
