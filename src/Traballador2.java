public class Traballador2 extends Persoa {

    // Atributo privado para cumprir co principio de encapsulamento e ocultación de información
    private double salario;

    /**
     * Construtor completo da clase Traballador2.
     * Utiliza 'super' para enviar os datos comúns á clase nai (Persoa) e inicializa o salario.
     */
    public Traballador2(String nome, String dni, int edade, double estatura, double salario) {
        super(nome, dni, edade, estatura); // Invocación obrigatoria ao construtor da clase nai
        this.salario = salario;            // Inicialización do atributo propio da subclase
    }

    // Método Getter para ler de forma segura o valor do salario privado
    public double getSalario() {
        return this.salario;
    }

    /**
     * Método Setter para modificar o salario cun filtro de seguridade.
     * Evita que un traballador poida ter un salario negativo en memoria.
     */
    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario; // Asigna o salario se é un valor válido
        } else {
            this.salario = 0;       // Asigna cero como valor neutro de garda
        }
    }

    /**
     * Sobrescribe o método mostrarDatos da clase nai.
     * Aproveita a lóxica existente do pai e engade a información específica do salario.
     */
    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); // Executa o método do pai para amosar Nome, Dni, Edade e Estatura
        // Engade a liña co salario formateado evitando sumas numéricas erróneas no texto
        System.out.println("Salario: " + salario + "€");
    }

    /**
     * Sobrescribe o método equals herdado de Object.
     * Realiza un control de nulos, verifica os tipos en memoria e compara as estaturas de xeito seguro.
     */
    @Override
    public boolean equals(Object outro) {
        if (this == outro) return true; // Se apuntan ao mesmo obxecto en memoria, son iguais
        if (outro == null || getClass() != outro.getClass()) return false; // Control de nulos e tipos

        Traballador2 outroTraballador = (Traballador2) outro; // Cast seguro á clase filla
        // Double.compare evita problemas de precisión decimal ao comparar variables tipo 'double'
        // Como 'estatura' é privada na clase nai, accédese de forma obrigatoria mediante getEstatura()
        return Double.compare(this.getEstatura(), outroTraballador.getEstatura()) == 0;
    }

    public static void main (String [] args) {
        // Instanciación de obxectos con herdanza: un fillo (Traballador2) e un pai (Persoa)
        Traballador2 t = new Traballador2("Juan", "2222J", 46, 1.93, 1380);
        Persoa p = new Persoa("Pepe", "1111H", 37, 1.81);

        // POLIMORFISMO: Creamos un array de tipo Persoa pero gardamos dentro un obxecto Traballador2.
        // Un array da clase nai é capaz de almacenar calquera das súas clases fillas.
        Persoa[] persoas = new Persoa[2];
        persoas[0] = p;
        persoas[1] = t; 

        // Unha referencia da clase nai (Persoa) pode apuntar directamente a un obxecto fillo (t)
        Persoa unTraballador = t;

        System.out.println("Executando exemplo traballador:");

        // Demostración de acceso á estatura dende as distintas referencias usando os getters públicos
        System.out.println("Estatura desde array: " + persoas[1].getEstatura());
        System.out.println("Estatura desde referencia Persoa: " + unTraballador.getEstatura());
        System.out.println("Estatura desde referencia directa: " + t.getEstatura());

        // LÓXICA CLAVE DO POLIMORFISMO DINÁMICO:
        // Aínda que a referencia da variable 'unTraballador' é de tipo 'Persoa', en tempo de execución
        // Java detecta que o obxecto real en memoria é un 'Traballador2' e executa o mostrarDatos() do fillo.
        System.out.println("\n--- Chamada polimórfica a mostrarDatos() ---");
        unTraballador.mostrarDatos(); // Amosa os datos comúns e TAMÉN o salario

        System.out.println("\n--- Chamada directa a mostrarDatos() ---");
        t.mostrarDatos(); // Chamada estándar dende a referencia directa do propio tipo
    }
}

