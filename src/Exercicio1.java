import java.util.Arrays;
import java.lang.reflect.Array;

public class Exercicio1 {
    // Método xenérico estático
    public static <T> T[] concatenarTaboas(T[] t1, T[] t2) {
        if (t1 == null || t2 == null) return null;

        // Creamos a nova táboa usando o tipo da primeira
        @SuppressWarnings("unchecked")
        T[] resultado = (T[]) Array.newInstance(t1.getClass().getComponentType(), t1.length + t2.length);

        // Copiamos os elementos de ambas táboas
        System.arraycopy(t1, 0, resultado, 0, t1.length);
        System.arraycopy(t2, 0, resultado, t1.length, t2.length);

        return resultado;
    }

    public static void main(String[] args) {
        String[] t1 = {"A", "B"};
        String[] t2 = {"C", "D", "E"};
        String[] resultado = concatenarTaboas(t1, t2);
        System.out.println(Arrays.toString(resultado)); // [A, B, C, D, E]
    }
}