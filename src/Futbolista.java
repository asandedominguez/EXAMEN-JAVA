import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Clase Futbolista que herda as propiedades da clase nai 'Persoa'.
 * Implementa 'Comparable' para definir un criterio de ordenación natural por defecto (o DNI).
 */
public class Futbolista extends Persoa implements Comparable<Futbolista> {

    // Atributo privado e encapsulado específico da clase Futbolista
    private int numGoles;

    /**
     * Construtor da clase Futbolista.
     * Utiliza 'super' para invocar o construtor da clase nai (Persoa) e inicializar os seus datos.
     */
    public Futbolista(String nome, String dni, int edade, double estatura, int numGoles) {
        super(nome, dni, edade, estatura); // Envía os datos comúns á clase Persoa
        this.numGoles = numGoles;          // Inicializa o atributo propio
    }

    // Métodos Getter e Setter para acceder de forma segura ao atributo privado de goles
    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }

    /**
     * Sobrescribe o método toString para dar formato de texto á información do futbolista.
     * Como os atributos da clase nai son privados, accédese a eles mediante os seus métodos 'get'.
     */
    @Override
    public String toString() {
        return "-----------------------------" +
                "\nFutbolista: " + getNome() +
                "\nDni:        " + getDni() +
                "\nEdad:       " + getEdade() +
                "\nAltura:     " + getEstatura() +
                "\nGoles:      " + numGoles +
                "\n-----------------------------";
    }

    /**
     * Sobrescribe o método equals para determinar cando dous futbolistas son iguais.
     * Neste caso, considéranse iguais se teñen o mesmo número de DNI.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Se apuntan á mesma dirección de memoria, son iguais
        if (obj == null || getClass() != obj.getClass()) return false; // Control de nulos e tipos distintos

        Futbolista outroFutbolista = (Futbolista) obj; // Cast seguro de Object a Futbolista
        // Comparación correcta de cadeas de texto (Strings) empregando o método .equals()
        return this.getDni().equals(outroFutbolista.getDni());
    }

    /**
     * Método da interface Comparable para establecer a orde natural.
     * Devolve o resultado de comparar alfabeticamente os DNIs de ambos futbolistas.
     */
    @Override
    public int compareTo(Futbolista otro) {
        return this.getDni().compareTo(otro.getDni());
    }

    /**
     * Comparador alternativo estático para ordenar futbolistas polo seu nome.
     * Ignora as diferenzas entre maiúsculas e minúsculas co método compareToIgnoreCase.
     */
    public static Comparator<Futbolista> comparadorNome = new Comparator<Futbolista>() {
        @Override
        public int compare(Futbolista f1, Futbolista f2) {
            return f1.getNome().compareToIgnoreCase(f2.getNome());
        }
    };

    /**
     * Comparador alternativo estático para ordenar futbolistas de forma numérica polos seus goles.
     * Utiliza o método nativo Integer.compare para evitar problemas de desbordamento.
     */
    public static Comparator<Futbolista> comparadorNumGoles = new Comparator<Futbolista>() {
        @Override
        public int compare(Futbolista f1, Futbolista f2) {
            return Integer.compare(f1.getNumGoles(), f2.getNumGoles());
        }
    };

    public static void main(String [] args) {
        // Instanciación de dous obxectos futbolistas de proba
        Futbolista f1 = new Futbolista("Messi","1010M",38,1.70, 672);
        Futbolista f2 = new Futbolista("Cr7","7777C",41,1.87, 971);
        
        // Imprime a ficha de cada xogador grazas ao método toString
        System.out.println(f1);
        System.out.println(f2);
        
        // Proba os métodos de comparación (compareTo e equals) por DNI
        System.out.println(f1.compareTo(f2));
        System.out.println(f1.equals(f2));

        // Comprobación de igualdade de nomes antes e despois de modificar o nome de f2
        System.out.println(f1.getNome().equals(f2.getNome()));
        f2.setNome("Messi"); // Modifica o nome mediante o setter herdado
        System.out.println(f1.getNome().equals(f2.getNome()));

        // Creación dunha lista dinámica (ArrayList) especificando o tipo xenérico <Futbolista>
        ArrayList<Futbolista> equipo = new ArrayList<>();
        Futbolista fu1 = new Futbolista("Pepe", "1553A",19,1.23,2);
        Futbolista fu2 = new Futbolista("Pablo", "1023AB",69,1.91,0);
        Futbolista fu3 = new Futbolista("Pedro", "1123C",17,2.01,3);
        
        // Engade os xogadores creados ao ArrayList
        equipo.add(fu1);
        equipo.add(fu2);
        equipo.add(fu3);
        
        // Imprime a lista completa directamente en liña
        System.out.println(equipo);

        // FORMA 1 DE PERCORRER: Empregando un bucle for tradicional baseándose no tamaño (.size())
        for (int i=0; i<equipo.size(); i++) {
            System.out.println(equipo.get(i)); // Extrae cada elemento co método .get(i)
        }

        // FORMA 2 DE PERCORRER: Empregando un Iterator para avanzar secuencialmente pola colección
        Iterator<Futbolista> it = equipo.iterator();
        while (it.hasNext()) { // Mentres queden elementos por ler...
            System.out.println(it.next()); // Avanza o punteiro e devolve o obxecto Futbolista actual
        }
    }
}
