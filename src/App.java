import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("BIENVENIDO/A A CIFRAS Y LETRAS");
        System.out.println("Seleccione la opción del menú que desee");

    int opcion;
/* Esto es para elegir el modo de juego */
        do {
        
            System.out.println("Modo concurso [1]");
            System.out.println("Modo rápido [2]");
            System.out.println("Ajustes [3]");
            System.out.println("");
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
}

