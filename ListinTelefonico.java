package examen;

import java.util.ArrayList;

public class ListinTelefonico {
    private String nome;
    private ArrayList<Contactos> contactos;

    public ListinTelefonico(String nome){
        this.nome = nome;
         this.contactos = new ArrayList<Contactos>();
    }

    public String get_nome(){
        return this.nome;
    }

    public Contactos geContactos(String nombre){
        for (Contactos c : this.contactos) {
           if(nombre.equals(c.getnome())){
            return c;
           }
        }
        return null;
    }
    public boolean addContacto(Contactos c){
            if (this.contactos.contains(c)){
                return false;
            }else{
                this.contactos.add(c);
                return true;
            }
    }
    public ArrayList<Contactos> getContactosEmpresa(String empresa){
        ArrayList<Contactos> cesto = new ArrayList<Contactos>();
        for (Contactos c : this.contactos) {
           if(empresa.equals(c.getempresa())){
            cesto.add(c);
           }
           }
        return cesto;
    }
    public boolean borrarContacto(Contactos c){
      
           return this.contactos.remove(c);

    }
    public void mostrarListaContactos(String empresa){
        for (Contactos c : this.contactos) {
           if(empresa.equals(c.getempresa())){
            System.out.println(c);
           }
           }
    }
}
