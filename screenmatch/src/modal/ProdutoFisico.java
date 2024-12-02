package modal;

import modal.interfaces.Calculavel;

public class ProdutoFisico extends Produto implements Calculavel {
    public double calcularPrecoFinal() {
        // Implementação com taxas adicionais para produtos físicos
        return preco * 1.05;
    }