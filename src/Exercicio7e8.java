import java.util.HashSet;
import java.util.Set;

public class Exercicio7e8 {

    // Exercicio 7: Unión
    static <E> Set<E> union(Set<E> conxunto1, Set<E> conxunto2) {
        Set<E> resultado = new HashSet<>(conxunto1);
        resultado.addAll(conxunto2); // Engade todos sen duplicar
        return resultado;
    }

    // Exercicio 8: Intersección
    static <E> Set<E> interseccion(Set<E> conxunto1, Set<E> conxunto2) {
        Set<E> resultado = new HashSet<>(conxunto1);
        resultado.retainAll(conxunto2); // Mantén só os comúns
        return resultado;
    }
}