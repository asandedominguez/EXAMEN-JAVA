package examne2;

import java.util.Comparator;

public class ComparadorPrecio implements Comparator<Vehiculo> {
    public int compare(Vehiculo v1, Vehiculo v2){
        if (v1.get_precio() == v2.get_precio()){
            return 0;
        }else if (v1.get_precio() > v2.get_precio()){
            return +1;
        }else{
            return -1;
        }
    
    
    }


}
