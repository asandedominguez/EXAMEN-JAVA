import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializamos unha lista de reprodución de proba
        ListaReproducion aMinhaLista = new ListaReproducion("Top 2026", 5);

        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ LISTA DE REPRODUCIÓN ---");
            System.out.println("a) Engadir canción");
            System.out.println("b) Eliminar canción");
            System.out.println("c) Buscar lista cancións por autor");
            System.out.println("d) Reproducir canción");
            System.out.println("e) Mostrar a lista de cancións (reproducións pares)");
            System.out.println("f) Sair");
            System.out.print("Elixe unha opción: ");

            String entrada = sc.nextLine().toLowerCase();
            if (entrada.isEmpty()) continue;
            char opt = entrada.charAt(0);

            switch (opt) {
                case 'a':
                    System.out.print("Introduce o título da canción: ");
                    String titulo = sc.nextLine();
                    System.out.print("Introduce o artista: ");
                    String artista = sc.nextLine();

                    Cancion novaCancion = new Cancion(titulo, artista);
                    if (aMinhaLista.addCanción(novaCancion)) {
                        System.out.println("Canción engadida correctamente.");
                    } else {
                        System.out.println("Erro: A lista está chea.");
                    }
                    break;

                case 'b':
                    System.out.print("Introduce o título da canción a eliminar: ");
                    String tituloEliminar = sc.nextLine();
                    if (aMinhaLista.eliminarCancion(tituloEliminar)) {
                        System.out.println("Canción eliminada.");
                    } else {
                        System.out.println("Non se atopou ningunha canción con ese título.");
                    }
                    break;

                case 'c':
                    System.out.print("Introduce o nome do artista a buscar: ");
                    String artistaBuscar = sc.nextLine();
                    ArrayList<Cancion> resultado = aMinhaLista.getCancionsArtista(artistaBuscar);
                    if (resultado.isEmpty()) {
                        System.out.println("Non se atoparon cancións dese artista.");
                    } else {
                        System.out.println("Cancións de " + artistaBuscar + ":");
                        for (Cancion c : resultado) {
                            System.out.println("- " + c.getTitulo());
                        }
                    }
                    break;

                case 'd':
                    System.out.print("Introduce o título da canción a reproducir: ");
                    String tituloRepro = sc.nextLine();
                    Cancion cancionParaRepro = aMinhaLista.get_cancion(tituloRepro);

                    if (cancionParaRepro != null) {
                        aMinhaLista.reproducirCancion(cancionParaRepro);
                        System.out.println("Reproducindo: " + cancionParaRepro.getTitulo() + ". Reproducións actuais: " + cancionParaRepro.getReproduccions());
                    } else {
                        System.out.println("A canción non existe na lista.");
                    }
                    break;

                case 'e':
                    aMinhaLista.mostrarListaReproduccion();
                    break;

                case 'f':
                    System.out.println("Saindo do programa. Ata logo!");
                    opcion = 6; // Para romper o bucle
                    break;

                default:
                    System.out.println("Opción non válida.");
            }
        } while (opcion != 6);

        sc.close();
    }
}