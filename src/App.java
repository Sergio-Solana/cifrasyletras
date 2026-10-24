import java.util.Scanner;
import java.util.Random;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Random generator = new Random();
    public static void main(String[] args) throws Exception {
        cifraExacta();
        cuantasMasPalabrasMejor();


        sc.close();
    }

    /**
     * Juego dela cifra exacta
     */

    public static void cifraExacta(){
        System.out.println("Bienvenido a la prueba de cifra exacta");
        System.out.println("Acontinuacion de les mostraran seis números aleatorios entre 0 y 10 y usted tendras que hacer cinco operaciones matemáticas para obtener el número más alto posible, el jugador que obtenga el número más alto ganara esta prueba. Comenzemos");
        System.out.println("Los números son: ");
        int[] numeros = generarNumeros();

        System.out.println("Vamos a empezar hacer las cuentas");
        
        double resultado = jugar(numeros[0], numeros[1], numeros[2], numeros[4], numeros[5], 0);
        System.out.println(jugar(0, 0, 0, 0, 0, 0));

        System.out.println("Resultado del último jugador: " + resultado);
    }
    /**
     * Genera numeros aleatorios
     * @return devuelve los numeros generados
     */
    public static int[] generarNumeros(){
        int num1 = generator.nextInt(11) + 1;
        int num2 = generator.nextInt(11) + 1;
        int num3 = generator.nextInt(11) + 1;
        int num4 = generator.nextInt(11) + 1;
        int num5 = generator.nextInt(11) + 1;
        int num6 = generator.nextInt(11) + 1;
        int numObj = generator.nextInt(999) + 100;
        System.out.println("El número objetivo es: " + numObj);
        System.out.println("1: " + num1);
        System.out.println("2: " + num2);
        System.out.println("3: " + num3);
        System.out.println("4: " + num4);
        System.out.println("5: " + num5);
        System.out.println("6: " + num6);
        
        return new int[]{num1, num2, num3, num4, num5, num6};
    }

    /**
     *  Elige los numeros con los que quiere hacer la operacion
     * @param num1 primer numero generado aletoriamente
     * @param num2 segundo numero generado aletoriamente
     * @param num3 tercer numero generado aletoriamente
     * @param num4 cuarto numero generado aletoriamente
     * @param num5 quinto numero generado aletoriamente
     * @param num6 sexto numero generado aletoriamente
     * @return devuelve el numero elegido por el jugador
     */
    public static int seleccionNumeros(int num1, int num2, int num3, int num4, int num5, int num6){
        
        int seleccionado = 0;
        System.out.print("Elige un número[1-6]: " );
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                seleccionado = num1;
                break;
            case 2:
                seleccionado = num2;
                break;
            case 3:
                seleccionado = num3;
                break;
            case 4:
                seleccionado = num4;
                break;
            case 5:
                seleccionado = num5;
                break;
            case 6:
                seleccionado = num6;
                break;
        
            default:
                System.out.println("Opción no valida. Se utilizará 0");
                break;
        }
        return seleccionado;
    }

    /**
     * 
     * @param num1 primer numero generado aletoriamente
     * @param num2 segundo numero generado aletoriamente
     * @param num3 tercer numero generado aletoriamente
     * @param num4 cuarto numero generado aletoriamente
     * @param num5 quinto numero generado aletoriamente
     * @param num6 sexto numero generado aletoriamente
     * @return de vuelve que jugador ha ganado esta partida
     */
    public static double jugar(int num1, int num2, int num3,int num4, int num5, int num6) {
        int resultadoJugador1 = 0;
        int resultadoJugador2 = 0;
        

        for (int i = 1; i <= 2; i++) {
            System.out.println("Jugador " + i);
            int numAux = 0;

            for (int j = 1; j <= 5; j++) {
                System.out.println("Nº de la operación " + j);
                System.out.print("Elige el primer número de la lista: ");
                int num = seleccionNumeros(num1, num2, num3, num4, num5, num6);

                System.out.print("Elige una operación (+, -, /, *): ");
                char operacion = sc.next().charAt(0);

                System.out.print("Elige el segundo número de la lista: ");
                int numOp = seleccionNumeros(num1, num2, num3, num4, num5, num6);

                switch (operacion) {
                    case '+':
                        numAux += num + numOp ;
                        break;

                    case '-':
                        numAux += num - numOp ;
                        break;

                    case '/':
                        numAux +=  num / numOp;
                    break;

                    case '*':
                        numAux += num * numOp;
                        break;

                    default:
                        System.out.println("Operación no válida.");
                        j--;
                        break;
                }

                System.out.println("Resultado de la operacion: " + numAux);
            }

            System.out.println("Resultado final del jugador " + i + ": " + numAux);
            if (i==0) {
                resultadoJugador1 = numAux;
            } else {
                resultadoJugador2 = numAux;
            }
        }

        System.out.println("=== Resultado de la partida ===");
        System.out.println("Jugador 1: " + resultadoJugador1);
        System.out.println("Jugador 2: " + resultadoJugador2);

        if (resultadoJugador1 > resultadoJugador2) {
            System.out.println("¡Jugador 1 es el ganador!");
        } else if (resultadoJugador2 > resultadoJugador1) {
            System.out.println("¡Jugador 2 es el ganador!");
        } else {
            System.out.println("¡empate!");
        }

        return Math.max(resultadoJugador1, resultadoJugador2);
    }

    /**
     * Cuarto juego gana quien escriba más palabras
     */
    
    public static void cuantasMasPalabrasMejor() {
        String letras = generarLetras();

        mostrarLetras(letras);

        String[] palabras1 = new String[100];
        String[] palabras2 = new String[100];

        int cantidad1 = introducirPalabras("Jugador 1", letras, palabras1);
        int cantidad2 = introducirPalabras("Jugador 2", letras, palabras2);

        int incorrectas1 = comprobarPalabras("Jugador 1", cantidad1);
        int incorrectas2 = comprobarPalabras("Jugador 2", cantidad2);

        int puntos1 = calcularPuntos(cantidad1, incorrectas1);
        int puntos2 = calcularPuntos(cantidad2, incorrectas2);

        mostrarResultados(cantidad1, incorrectas1, puntos1, cantidad2, incorrectas2, puntos2);

        mostrarGanador(puntos1, puntos2);
    }

    /***
     * Generar las letras del juego
     * @return las letras que van a utilizar
     */
    public static String generarLetras() {
    String vocales = "aeiou";
    String alfabeto = "abcdefghijklmnopqrstuvwxyz";
    String letras = "";

    for (int i = 0; i < 4; i++) {
        int posicion = generator.nextInt(vocales.length());
        letras += vocales.charAt(posicion);
    }


    for (int i = 0; i < 10; i++) {
        int posicion = generator.nextInt(alfabeto.length());
        letras += alfabeto.charAt(posicion);
    }

    return letras;
    }

    /**
     * mostraremos las letras por pantallas
     * @param letras letras generadas
     */
    public static void mostrarLetras(String letras) {
        System.out.println("=== ===");
        System.out.println("Letras disponibles: " + letras);
    }

    /**
     * Introducir las palabras por el jugador
     * @param jugador el jugador que hasta jugando
     * @param letras letras de las palabras
     * @param palabras palabras esctritas
     * @return las cantidad de palbras esctritas
     */
    public static int introducirPalabras(String jugador, String letras, String[] palabras) {

    int cantidad = 0;

    System.out.println("Turno de " + jugador);
    System.out.println("Escribe una palabra por linea.");
    System.out.println("Pulsa ENTER para terminar.");

    while (cantidad < palabras.length) {
        System.out.print("Palabra: ");

        String palabra = sc.nextLine().toLowerCase();

        if (palabra.equals("")) {
            break;
        }

        if (!puedeFormarse(palabra, letras)) {
            System.out.println("La palabra contiene letras no disponibles.");
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

    /**
     * Comprobar que las letras de la palabra estan entre las generadas
     * @param palabra palabra escritas
     * @param letras letras generadas
     * @return si la palabra se puede escribir con las letras generadas
     */
    public static boolean puedeFormarse(String palabra, String letras) {

    palabra = palabra.toLowerCase();
    letras = letras.toLowerCase();

    for (int i = 0; i < palabra.length(); i++) {
        char letra = palabra.charAt(i);

        boolean encontrada = false;

        for (int j = 0; j < letras.length(); j++) {
            if (letra == letras.charAt(j)) {
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Letra no encontrada: " + letra);
            return false;
        }
    }

    return true;
    }


    /**
     *  Si la palabra esta ya escrita
     * @param palabra la palabra escrita
     * @param palabras las palabras ya escritas
     * @param cantidad numeros de palabra
     * @return si la palabra ya ha sido escrita
     */
    public static boolean repetida(
            String palabra, String[] palabras, int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            if (palabras[i].equals(palabra)) {
                return true;
            }
        }

        return false;
    }

    /**
     * comprobar si las palabras existen o estan bien escritas
     * @param jugador jugador opente
     * @param cantidad palabras escritas
     * @return de vuelve el nº de palabras mal escritas
     */
    public static int comprobarPalabras(String jugador, int cantidad) {
    int incorrectas;

    System.out.println("Si estan todas bien introduce 0");
    System.out.println("El oponente revisa las palabras de " + jugador);

    do {
        System.out.print("¿Cuantas palabras no existen? ");
        incorrectas = sc.nextInt();
        sc.nextLine();

        if (incorrectas < 0 || incorrectas > cantidad) {
            System.out.println("Introduce un numero entre 0 y " + cantidad);
        }

    } while (incorrectas < 0 || incorrectas > cantidad);

    return incorrectas;
    }

    /**
     * Calcular los puntos
     * @param cantidad nº de palabras escritas
     * @param incorrectas nº de palabras incorrecta
     * @return los puntos finales obtenido por el jugador
     */
    public static int calcularPuntos(int cantidad, int incorrectas) {
        return cantidad - incorrectas;
    }

    /**
     * Mostrar resultado de los dos jugadores
     * @param cantidad1 nº de palabras del primer jugador
     * @param incorrectas1 nº de palabras incorrectas del primer jugador
     * @param puntos1 puntos del primer jugador
     * @param cantidad2 nº de palabras del segundo jugador
     * @param incorrectas2 nº de palabras incorrectas del segundo jugador
     * @param puntos2 puntos del segundo jugador
     */
    public static void mostrarResultados(
            int cantidad1, int incorrectas1, int puntos1,
            int cantidad2, int incorrectas2, int puntos2) {

        System.out.println("\n=== RESULTADOS FINALES ===");

        System.out.println("Jugador 1:");
        System.out.println("Palabras: " + cantidad1);
        System.out.println("Incorrectas: " + incorrectas1);
        System.out.println("Puntos: " + puntos1);

        System.out.println("Jugador 2:");
        System.out.println("Palabras: " + cantidad2);
        System.out.println("Incorrectas: " + incorrectas2);
        System.out.println("Puntos: " + puntos2);
    }

    /**
     * Ver quien es el ganador
     * @param puntos1 puntos del primer jugador
     * @param puntos2 puntos del segundo jugador
     */
    public static void mostrarGanador(int puntos1, int puntos2) {
        if (puntos1 > puntos2) {
            System.out.println("¡Gana el Jugador 1!");
        } else if (puntos2 > puntos1) {
            System.out.println("¡Gana el Jugador 2!");
        } else {
            System.out.println("¡Hay un empate!");
        }
    }
}