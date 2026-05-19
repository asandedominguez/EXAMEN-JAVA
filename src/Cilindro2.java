public class Cilindro2 extends Circulo implements Area {
    private double altura;

    public Cilindro2(int radio, double altura) {
        super(radio);
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return 2 * Math.PI * getRadio() * (getRadio() + altura);
    }


}