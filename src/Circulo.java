// Asumimos que existe a clase Punto2 e a interface Area
public class Circulo extends Punto2 implements Area {
    private int radio;

    // Construtor principal completo
    public Circulo(int x, int y, int radio) {
        super(x, y); // Chámase obrigatoriamente á clase nai
        this.radio = radio;
    }

    // CORRECCIÓN: Construtor alternativo (crea un círculo no centro 0,0)
    public Circulo(int radio) {
        super(0, 0); // Damos coordenadas por defecto ao Punto2
        this.radio = radio;
    }

    // CORRECCIÓN: Nome cambiado de setR a setRadio por convención JavaBean
    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    // Os teus métodos matemáticos están perfectos!
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio; // PI * r²
    }

}