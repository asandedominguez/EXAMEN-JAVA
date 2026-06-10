package examen;

import java.util.Comparator;

public class ComparadorContactos implements Comparator<Contactos> {
    
public int compare(Contactos c1, Contactos c2){
    if (c1.getnome().compareTo(c2.getnome()) == 0){
        return c1.getnumTelefono().compareTo(c2.getnumTelefono());
    } else{
        return c1.getnome().compareTo(c2.getnome());
    }


};


}
