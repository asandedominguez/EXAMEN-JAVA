import java.util.Arrays;

public class busqueda {
    public int [][] matriz;
    public int elemento;

    public busqueda(int [][] matriz, int elemento){
        this.matriz = matriz;
        this.elemento = elemento;
    }
    public static int[] buscarE(int [][] mat, int valor){
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[i].length; j++){
                if (mat[i][j] == valor){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main (String[] args){
        int [][] matriz = {
                {10,25,4},
                {8,9,10},
                {33,1,7}
        };
        int numero = 3;
        busqueda b1 = new busqueda(matriz,numero);
        int [] resultado = buscarE(b1.matriz,b1.elemento);
        if (resultado[0] == -1) {
            System.out.println("O elemento " + b1.elemento + " non se atopou na matriz. Código: -1");
        } else {
            System.out.println("O elemento " + b1.elemento + " está na Fila " + resultado[0] + ", Columna " + resultado[1]);
            System.out.println("Índice total en formato array: " + Arrays.toString(resultado));
        }

    }
}
