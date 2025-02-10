package list.utils;

import java.util.Comparator;

import list.entities.Livro;

public class ComparatorPorAnoLancamentoLivro implements Comparator<Livro> {

    @Override
    public int compare(Livro livro1, Livro livro2) {
        return Integer.compare(livro1.getAnoDeLancamento(), livro2.getAnoDeLancamento());
    }
    
}
