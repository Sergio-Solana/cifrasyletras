import java.util.Random;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Random generator = new Random();
    public static void main(String[] args) {
        System.out.println("BIENVENIDO/A A CIFRAS Y LETRAS");
        System.out.println("Seleccione la opción del menú que desee");

    int opcion;
/* PANEL PARA ELEGIR EL MODO DE JUEGO */
        do {
            
            System.out.println("Modo concurso [1]");
            System.out.println("Modo rápido [2]");
            System.out.println("Ajustes [3]");
            System.out.println("Elige una de las opciones de 1 al 3");
            opcion = sc.nextInt();
            sc.nextLine();

            
            switch (opcion) {
                case 1:
                case 2:
                case 3:
            
            
                default:
            }

        } while (opcion != 0);

        sc.close();
    }
/*SEGUNDO JUEGO, LA PALABRA MÁS LARGA */

    public static void laPalabraMasLarga() {
        System.out.println("Bienvenida/o a la prueba de: La Palabra Más Larga");
        String letras = letrasAleatorias();

        String palabra1;
        String palabra2;

        boolean correcta1;
        boolean correcta2;

        int puntos1 = 0;
        int puntos2 = 0;

/* TURNO DEL JUGADOR 1 */

            System.out.println("Forma la palabra más larga que se te ocurra con estas letras" + letrasAleatorias());
            System.out.println("Adelante jugador 1");
            palabra1 = sc.next();
            System.out.println("Jugador 2, ¿La palabra es correcta, responde con true o false?");
            correcta1 = sc.nextBoolean();

            if (correcta1 == true) {
                puntos1 = palabra1.length();
            }
/* TURNO DEL JUGADOR 2 */

            System.out.println("Forma la palabra más larga que se te ocurra con estas letras" + letrasAleatorias());
            System.out.println("Adelante jugador 2");
            palabra2 = sc.next();
            System.out.println("Jugador 1, ¿La palabra es correcta, responde con true o false?");
            correcta2 = sc.nextBoolean();

            if (correcta2 == true) {
                puntos2 = palabra2.length();
            }
/* RESULTADOS Y GANADOR */ 

            System.out.println("LOS RESULTADOS SON");
            System.out.println("Jugador 1 tienes" + puntos1 + "puntos");
            System.out.println("Jugador 2 tienes" + puntos2 + "puntos");

            if (puntos1 > puntos2) {
                System.out.println("Ha ganado el jugador 1");
            } else if (puntos2 > puntos1) {
                System.out.println("Ha ganado el jugador ");
            } else {
                System.out.println("Empate");
            }
    }
/* FUNCION PARA GENERAR LA VOCALES Y CONSONANTES ALEATORIAS */

    public static String letrasAleatorias() {

        String vocales = "aeiou";
        String consonantes = "bcdfghjklmnñpqrstvwxyz";
        String abecedario = vocales + consonantes;
        String letras = "";

        for (int i = 0; i < 4; i++) {
            int posicion = generator.nextInt(vocales.length());
            char vocal = vocales.charAt(posicion);
            letras += vocal;
        }

        for (int i = 0; i < 4; i++) {
            int posicion = generator.nextInt(consonantes.length());
            char consonante = consonantes.charAt(posicion);
            letras += consonante;
            
        }

        for (int i = 0; i < 2; i++) {
            int posicion = generator.nextInt(abecedario.length());
            char letra = abecedario.charAt(posicion);
            letras += letra;
        }
    return letras;
    }

/* TERCER JUEGO, LA CALCULADORA HUMANA */








}



