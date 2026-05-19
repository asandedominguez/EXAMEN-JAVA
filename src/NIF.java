public class NIF {
    private int numero;

    public NIF(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }

    public static void main (String[] args){
        NIF n1 = new NIF(26623774);
        int calculo = n1.getNumero() % 23;
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letra = letras.charAt(calculo);
        System.out.println(n1.getNumero() + " " + letra);
    }
}
