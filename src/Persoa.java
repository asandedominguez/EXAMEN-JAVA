import java.util.Arrays;

public class Persoa implements Comparable<Persoa>{
    // CORREGIDO: Atributos privados para cumplir los RA de DAM (Ocultación de información)
    private String nome;
    private String dni;
    private int edade;
    private double estatura;

    public Persoa() {
        nome = "";
        dni = "0000000F";
        edade = 0;
        estatura = 0;
    }

    public Persoa(String nome, String dni, int edade, double estatura) {
        this.nome = nome;
        this.dni = dni;
        this.edade = edade;
        this.estatura = estatura;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEdade() {
        return this.edade;
    }

    public void setEdade(int edade) {
        this.edade = edade;
    }

    public String getDni() {
        return this.dni;
    }

    // CORREGIDO: Nombre del parámetro cambiado a 'dni' y asignación correcta con 'this.'
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void mostrarDatos() {
        System.out.println("Nome: " + nome + " Dni: " + dni + " Edade: " + edade + " Estatura: " + estatura);
    }

    @Override
    public boolean equals(Object outro) {
        Persoa outroPersoa = (Persoa) outro;
        if (this.estatura == outroPersoa.estatura) return true;
        return false;
    }


    @Override
    public int compareTo(Persoa outra) {
        /*int resultadoCom = this.dni.compareTo(outra.dni);
        System.out.println(resultadoCom);
        if (resultadoCom > 0) return 1;
        else if (resultadoCom < 0) return -1;
        return 0;*/
        return this.dni.compareTo(outra.dni);
    }

    public String toString() {
        return nome + ", " + dni + ", " + edade + ", " + estatura;
    }

    public static void main(String [] args) {
        Persoa p1 = new Persoa();
        Persoa p2 = new Persoa("Manuel","1234F",45,1.67);
        // CORREGIDO: Acceso mediante getters ya que las variables ahora son privadas
        System.out.println(p1.getNome());
        System.out.println(p2.getNome() + " " + p2.getDni() + " " + p2.getEdade());
        Persoa p3 = new Persoa("Pepe","4567H",35,1.64);
        System.out.println(p3.compareTo(p3));
//        ComparadorEdadesPersoa compEdades = new ComparadorEdadesPersoa();
//        System.out.println(compEdades.compare(p2,p3));
        Persoa [] individuos = new Persoa [3];
        individuos[0] = p2;
        individuos[1] = p1;
        individuos[2] = p3;
        Arrays.sort(individuos);
        System.out.println(Arrays.toString(individuos));
//        Arrays.sort(individuos, compEdades);
        System.out.println(Arrays.toString(individuos));
    }
}
