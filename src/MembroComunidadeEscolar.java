public class MembroComunidadeEscolar extends Persoa {
    private int codigoCentro;
    private String nomeCentro;

    // Incluimos estatura para no limitar el constructor de la clase madre
    public MembroComunidadeEscolar(String nome, String dni, int edade, double estatura, int codigoCentro, String nomeCentro){
        super(nome, dni, edade, estatura);
        this.codigoCentro = codigoCentro;
        this.nomeCentro = nomeCentro;
    }

    public MembroComunidadeEscolar() {
        super();
        this.codigoCentro = 0;
        this.nomeCentro = "descoñecido"; // Corregido idioma
    }

    public int getCodigoCentro() {
        return this.codigoCentro;
    }

    public void setCodigoCentro(int codigoCentro){
        if (codigoCentro > 0) {
            this.codigoCentro = codigoCentro;
        } else {
            this.codigoCentro = 0;
        }
    }

    // AÑADIDO: Métodos de acceso para nomeCentro
    public String getNomeCentro() {
        return this.nomeCentro;
    }

    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }
}
