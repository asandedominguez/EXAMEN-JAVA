import java.util.*;

class Academico implements Comparable<Academico> {
    String nome;
    int anoIngreso;

    public Academico(String nome, int anoIngreso) {
        this.nome = nome;
        this.anoIngreso = anoIngreso;
    }

    @Override
    public int compareTo(Academico o) {
        return this.nome.compareTo(o.nome); // Orde natural por nome
    }

    @Override
    public String toString() {
        return nome + " (" + anoIngreso + ")";
    }
}

