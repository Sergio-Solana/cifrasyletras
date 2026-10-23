import java.util.Scanner;
import java.util.Random;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Random generator = new Random();
    public static void main(String[] args) throws Exception {
        cifraExacta();


        sc.close();
    }

    /**
     * Prueba cifra exacta
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
    /***
     * Generar los números aletorios y el número objetivo
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
}