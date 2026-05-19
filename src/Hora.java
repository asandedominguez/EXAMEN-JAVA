public class Hora {
    public int horas;
    public int minutos;
    public int segundos;

    public Hora() {
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Hora(String hora) {
        String[] partes = hora.split(":");

        this.horas = Integer.parseInt(partes[0]);
        this.minutos = Integer.parseInt(partes[1]);
        this.segundos = Integer.parseInt(partes[2]);
    }

    public Hora(double hora) {

        this.horas = (int) hora;
        double fraccion = hora - this.horas;

        double minutosDecimal = fraccion * 60;
        this.minutos = (int) minutosDecimal;

        double segundosDecimal = (minutosDecimal - this.minutos) * 60;
        this.segundos = (int) Math.round(segundosDecimal);

    }

    public Hora(int[] hora){
        if (hora.length > 3) {
            System.out.println("Error: el array no puede tener más de 3 elementos.");
            iniciaACero();
        }
        else {
            if (hora.length > 0) this.horas = hora[0];
            else setHoras(0);
            if (hora.length > 1) this.minutos = hora[1];
            else setMinutos(0);
            if (hora.length > 2) this.segundos = hora[2];
            else setSegundos(0);
        }
    }

    public Integer getHoras() {
        return this.horas;
    }

    public void setHoras(int horas) {
        if (horas<24 && horas>=0) {
            this.horas = horas;
        }
        else {
            System.out.println("Error: " + horas + " no es valor válido para las horas.");
        }
    }

    public Integer getMinutos() {
        return this.minutos;
    }

    public void setMinutos(int minutos) {
        if (minutos<60 && minutos>=0) {
            this.minutos = minutos;
        }
        else {
            System.out.println("Error: " + minutos + " no es valor válido para los minutos.");
        }
    }

    public Integer getSegundos() {
        return this.segundos;
    }

    public void setSegundos(int segundos) {
        if (segundos<60 && segundos>=0) {
            this.segundos = segundos;
        }
        else {
            System.out.println("Error: " + segundos + " no es valor válido para los segundos.");
        }
    }

    private void iniciaACero( ){
        horas = 0;
        minutos = 0;
        segundos = 0;

    }

    public String toString() {
        return "Horas: "+horas+" minutos: "+minutos+" segundos: "+segundos;
    }

    public static void main(String [] args) {
        Hora h1 = new Hora(12.23);

        System.out.println(h1.getHoras());
        System.out.println(h1.getMinutos());
        System.out.println(h1.getSegundos());
    }

}
