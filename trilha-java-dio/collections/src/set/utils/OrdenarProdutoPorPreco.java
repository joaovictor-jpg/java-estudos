package set.utils;

import java.util.Comparator;

import set.entities.Produto;

public class OrdenarProdutoPorPreco implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
    
}
