import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Notas {
    // Atributos privados para gardar os arrays de notas e de alumnos
    private int [] nota;
    private String [] alumno;

    /**
     * Construtor da clase Notas para vincular os arrays de datos.
     */
    public Notas(int [] nota, String [] alumno){
        this.nota = nota;
        this.alumno = alumno;
    }

    // Métodos Getter e Setter para o encapsulamento do array de notas
    public int[] getNota(){
        return nota;
    }
    public void setNota(int [] nota){
        this.nota = nota;
    }

    // Métodos Getter e Setter para o encapsulamento do array de alumnos
    public String [] getAlumno(){
        return alumno;
    }
    public void setAlumno(String [] alumno){
        this.alumno = alumno;
    }

    public static void main (String [] args) {
        // Inicializa o Scanner para ler as entradas do usuario dende a consola
        Scanner teclado = new Scanner((System.in));
        // Crea un xerador de números aleatorios
        Random generador =  new Random();
        
        // Declaramos dous arrays estáticos con capacidade para 30 elementos
        int [] numero = new int [30];
        String [] alumno = new String [30];
        
        // Bucle for para encher os arrays con datos automáticos de proba
        for (int i = 0; i < numero.length; i++){
            // Xera unha nota aleatoria entre 0 e 9 (o límite superior 10 é exclusivo)
            numero[i] = generador.nextInt(0,10);
            // Crea un nome secuencial para o alumno (ex: Alumno1, Alumno2...)
            alumno[i] = "Alumno" + (i + 1);
        }
        
        // Instanciamos o obxecto Notas cos datos que acabamos de xerar
        Notas n1 = new Notas(numero, alumno);
        // Imprime o array de notas completo convertido a formato texto visual
        System.out.println(Arrays.toString(n1.getNota()));
        
        // Variables contadoras para clasificar o rendemento académico
        int suspensos = 0;
        int aprobados = 0;
        
        // Bucle para contar aprobados/suspensos e amosar os nomes dos que pasaron
        for(int i = 0; i < numero.length; i++){
            // Se a nota está entre 0 e 4 (inclusive), o alumno suspende
            if (numero[i] >= 0 && numero[i] <= 4) {
                suspensos++;
            } else {
                // Se a nota é un 5 ou superior, aproba e imprímese o seu nome por pantalla
                aprobados++;
                System.out.println(alumno[i]);
            }
        }
        
        // Amosamos os totais de alumnos aprobados e suspensos
        System.out.println(aprobados);
        System.out.println(suspensos);
        
        // CÁLCULO DA MEDIA: Acumulamos o sumatorio de todas as notas
        int suma = 0;
        for (int i = 0; i < numero.length; i++){
            suma += numero[i];
        }
        // Calcula a media enteira dividindo a suma total entre o número de alumnos
        int media = suma / numero.length;
        System.out.println("media" + " " + media);

        // NOTA MÁIS ALTA: Algoritmo de busca do valor máximo asumindo que o primeiro é o maior
        int alto = numero[0];
        for (int i = 0; i < numero.length; i++) {
            // Se atopamos unha nota maior que a nosa variable 'alto', actualizamos o seu valor
            if (numero[i] > alto) {
                alto = numero[i];
            }
        }
        System.out.println("Mas alta" + " " + alto);
        
        // Imprime a nota do primeiro alumno da lista antes de reordenar o array
        System.out.println(alumno[0] + " - " + numero[0]);
        
        // ATENCIÓN: Arrays.sort ordena o array de notas de menor a maior.
        // Isto rompe a correspondencia de índices entre os alumnos e as súas notas orixinais!
        Arrays.sort(numero);
        System.out.println(Arrays.toString(numero));

        // ALGORITMO DE BUSCA: Solicitamos ao usuario o nome dun alumno para buscar a súa nota
        System.out.println("Introduce un alumno: ");
        String buscar = teclado.nextLine();
        boolean encontrado = false; // Variable 'bandeira' para saber se o atopamos

        // Percorremos o array de alumnos para buscar coincidencias
        for (int i = 0; i < alumno.length; i++){
            // Compara o texto ignorando se está en maiúsculas ou minúsculas
            if (alumno[i].equalsIgnoreCase(buscar)){
                // Se o atopa, amosa o alumno coa nota (ollo: debido ao sort anterior, esta nota estará mal relacionada)
                System.out.println(alumno[i] + numero[i]);
                encontrado = true; // Cambiamos a bandeira a true
                break; // Rompe o bucle inmediatamente porque xa atopou o obxectivo
            }
        }
        
        // Se despois de percorrer todo o array a bandeira segue en false, avisa ao usuario
        if (!encontrado) {
            System.out.println("No está");
        }
    }
}

