package examne2;

public class Main {
 public static void main(String[] args) {
       Consecionario lista1 = new Consecionario("Aitor");
       Vehiculo mercedes = new Vehiculo("SETA", "mercedes", "gt3", 1900);
       Vehiculo porche = new Vehiculo("SA", "porche", "gt4", 1300);
       lista1.añadirVehiculo(mercedes);
       lista1.añadirVehiculo(porche);
       Vehiculo copia = new Vehiculo("SETA", "mercedes", "gt3", 1900);
       lista1.añadirVehiculo(copia); 
       System.out.println(lista1.buscarVehiculo("SA"));
       System.out.println(lista1.listaVehiculos);
       lista1.eliminarVehiculo(mercedes);
       System.out.println(lista1.listaVehiculos);



    }
    


}
