package set.utils;

import java.util.Comparator;

import set.entities.Aluno;

public class OrdenarAlunosPorNota implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return Double.compare(a1.getNota(), a2.getNota());
    }
    
}
