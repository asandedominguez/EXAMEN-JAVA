package examen;

public class Main {
    public static void main(String[] args) {
       ListinTelefonico miListin = new ListinTelefonico("Contactos de Trabajo");
        Contactos c1 = new Contactos("Ana", "666555444", "Inditex");
        miListin.addContacto(c1);
        Contactos c2 = new Contactos("ALAN", "66678655444", "wazaaa");
        miListin.addContacto(c2);
        Contactos c3 = new Contactos("Ana", "666555444", "Inditex");
      System.out.println("¿Se añadió la Ana repetida? " + miListin.addContacto(c3));
        miListin.mostrarListaContactos("wazaaa");
        miListin.geContactos("Ana");
    }

}