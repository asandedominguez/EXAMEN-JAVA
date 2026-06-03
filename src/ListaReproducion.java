import java.util.ArrayList;

public class ListaReproducion {
    // Atributos
    private final String nome; // final porque di "non modificable"
    private ArrayList<Cancion> cancions;
    private int numMaxCancions;

    // Construtor
    public ListaReproducion(String nome, int numMaxCancions) {
        this.nome = nome;
        this.numMaxCancions = numMaxCancions;
        this.cancions = new ArrayList<>(); // Crea unha lista baleira
    }

    // Métodos públicos
    public String get_nome() {
        return this.nome;
    }

    // Retorna un obxecto Cancion polo título ou null se non existe
    public Cancion get_cancion(String titulo) {
        for (Cancion c : cancions) {
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                return c;
            }
        }
        return null;
    }

    // Engade a canción se non se supera o número máximo. Retorna true/false.
    public boolean addCanción(Cancion c) {
        if (cancions.size() < numMaxCancions) {
            cancions.add(c);
            return true;
        }
        return false;
    }

    // Retorna unha lista de cancións do autor pasado por parámetro
    public ArrayList<Cancion> getCancionsArtista(String artista) {
        ArrayList<Cancion> resultado = new ArrayList<>();
        for (Cancion c : cancions) {
            if (c.getArtista().equalsIgnoreCase(artista)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    // Busca a canción que coincida por parámetro e increméntalle as reproducións
    public void reproducirCancion(Cancion c) {
        for (Cancion cancionActual : cancions) {
            if (cancionActual.getTitulo().equalsIgnoreCase(c.getTitulo()) &&
                    cancionActual.getArtista().equalsIgnoreCase(c.getArtista())) {
                cancionActual.addReproduccion();
                break;
            }
        }
    }

    // Mostra os datos cuxo número de reproducións sexa par
    public void mostrarListaReproduccion() {
        System.out.println("Lista de reprodución: " + nome);
        for (Cancion c : cancions) {
            if (c.getReproduccions() % 2 == 0) {
                System.out.println(c.toString());
            }
        }
    }

    // Método auxiliar útil para o programa principal (Eliminar canción)
    public boolean eliminarCancion(String titulo) {
        Cancion c = get_cancion(titulo);
        if (c != null) {
            cancions.remove(c);
            return true;
        }
        return false;
    }
}