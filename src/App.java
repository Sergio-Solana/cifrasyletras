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
        generarNumeros();

        System.out.println("Vamos a empezar hacer las cuentas");
        System.out.println(jugar(0, 0, 0, 0, 0, 0));

        
    }
    /***
     * Generar los números aletorios y el número objetivo
     */
    public static void generarNumeros(){
        int num1 = generator.nextInt(11);
        int num2 = generator.nextInt(11);
        int num3 = generator.nextInt(11);
        int num4 = generator.nextInt(11);
        int num5 = generator.nextInt(11);
        int num6 = generator.nextInt(11);
        int numObj = generator.nextInt(999) + 100;
        System.out.println("El número objetivo es: " + numObj);
        System.out.println(num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6);
        
    }
    public static double jugar(int num1, int num2, int num3, int num4, int num5, int num6){
        
        int resultado = 0;
        int numAux = resultado;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Nº de la operacion " + i);
            System.out.print("Elige un número de la lista: ");
            int num = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Elige una operacion (+, -, /, *): ");
            char operacion = sc.next().charAt(0);

            System.out.print("Elige un segundo número de la lista: ");
            int numOp = sc.nextInt();
            sc.nextLine();
            

            switch (operacion) {
                case '+':
                    resultado = num + numOp;

                    break;
                
                case '-':
                    resultado = num - numOp;
                    break;
                case '/':
                    if (numOp == 0) {
                        System.out.println("No se puede dividir entre cero");
                        i--;
                        continue;
                    }
                    resultado = num / numOp;
                    break;
                case '*':
                    resultado = num * numOp;
                    break;

                default:
                    System.out.println("Operecion no valida");
                    break;
            }
            numAux = numAux + resultado;
            System.out.println("Resultado actual: " + resultado);
        }
        return numAux;
    }
    
}
