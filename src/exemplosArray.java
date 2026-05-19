// CORREGIDO: Nombre de la clase con mayúscula inicial según convenciones de Java
public class exemplosArray {

    // CORREGIDO: El método main debe devolver obligatoriamente 'void'
    public static void main (String [] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        char[] letras = new char[10];
        letras[0] = 'a';
        letras[1] = 'b';

        for (int i = 0; i < 10; i++) {
            System.out.println("A letra e: " + letras[i]);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Onumero e: " + numeros[i]);
        }

        for (int n : numeros) {
            System.out.println("Onumero e: " + n);
        }

        String[] nomes = new String[10];
        nomes[0] = "Hugo";
        nomes[1] = "Pedro";
        nomes[2] = new String("Ana");

        Persoa[] equipo = new Persoa[5];
        equipo[0] = new Persoa("Ramon", "4567U", 23, 1.2);
        equipo[1] = new Persoa("Jose", "8642H", 32, 1.3);
        equipo[2] = new Persoa("Carmen", "9876Y", 41, 1.4);
        equipo[3] = new Persoa("Tina", "1234R", 17, 1.5);
        equipo[4] = new Persoa("Pili", "3258T", 33, 1.6);

        // ALGORITMO 1: Cálculo correcto de la media de edad
        int suma = 0;
        for (int i = 0; i < equipo.length; i++) {
            // CORREGIDO: Uso de getEdade() debido a que los atributos de Persoa son privados
            suma = suma + equipo[i].getEdade();
        }
        // CORREGIDO: La media se calcula e imprime FUERA del bucle for
        double media = (double) suma / equipo.length;
        System.out.println("A media de edade e: " + media);


        // ALGORITMO 2: Conteo de letras totales de los nombres
        int totalLetrasEquipo = 0;
        for (Persoa p : equipo) {
            // CORREGIDO: Uso de getNome() y optimización del conteo con .length()
            int letrasNome = p.getNome().length();
            totalLetrasEquipo += letrasNome;
            System.out.println("As letras de " + p.getNome() + " son " + letrasNome);
        }
        System.out.println("O total de letras de todos los nomes es: " + totalLetrasEquipo);


        // ALGORITMO 3: Buscar el DNI menor lexicográficamente
        Persoa dniMenor = equipo[0];
        for (int i = 1; i < equipo.length; i++) {
            // CORREGIDO: Uso de getDni() para respetar el encapsulamiento privado
            if (dniMenor.getDni().compareTo(equipo[i].getDni()) > 0) {
                dniMenor = equipo[i];
            }
        }
        System.out.println("O dni " + dniMenor.getDni() + " de " + dniMenor.getNome() + " e lexicograficamente menor");
    }
}
