import java.util.Scanner;

public class buclesJava {
    public static void main (String[] args) {
        int contador = 0;
        while (contador <= 5) {
            System.out.println(contador);
            contador++;
        }
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("Elije una opcion");
            System.out.println("1 Saludar");
            System.out.println("2 Despedir");
            System.out.println("3 Sair");
            String op = teclado.nextLine();


            switch (opcion) {
                case 1:
                    opcion++;
                    System.out.println("Saludos");
                    break;
                case 2:
                    opcion++;
                    System.out.println("Despedir");
                    break;
                case 3:
                    opcion++;
                    System.out.println("Saliendo");
                    break;
            }//fin switch

            //bucle definido for


            for ( int i = 5; i < 20; i +=3) {
                System.out.println("Indice: "+i);   }
        }









    }




}
