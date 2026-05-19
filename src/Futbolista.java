import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

// CORREGIDO: Cambiado a Comparable<Futbolista> para que coincida con tu método compareTo
public class Futbolista extends Persoa implements Comparable<Futbolista> {

    // CORREGIDO: Atributo privado para cumplir con el encapsulamiento
    private int numGoles;

    public Futbolista(String nome, String dni, int edade, double estatura, int numGoles) {
        super(nome, dni, edade, estatura);
        this.numGoles = numGoles;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }

    @Override
    public String toString() {
        // CORREGIDO: Uso de getters de la clase madre porque los atributos son privados
        return "-----------------------------" +
                "\nFutbolista: " + getNome() +
                "\nDni:        " + getDni() +
                "\nEdad:       " + getEdade() +
                "\nAltura:     " + getEstatura() +
                "\nGoles:      " + numGoles +
                "\n-----------------------------";
    }

    @Override
    public boolean equals(Object obj) {
        // CORREGIDO: Control de nulos y verificación de tipo para evitar crashes
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Futbolista otroFutbolista = (Futbolista) obj;
        // CORREGIDO: Comparación de Strings con .equals() y usando getter
        return this.getDni().equals(outroFutbolista.getDni());
    }

    // CORREGIDO: Ahora coincide exactamente con la interfaz Comparable<Futbolista>
    @Override
    public int compareTo(Futbolista otro) {
        return this.getDni().compareTo(otro.getDni());
    }

    // CORREGIDO: Uso de getters para acceder a los datos privados de la clase madre
    public static Comparator<Futbolista> comparadorNome = new Comparator<Futbolista>() {
        @Override
        public int compare(Futbolista f1, Futbolista f2) {
            return f1.getNome().compareToIgnoreCase(f2.getNome());
        }
    };

    public static Comparator<Futbolista> comparadorNumGoles = new Comparator<Futbolista>() {
        @Override
        public int compare(Futbolista f1, Futbolista f2) {
            return Integer.compare(f1.getNumGoles(), f2.getNumGoles());
        }
    };

    public static void main(String [] args) {
        Futbolista f1 = new Futbolista("Messi","1010M",38,1.70, 672);
        Futbolista f2 = new Futbolista("Cr7","7777C",41,1.87, 971);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f1.compareTo(f2));
        System.out.println(f1.equals(f2));

        // CORREGIDO: Uso de getNome() en lugar del acceso directo al atributo privado
        System.out.println(f1.getNome().equals(f2.getNome()));
        f2.setNome("Messi");
        System.out.println(f1.getNome().equals(f2.getNome()));

        // CORREGIDO: Añadido el operador diamante <Futbolista> para evitar advertencias de tipos crudos
        ArrayList<Futbolista> equipo = new ArrayList<>();
        Futbolista fu1 = new Futbolista("Pepe", "1553A",19,1.23,2);
        Futbolista fu2 = new Futbolista("Pablo", "1023AB",69,1.91,0);
        Futbolista fu3 = new Futbolista("Pedro", "1123C",17,2.01,3);
        equipo.add(fu1);
        equipo.add(fu2);
        equipo.add(fu3);
        System.out.println(equipo);

        for (int i=0; i<equipo.size(); i++) {
            System.out.println(equipo.get(i));
        }

        Iterator<Futbolista> it = equipo.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
//SOLUCIÓN PARA ERRORES
// SOLUCIÓN: Quitamos el "implements Comparable" redundante y conflictivo
//public class Futbolista extends Persoa {

    // ... (El resto de tus atributos y constructores se quedan exactamente igual)

    // SOLUCIÓN: Cambiamos el parámetro a 'Persoa' para cumplir el contrato heredado
//    @Override
//    public int compareTo(Persoa otra) {
        // Hacemos un casting seguro a Futbolista si fuera necesario,
        // pero como el DNI está en la clase de arriba, podemos usar getDni() directamente
//        return this.getDni().compareTo(otra.getDni());
//    }

    // ... (El resto de tus comparadores y el método main se quedan exactamente igual)
//}
