import enums.EstadoBrasileiro;

public class SistemaIBGE {
    public static void main(String[] args) throws Exception {
        for (EstadoBrasileiro e : EstadoBrasileiro.values()) {
            System.out.println(e.getNome() + " - " + e.getSigla());
        }
    }
}
