import java.util.Arrays;

/**
 * Clase que representa a unha Persoa.
 * Implementa 'Comparable<Persoa>' para definir a súa orde natural (por DNI).
 */
public class Persoa implements Comparable<Persoa>{
    // Atributos privados para cumprir cos criterios de ocultación de información (encapsulamento)
    private String nome;
    private String dni;
    private int edade;
    private double estatura;

    /**
     * Construtor por defecto (sen parámetros).
     * Inicializa as variables con valores neutros ou predeterminados e seguros.
     */
    public Persoa() {
        nome = "";
        dni = "0000000F";
        edade = 0;
        estatura = 0;
    }

    /**
     * Construtor parametrizado completo.
     * Permite instanciar unha persoa asignándolle directamente tódolos seus datos.
     */
    public Persoa(String nome, String dni, int edade, double estatura) {
        this.nome = nome;
        this.dni = dni;
        this.edade = edade;
        this.estatura = estatura;
    }

    // Métodos Getter e Setter para o acceso e modificación segura de 'nome'
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Métodos Getter e Setter para o acceso e modificación segura de 'edade'
    public int getEdade() {
        return this.edade;
    }
    public void setEdade(int edade) {
        this.edade = edade;
    }

    // Métodos Getter e Setter para o acceso e modificación segura de 'dni'
    public String getDni() {
        return this.dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Método utilitario para imprimir directamente os datos estruturados por consola.
     */
    public void mostrarDatos() {
        System.out.println("Nome: " + nome + " Dni: " + dni + " Edade: " + edade + " Estatura: " + estatura);
    }

    /**
     * Sobrescribe o método equals herdado de Object.
     * Criterio actual: considera que dúas persoas son iguais se teñen exactamente a mesma estatura.
     */
    @Override
    public boolean equals(Object outro) {
        Persoa outroPersoa = (Persoa) outro; // Cast obrigatorio de Object a Persoa
        if (this.estatura == outroPersoa.estatura) return true;
        return false;
    }

    /**
     * Sobrescribe o método compareTo da interface Comparable.
     * Establece o criterio de ordenación natural alfabeticamente a través do DNI.
     * 
     * @return Número negativo se este DNI vai antes, cero se son iguais, positivo se vai despois.
     */
    @Override
    public int compareTo(Persoa outra) {
        /* Bloque comentado alternativo:
        int resultadoCom = this.dni.compareTo(outra.dni);
        System.out.println(resultadoCom);
        if (resultadoCom > 0) return 1;
        else if (resultadoCom < 0) return -1;
        return 0; */
        
        // Devolve directamente o resultado nativo da comparación de Strings
        return this.dni.compareTo(outra.dni);
    }

    /**
     * Sobrescribe o método toString para dar unha representación textual lexible do obxecto.
     */
    public String toString() {
        return nome + ", " + dni + ", " + edade + ", " + estatura;
    }

    public static void main(String [] args) {
        // Creación e inicialización de varios obxectos Persoa
        Persoa p1 = new Persoa();
        Persoa p2 = new Persoa("Manuel","1234F",45,1.67);
        
        // Uso obrigatorio dos getters para ler as variables privadas dende o método main estático
        System.out.println(p1.getNome());
        System.out.println(p2.getNome() + " " + p2.getDni() + " " + p2.getEdade());
        
        Persoa p3 = new Persoa("Pepe","4567H",35,1.64);
        System.out.println(p3.compareTo(p3)); // Cómparase consigo mesmo (devolve 0)

        // Creación dun array estático de 3 posicións de tipo Persoa
        Persoa [] individuos = new Persoa [3];
        individuos[0] = p2;
        individuos[1] = p1;
        individuos[2] = p3;
        
        // Arrays.sort utiliza de forma interna o método compareTo para ordenar o array.
        // Ordenará os individuos por orde alfabética de DNI: "0000000F" -> "1234F" -> "4567H"
        Arrays.sort(individuos);
        
        // Imprime o array ordenado grazas a que definimos o método toString
        System.out.println(Arrays.toString(individuos));
        System.out.println(Arrays.toString(individuos));
    }
}

