import java.util.ArrayList;
import java.util.Random;

public class NumerosRandom {

    /**
     * MÉTODO A: Crea e enche unha lista dinámica con 100 números aleatorios.
     * 
     * @return Un ArrayList de Integer cos números xerados.
     */
    public static ArrayList<Integer> crearLista() {
        // Instanciamos un ArrayList para almacenar obxectos de tipo Integer
        ArrayList<Integer> lista = new ArrayList<>();
        // Creamos o obxecto da clase Random para xerar os valores numéricos
        Random random = new Random();

        // Bucle que se repite exactamente 100 veces
        for (int i = 0; i < 100; i++) {
            // random.nextInt(10) devolve un valor de 0 a 9. Ao sumar 1, o rango pasa a ser de 1 a 10
            int numero = random.nextInt(10) + 1;
            lista.add(numero); // Engadimos o número ao final da lista dinámica
        }

        return lista; // Devolvemos a lista completamente cargada de datos
    }

    /**
     * MÉTODO B: Elimina de forma directa todos os elementos que cumpran a condición de ser 5 ou 7.
     * Como en Java os obxectos pásanse por referencia, as modificacións afectan á lista orixinal.
     * 
     * @param lista O ArrayList de enteiros que se quere filtrar.
     */
    public static void eliminar5y7(ArrayList<Integer> lista) {
        // .removeIf() percorre internamente a colección de forma eficiente.
        // Utiliza unha expresión lambda (numero -> ...) para avaliar cada elemento.
        // Se a condición dá 'true' (o número é un 5 ou un 7), elimínao de xeito seguro sen romper o fluxo.
        lista.removeIf(numero -> numero == 5 || numero == 7);
    }

    public static void main(String[] args) {

        // 1. Chamamos ao método estático para obter unha nova lista de 100 enteiros
        ArrayList<Integer> numeros = crearLista();
        System.out.println("Lista original:");
        System.out.println(numeros); // Imprime por consola a lista inicial entre corchetes

        // 2. Executamos o método de filtrado pasándolle a nosa colección como parámetro
        eliminar5y7(numeros);

        // 3. Amosamos o resultado final para comprobar que xa non contén ningún 5 nin ningún 7
        System.out.println("Lista sin 5 y 7:");
        System.out.println(numeros);
    }
}
