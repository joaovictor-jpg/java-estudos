package modal;

import modal.interfaces.Calculavel;

public class ProdutoFisico extends Produto implements Calculavel {
    public ProdutoFisico(String nome, double nota1, double nota2, double nota3, double preco) {
        super(nome, nota1, nota2, nota3, preco);
    }

    public double calcularPrecoFinal() {
        // Implementação com taxas adicionais para produtos físicos
        return preco * 1.05;
    }
}
