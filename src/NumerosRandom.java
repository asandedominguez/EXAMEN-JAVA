import java.util.ArrayList;
import java.util.Random;

public class NumerosRandom {

    public static ArrayList<Integer> crearLista() {
        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(10) + 1;
            lista.add(numero);
        }

        return lista;
    }

    public static void eliminar5y7(ArrayList<Integer> lista) {
        lista.removeIf(numero -> numero == 5 || numero == 7);
    }

    public static void main(String[] args) {

        ArrayList<Integer> numeros = crearLista();
        System.out.println("Lista original:");
        System.out.println(numeros);

        eliminar5y7(numeros);

        System.out.println("Lista sin 5 y 7:");
        System.out.println(numeros);
    }
}