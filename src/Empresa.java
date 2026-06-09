import java.util.ArrayList;
import java.util.Objects;

public class Empresa {
    private String razonSocial;
    private String nif;
    private String actividadePrincipal;
    private String representanteLegal;
    // AGORA USA O MODELO, NON O DAO
    private ArrayList<CentroTraballo> centrosDeTraballo;

    public Empresa(String razonSocial, String nif, String actividadePrincipal, String representanteLegal) {
        this.razonSocial = razonSocial;
        this.nif = nif;
        this.actividadePrincipal = actividadePrincipal;
        this.representanteLegal = representanteLegal;
        this.centrosDeTraballo = new ArrayList<>();
    }

    // Getters e Setters
    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }
    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }
    public ArrayList<CentroTraballo> getCentrosDeTraballo() { return centrosDeTraballo; }

    // Equals simplificado seguindo o consello do profesor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nif, empresa.nif); // Compara de forma segura de existir nif null
    }

    @Override
    public String toString() {
        return "Empresa: " + razonSocial + " (NIF: " + nif + ") | Centros: " + centrosDeTraballo;
    }

    // Busca se existe un centro por nome
    public boolean tenCentroTraballo(String nome) {
        for (CentroTraballo centro : centrosDeTraballo) {
            if (centro.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    // Engade un obxecto CentroTraballo real á lista
    public boolean engadeCentroTraballo(CentroTraballo centro) {
        if (centro == null || centrosDeTraballo.contains(centro)) {
            return false;
        }
        return centrosDeTraballo.add(centro);
    }

    // Devolve os centros que coincidan coa localidade dada
    public ArrayList<CentroTraballo> centrosTraballoPorLocalidade(String localidade) {
        ArrayList<CentroTraballo> filtrados = new ArrayList<>();
        for (CentroTraballo centro : centrosDeTraballo) {
            if (centro.getLocalidade().equalsIgnoreCase(localidade)) {
                filtrados.add(centro);
            }
        }
        return filtrados;
    }
}