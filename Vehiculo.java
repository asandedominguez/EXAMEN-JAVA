package examne2;
public class Vehiculo {
    private String matricula;
    public String Marca;
    public String modelo;
    public double precio;

    public Vehiculo(String matricula,String Marca,String modelo,double precio){
        this.matricula = matricula; 
        this.Marca = Marca; 
        this.modelo = modelo; 
        this.precio = precio; 
    }

    public String get_matricula(){
        return this.matricula;
    }
    public String get_Marca(){
        return this.Marca;
    }
    public String get_modelo(){
        return this.modelo;
    }
    public double get_precio(){
        return this.precio;
    }


    @Override
    public String toString(){
        return "Matricula: " + get_matricula() + "marca: " + this.Marca + " Modelo: "+this.modelo+ " Precio: " + this.precio;


    }
    @Override
    public boolean equals(Object coche2){
      if  (this == coche2){
        return true;
      }
      if (coche2 == null || this.getClass() != coche2.getClass()){
        return false;
      }
      Vehiculo otro_coche = (Vehiculo) coche2;
      return this.matricula.equals(otro_coche.get_matricula());
    }


}