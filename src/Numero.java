import java.util.Arrays;
import java.util.Random;

public class Numero {
    private int [] numeros;
    private Numero(int [] numeros){
        this.numeros = numeros;
    }
    public int [] getNumeros(){
        return numeros;
    }
    public void setNumeros(int [] numeros){
        this.numeros=numeros;
    }
    public static void main(String [] args){
        Random generador = new Random();
        int[] azar = new int[6];
        for (int i = 0; i < azar.length; i++){
            azar[i] = generador.nextInt(1,51);
        }
        Numero n1 = new Numero(azar);
        System.out.println("Array original: " + Arrays.toString(n1.getNumeros()));
        int[] nuevoArray = n1.getNumeros();
        for (int i = nuevoArray.length - 1; i>=0; i--){
            System.out.println(nuevoArray[i]);
        }
    }
}
