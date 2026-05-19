import java.util.HashSet;
import java.util.Set;

public class Exercicio7e8 {

    /**
     * Exercicio 7: Operación Unión de dous conxuntos.
     * Combina todos os elementos de ambos conxuntos nun único conxunto novo.
     * Como se emprega a interface Set, os duplicados elimínanse automaticamente.
     * 
     * @param <E> O tipo xenérico dos elementos que conteñen os conxuntos.
     * @param conxunto1 Primeiro conxunto de elementos.
     * @param conxunto2 Segundo conxunto de elementos.
     * @return Un novo Set que contén a unión de ambos parámetros.
     */
    static <E> Set<E> union(Set<E> conxunto1, Set<E> conxunto2) {
        // Creamos un novo conxunto copiando inicialmente tódolos elementos de conxunto1
        Set<E> resultado = new HashSet<>(conxunto1);
        
        // .addAll() engade todos os elementos do conxunto2.
        // Os elementos que xa existían non se repiten debido ás propiedades do Set.
        resultado.addAll(conxunto2); 
        
        return resultado; // Devolvemos o conxunto final resultante
    }

    /**
     * Exercicio 8: Operación Intersección de dous conxuntos.
     * Illa e devolve unicamente os elementos que están presentes en ambos conxuntos ao mesmo tempo.
     * 
     * @param <E> O tipo xenérico dos elementos que conteñen os conxuntos.
     * @param conxunto1 Primeiro conxunto de elementos.
     * @param conxunto2 Segundo conxunto de elementos.
     * @return Un novo Set que contén só os elementos comúns.
     */
    static <E> Set<E> interseccion(Set<E> conxunto1, Set<E> conxunto2) {
        // Creamos un novo conxunto clonando de partida o contido de conxunto1
        Set<E> resultado = new HashSet<>(conxunto1);
        
        // .retainAll() realiza a intersección baleirando do conxunto calquera elemento
        // que NON estea incluído tamén dentro de conxunto2 (mantén só os comúns).
        resultado.retainAll(conxunto2); 
        
        return resultado; // Devolvemos o conxunto cos elementos comúns
    }
}

