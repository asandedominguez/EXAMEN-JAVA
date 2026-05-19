// NOTA DE CONVENCIÓN: O nome da clase mantense como 'exemplosArray', pero o recomendable 
// en Java é usar CamelCase con maiúscula inicial (ExemplosArray).
public class exemplosArray {

    // O método main executa o fío principal do programa e non devolve nada (void)
    public static void main (String [] args) {
        // Declaración e inicialización directa dun array de enteiros con 5 elementos
        int[] numeros = {1, 2, 3, 4, 5};
        
        // Declaración e reserva de memoria para un array de caracteres de tamaño 10
        char[] letras = new char[10];
        letras[0] = 'a'; // Asignación na primeira posición (índice 0)
        letras[1] = 'b'; // Asignación na segunda posición (índice 1)

        // Bucle para percorrer o array de caracteres. 
        // Nota: As posicións 2 a 9 amosaranse baleiras (carácter nulo '\u0000')
        for (int i = 0; i < 10; i++) {
            System.out.println("A letra e: " + letras[i]);
        }

        // Bucle tradicional para percorrer o array de números usando un índice
        for (int i = 0; i < 5; i++) {
            System.out.println("Onumero e: " + numeros[i]);
        }

        // Bucle mellorado 'for-each': máis limpo, percorre de forma automática
        // cada elemento 'n' do array 'numeros' sen necesidade de xestionar índices
        for (int n : numeros) {
            System.out.println("Onumero e: " + n);
        }

        // Declaración dun array de obxectos String con capacidade para 10 textos
        String[] nomes = new String[10];
        nomes[0] = "Hugo";
        nomes[1] = "Pedro";
        nomes[2] = new String("Ana"); // Forma alternativa (e redundante) de crear un String

        // Declaración dun array de obxectos 'Persoa' con tamaño fixo de 5
        Persoa[] equipo = new Persoa[5];
        // Enchemos as 5 celas (0 a 4) instanciando obxectos a través do seu construtor
        equipo[0] = new Persoa("Ramon", "4567U", 23, 1.2);
        equipo[1] = new Persoa("Jose", "8642H", 32, 1.3);
        equipo[2] = new Persoa("Carmen", "9876Y", 41, 1.4);
        equipo[3] = new Persoa("Tina", "1234R", 17, 1.5);
        equipo[4] = new Persoa("Pili", "3258T", 33, 1.6);

        // =========================================================================
        // ALGORITMO 1: Cálculo correcto da media de idade
        // =========================================================================
        int suma = 0; // Acumulador para sumar as idades
        for (int i = 0; i < equipo.length; i++) {
            // Como os atributos de Persoa son privados, usamos obrigatoriamente getEdade()
            suma = suma + equipo[i].getEdade();
        }
        // Calculamos a media fóra do bucle. 
        // Aplicamos un cast a (double) para forzar que a división teña decimais correctos
        double media = (double) suma / equipo.length;
        System.out.println("A media de edade e: " + media);


        // =========================================================================
        // ALGORITMO 2: Contaxe de letras totais de todos os nomes
        // =========================================================================
        int totalLetrasEquipo = 0; // Acumulador global de caracteres
        // Percorremos o array de obxectos empregando un bucle for-each de tipo Persoa
        for (Persoa p : equipo) {
            // Extraemos o nome, medimos o seu tamaño con .length() e gardámolo
            int letrasNome = p.getNome().length();
            totalLetrasEquipo += letrasNome; // Sumamos as letras ao totalizador
            System.out.println("As letras de " + p.getNome() + " son " + letrasNome);
        }
        System.out.println("O total de letras de todos los nomes es: " + totalLetrasEquipo);


        // =========================================================================
        // ALGORITMO 3: Buscar o DNI menor lexicograficamente (orde de dicionario)
        // =========================================================================
        // Asumimos como hipótese inicial que a primeira persoa (índice 0) ten o DNI menor
        Persoa dniMenor = equipo[0];
        
        // Comezamos a busca secuencial dende o índice 1 ata o final do array
        for (int i = 1; i < equipo.length; i++) {
            // .compareTo() devolve un número maior que 0 se a cadea 'dniMenor' vai despois
            // alfabeticamente que o DNI da persoa da posición 'i'
            if (dniMenor.getDni().compareTo(equipo[i].getDni()) > 0) {
                // Se atopamos un DNI máis pequeno, actualizamos a nosa variable de referencia
                dniMenor = equipo[i];
            }
        }
        // Imprimimos o resultado final co obxecto Persoa que gañou a busca
        System.out.println("O dni " + dniMenor.getDni() + " de " + dniMenor.getNome() + " e lexicograficamente menor");
    }
}

