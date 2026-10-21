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
        
    }

    public static void generarNumeros(){
        int num1 = generator.nextInt(11);
        int num2 = generator.nextInt(11);
        int num3 = generator.nextInt(11);
        int num4 = generator.nextInt(11);
        int num5 = generator.nextInt(11);
        int num6 = generator.nextInt(11);
        
        System.out.println(num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6 ); 
    }
    
}
