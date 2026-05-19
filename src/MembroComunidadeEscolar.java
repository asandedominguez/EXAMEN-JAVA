/**
 * Clase que representa a un membro da comunidade escolar.
 * Estende (herda) as propiedades e métodos básicos da clase nai 'Persoa'.
 */
public class MembroComunidadeEscolar extends Persoa {
    // Atributos privados e encapsulados específicos do ámbito escolar
    private int codigoCentro;
    private String nomeCentro;

    /**
     * Construtor completo parametrizado.
     * Recibe os datos persoais e os escolares para inicializar todo o obxecto.
     * 
     * @param nome Nome da persoa.
     * @param dni Documento de identidade.
     * @param edade Idade en anos.
     * @param estatura Altura en metros (incluída para non limitar o construtor da clase nai).
     * @param codigoCentro Identificador numérico do colexio ou instituto.
     * @param nomeCentro Nome do centro educativo.
     */
    public MembroComunidadeEscolar(String nome, String dni, int edade, double estatura, int codigoCentro, String nomeCentro){
        // 'super' invoca de xeito obrigatorio ao construtor correspondente da clase nai (Persoa)
        super(nome, dni, edade, estatura);
        // Inicialización dos atributos propios desta subclase
        this.codigoCentro = codigoCentro;
        this.nomeCentro = nomeCentro;
    }

    /**
     * Construtor por defecto (sen parámetros).
     * Inicializa o obxecto con valores baleiros ou predeterminados de xeito seguro.
     */
    public MembroComunidadeEscolar() {
        super(); // Invoca ao construtor sen parámetros de 'Persoa'
        this.codigoCentro = 0;
        this.nomeCentro = "descoñecido"; // Valor por defecto corrixido
    }

    // Método Getter para obter de forma segura o código do centro
    public int getCodigoCentro() {
        return this.codigoCentro;
    }

    /**
     * Método Setter para modificar o código do centro con validación de seguridade.
     * Garante que o código non sexa un número negativo ou inválido.
     */
    public void setCodigoCentro(int codigoCentro){
        if (codigoCentro > 0) {
            this.codigoCentro = codigoCentro; // Asigna o valor se é correcto
        } else {
            this.codigoCentro = 0; // Asigna un valor neutro se o parámetro fose incorrecto
        }
    }

    // Método Getter engadido para ler o nome do centro desde fóra da clase
    public String getNomeCentro() {
        return this.nomeCentro;
    }

    // Método Setter engadido para actualizar de forma segura o nome do centro
    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }
}
