package modal;

import modal.interfaces.Forma;

public class Quadrado implements Forma {
    double lado;

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
