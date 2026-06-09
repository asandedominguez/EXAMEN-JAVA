import java.io.Serializable;

public class CentroTraballo implements Comparable<CentroTraballo>, Serializable {
    private String nome;
    private String provincia;
    private String localidade;
    private String direccion;

    // Construtor completo
    public CentroTraballo(String nome, String provincia, String localidade, String direccion) {
        this.nome = nome;
        this.provincia = provincia;
        this.localidade = localidade;
        this.direccion = direccion;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public String getLocalidade() { return localidade; }
    public void setLocalidade(String localidade) { this.localidade = localidade; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    // Criterio de ordenación (Comparable)
    @Override
    public int compareTo(CentroTraballo o) {
        int compNome = this.nome.compareTo(o.nome);
        if (compNome != 0) return compNome;

        int compProv = this.provincia.compareTo(o.provincia);
        if (compProv != 0) return compProv;

        int compLocal = this.localidade.compareTo(o.localidade);
        if (compLocal != 0) return compLocal;

        return this.direccion.compareTo(o.direccion);
    }

    @Override
    public String toString() {
        return nome + " (" + localidade + ", " + provincia + ")";
    }
}