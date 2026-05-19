import java.util.Arrays;
import java.lang.reflect.Array; // Importa a clase necesaria para usar reflexión e crear arrays dinámicos

public class Exercicio1 {
    
    /**
     * Método xenérico estático que recibe dous arrays do mesmo tipo e os une nun só.
     * Usa o parámetro de tipo <T> para adaptarse a calquera tipo de obxecto (String, Integer, etc).
     * 
     * @param t1 Primeiro array de tipo T.
     * @param t2 Segundo array de tipo T.
     * @return Un novo array de tipo T co contido de ambos, ou null se un deles non existe.
     */
    public static <T> T[] concatenarTaboas(T[] t1, T[] t2) {
        // Control de seguridade: se calquera dos dous arrays é nulo, devolvemos null
        if (t1 == null || t2 == null) return null;

        // Creamos a nova táboa dinamicamente usando o tipo compoñente da primeira.
        // @SuppressWarnings evita que o compilador mostre un aviso de aviso ("warning") polo cast directo.
        @SuppressWarnings("unchecked")
        T[] resultado = (T[]) Array.newInstance(t1.getClass().getComponentType(), t1.length + t2.length);

        // System.arraycopy realiza unha copia directa e moi rápida a nivel de memoria:
        // Copiamos t1 dende a posición 0 cara a 'resultado' dende a posición 0, copiando todo o seu tamaño
        System.arraycopy(t1, 0, resultado, 0, t1.length);
        
        // Copiamos t2 dende a posición 0 cara a 'resultado' desprazándonos 't1.length' posicións para non sobrescribir
        System.arraycopy(t2, 0, resultado, t1.length, t2.length);

        return resultado; // Devolvemos o array final totalmente concatenado
    }

    public static void main(String[] args) {
        // Arrays de proba de tipo String (clase obxecto compatible con xenéricos)
        String[] t1 = {"A", "B"};
        String[] t2 = {"C", "D", "E"};
        
        // Chamada ao método xenérico pasándolle os dous arrays de texto
        String[] resultado = concatenarTaboas(t1, t2);
        
        // Imprime o contido do array resultante por consola en formato de texto lexible
        System.out.println(Arrays.toString(resultado)); // Resultado agardado: [A, B, C, D, E]
    }
}
