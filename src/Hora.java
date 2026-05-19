public class Hora {
    // Atributos públicos para almacenar as partes de dadas (Horas, Minutos e Segundos)
    public int horas;
    public int minutos;
    public int segundos;

    /**
     * Construtor por defecto (sen parámetros).
     * Inicializa a hora en punto de xeito predeterminado (00:00:00).
     */
    public Hora() {
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    /**
     * Construtor parametrizado común.
     * Recibe tres enteiros para asignar directamente os valores de tempo.
     */
    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    /**
     * Construtor a partir dunha cadea de texto (String).
     * Agarda recibir o formato "HH:mm:ss" para trocealo e convertelo.
     */
    public Hora(String hora) {
        // .split(":") corta o texto en anacos cada vez que atopa dous puntos
        String[] partes = hora.split(":");

        // Converte cada fragmento de texto a un número enteiro
        this.horas = Integer.parseInt(partes[0]);
        this.minutos = Integer.parseInt(partes[1]);
        this.segundos = Integer.parseInt(partes[2]);
    }

    /**
     * Construtor a partir dun número decimal (double).
     * Converte horas decimais (ex: 12.23) a formato horas, minutos e segundos normais.
     */
    public Hora(double hora) {
        // A parte enteira do decimal repesenta directamente as horas
        this.horas = (int) hora;
        // Illamos a parte fraccionaria restándolle o número enteiro (ex: 12.23 - 12 = 0.23)
        double fraccion = hora - this.horas;

        // Multiplicamos por 60 para obter o total de minutos con decimais (ex: 0.23 * 60 = 13.8)
        double minutosDecimal = fraccion * 60;
        this.minutos = (int) minutosDecimal; // A parte enteira son os minutos reais (ex: 13)

        // Illamos os decimais restantes dos minutos e multiplicamos por 60 para calcular os segundos
        double segundosDecimal = (minutosDecimal - this.minutos) * 60;
        // Redondeamos ao enteiro máis próximo para evitar imprecisións decimais
        this.segundos = (int) Math.round(segundosDecimal);
    }

    /**
     * Construtor a partir dun array de enteiros.
     * Asigna valores posicionalmente: array[0] -> horas, array[1] -> minutos, array[2] -> segundos.
     */
    public Hora(int[] hora){
        // Control de seguridade: se o array excede os 3 elementos loxicos, invalida os datos
        if (hora.length > 3) {
            System.out.println("Error: el array no puede tener más de 3 elementos.");
            iniciaACero(); // Resetea todo a 0
        }
        else {
            // Comprobacións secuenciais baseadas no tamaño (length) que teña o array de entrada:
            if (hora.length > 0) this.horas = hora[0];
            else setHoras(0);
            
            if (hora.length > 1) this.minutos = hora[1];
            else setMinutos(0);
            
            if (hora.length > 2) this.segundos = hora[2];
            else setSegundos(0);
        }
    }

    // Método Getter que devolve a cantidade de horas actuais
    public Integer getHoras() {
        return this.horas;
    }

    /**
     * Método Setter con validación de seguridade para o rango das horas (0 a 23).
     */
    public void setHoras(int horas) {
        if (horas < 24 && horas >= 0) {
            this.horas = horas;
        } else {
            System.out.println("Error: " + horas + " no es valor válido para las horas.");
        }
    }

    // Método Getter que devolve a cantidade de minutos actuais
    public Integer getMinutos() {
        return this.minutos;
    }

    /**
     * Método Setter con validación de seguridade para o rango dos minutos (0 a 59).
     */
    public void setMinutos(int minutos) {
        if (minutos < 60 && minutos >= 0) {
            this.minutos = minutos;
        } else {
            System.out.println("Error: " + minutos + " no es valor válido para los minutos.");
        }
    }

    // Método Getter que devolve a cantidade de segundos actuais
    public Integer getSegundos() {
        return this.segundos;
    }

    /**
     * Método Setter con validación de seguridade para o rango dos segundos (0 a 59).
     */
    public void setSegundos(int segundos) {
        if (segundos < 60 && segundos >= 0) {
            this.segundos = segundos;
        } else {
            System.out.println("Error: " + segundos + " no es valor válido para los segundos.");
        }
    }

    /**
     * Método privado utilitario que serve para poñer todos os reloxos internos a cero.
     */
    private void iniciaACero( ){
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    /**
     * Sobrescribe o método toString para amosar a hora de xeito textual e lexible.
     */
    public String toString() {
        return "Horas: " + horas + " minutos: " + minutos + " segundos: " + segundos;
    }

    public static void main(String [] args) {
        // Instancia un obxecto de proba pasando o valor decimal de 12.23 horas
        Hora h1 = new Hora(12.23);

        // Imprime por pantalla os compoñentes calculados por separado usando os getters
        System.out.println(h1.getHoras());    // Resultado: 12
        System.out.println(h1.getMinutos());  // Resultado: 13
        System.out.println(h1.getSegundos()); // Resultado: 48 (debido ao redondeo de 0.8 * 60)
    }
}
