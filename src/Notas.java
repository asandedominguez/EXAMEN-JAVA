import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Notas {
    private int [] nota;
    private String [] alumno;
    public Notas(int [] nota, String [] alumno){
        this.nota = nota;
        this.alumno = alumno;
    }
    public int[] getNota(){
        return nota;
    }
    public void setNota(int [] nota){
        this.nota = nota;
    }
    public String [] getAlumno(){
        return alumno;
    }
    public void setAlumno(String [] alumno){
        this.alumno = alumno;
    }
    public static void main (String [] args) {
        Scanner teclado = new Scanner((System.in));
        Random generador =  new Random();
        int [] numero = new int [30];
        String [] alumno = new String [30];
        for (int i = 0; i < numero.length; i++){
            numero[i] = generador.nextInt(0,10);
            alumno[i] = "Alumno" + (i + 1);
        }
        Notas n1 = new Notas(numero, alumno);
        System.out.println(Arrays.toString(n1.getNota()));
        int suspensos = 0;
        int aprobados = 0;
        for(int i = 0; i < numero.length; i++){
            if (numero[i] >= 0 && numero[i] <= 4) {
                suspensos++;
            } else {
                aprobados++;
                System.out.println(alumno[i]);
            }

        }
        System.out.println(aprobados);
        System.out.println(suspensos);
        int suma = 0;
        for (int i = 0; i < numero.length; i++){
            suma += numero[i];
        }
        int media = suma/numero.length;
        System.out.println("media" + " " + media);

        int alto = numero[0];
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] > alto) {
                alto = numero[i];
            }
        }
        System.out.println("Mas alta" + " " + alto);
        System.out.println(alumno[0] + " - " + numero[0]);
        Arrays.sort(numero);
        System.out.println(Arrays.toString(numero));

        System.out.println("Introduce un alumno: ");
        String buscar = teclado.nextLine();
        boolean encontrado = false;

        for (int i = 0; i< alumno.length; i++){
            if (alumno[i].equalsIgnoreCase(buscar)){
            System.out.println(alumno[i] + numero[i]);
            encontrado = true;
            break;
            }
        }
        if (!encontrado) {
            System.out.println("No está");
        }
    }

}
