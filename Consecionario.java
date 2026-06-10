package examne2;

import java.util.ArrayList;

public class Consecionario {
    public String nombre;
    public ArrayList<Vehiculo> listaVehiculos;
public Consecionario(String nombre){
    this.nombre = nombre;
    this.listaVehiculos = new ArrayList<Vehiculo>();
}
public boolean añadirVehiculo(Vehiculo v){
    if (this.listaVehiculos.contains(v)){
        return false;
    } else{
        listaVehiculos.add(v);
        return true;}

    }
public Vehiculo buscarVehiculo(String matricula){
    for(Vehiculo c : this.listaVehiculos){
        if(matricula.equals(c.get_matricula())){
            return c;
        }
    }
    return null;
    }

public ArrayList<Vehiculo> filtrarPorMarca(String marca){
        ArrayList<Vehiculo> cesto = new ArrayList<Vehiculo>();
        for(Vehiculo c : this.listaVehiculos){
        if(marca.equals(c.get_Marca())){
            cesto.add(c);
        }
    }
        return cesto;
    }
public boolean eliminarVehiculo(Vehiculo v)   {

    return this.listaVehiculos.remove(v);

}




       }




