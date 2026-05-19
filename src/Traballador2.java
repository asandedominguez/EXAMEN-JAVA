public class Traballador2 extends Persoa {

    // CORREGIDO: Atributo privado para cumplir con el encapsulamiento
    private double salario;

    // Se elimina 'estaturaT' por ser un atributo redundante y confuso en la jerarquía

    public Traballador2(String nome, String dni, int edade, double estatura, double salario) {
        super(nome, dni, edade, estatura);
        this.salario = salario;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            this.salario = 0;
        }
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); // Muestra: Nome, Dni, Edade, Estatura
        // CORREGIDO: Separación textual para evitar que Java sume los valores numéricos
        System.out.println("Salario: " + salario + "€");
    }

    @Override
    public boolean equals(Object outro) {
        // CORREGIDO: Control de nulos y verificación de tipo segura
        if (this == outro) return true;
        if (outro == null || getClass() != outro.getClass()) return false;

        Traballador2 outroTraballador = (Traballador2) outro;
        // CORREGIDO: Uso de getters para respetar el encapsulamiento de la clase madre
        return Double.compare(this.getEstatura(), outroTraballador.getEstatura()) == 0;
    }

    public static void main (String [] args) {
        // CORREGIDO: Adaptado al constructor optimizado sin la variable redundante
        Traballador2 t = new Traballador2("Juan", "2222J", 46, 1.93, 1380);
        Persoa p = new Persoa("Pepe", "1111H", 37, 1.81);

        Persoa[] persoas = new Persoa[2];
        persoas[0] = p;
        persoas[1] = t; // Polimorfismo: un objeto hijo guardado en una estructura del padre

        Persoa unTraballador = t;

        System.out.println("Executando exemplo traballador:");

        // CORREGIDO: Uso de getters públicos obligatorios
        System.out.println("Estatura desde array: " + persoas[1].getEstatura());
        System.out.println("Estatura desde referencia Persoa: " + unTraballador.getEstatura());
        System.out.println("Estatura desde referencia directa: " + t.getEstatura());

        System.out.println("\n--- Chamada polimórfica a mostrarDatos() ---");
        unTraballador.mostrarDatos(); // Ejecuta el método de Traballador2 en tiempo de ejecución

        System.out.println("\n--- Chamada directa a mostrarDatos() ---");
        t.mostrarDatos();
    }
}
