import java.util.Objects;

public class Cancion implements Comparable<Cancion> {
    // Atributos privados
    private String titulo;
    private String artista;
    private int numReproduccions;

    // Construtor
    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
        this.numReproduccions = 0;
    }

    // Métodos públicos (Getters e Setters)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getReproduccions() {
        return numReproduccions;
    }

    // Incrementa en 1 o número de reproducións
    public void addReproduccion() {
        this.numReproduccions++;
    }

    @Override
    public String toString() {
        return "Cancion [Título=" + titulo + ", Artista=" + artista + ", Reproducións=" + numReproduccions + "]";
    }

    // Interface Comparable: comparación natural por número de reproducións
    @Override
    public int compareTo(Cancion outra) {
        return Integer.compare(this.numReproduccions, outra.numReproduccions);
    }
}