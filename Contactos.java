package examen;

public class Contactos {
 private String nome;
  private String numTelefono;
   private String empresa;


   public Contactos(String nome,String numTelefono,String empresa){
    this.nome = nome;
    this.numTelefono = numTelefono;
    this.empresa = empresa;

   };
    public String getnome(){
        return this.nome;
    };
    public String getnumTelefono(){
        return this.numTelefono;
    };
    public String getempresa(){
        return this.empresa;
    };
    public void setNumTelef(String numTelef){
        this.numTelefono = numTelef;
    };
     public void setEmpresa(String nom_empresa){
        this.empresa = nom_empresa;
    };
    @Override
    public boolean equals(Object outro){
        if (this == outro){
            return true;
        };
        if (outro == null || this.getClass() != outro.getClass()){
            return false;
        }
        Contactos otroContacto = (Contactos) outro;
        return this.nome.equals(otroContacto.getnome()) && this.empresa.equals(otroContacto.getempresa()) && this.numTelefono.equals(otroContacto.getnumTelefono());
        
    }
    @Override
    public String toString(){
    return "nombre "  + this.nome + " numero de telefono: " + this.numTelefono + " Empresa: " + this.empresa;
    }


}
