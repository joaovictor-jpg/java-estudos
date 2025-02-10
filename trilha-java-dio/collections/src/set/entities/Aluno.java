package set.entities;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private Integer matricula;
    private Double nota;

    public Aluno(String nome, Integer matricula, Double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public Double getNota() {
        return nota;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aluno { Matrícula: " + matricula + ", Nome: " + nome + ", Nota: " + nota + " }";
    }

    @Override
    public int compareTo(Aluno a) {
        return this.nome.compareToIgnoreCase(a.getNome());
    }

}
