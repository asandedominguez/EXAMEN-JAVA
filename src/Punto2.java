public class Punto2 implements Area{

    public double x;
    public double y;

    public Punto2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto2() {

    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }



    public static void main(String [] args) {
        Punto2 p1 = new Punto2(2,3);
        System.out.println(p1.toString());
    }
}
