public class Condicional {

    public static void main(String[] args) {
        int anoDelançamento = 1990;
        boolean inlcudeNoPlano = false;
        double notaDoFilme = 8.1;
        String tipoPlano = "plus";

        if (anoDelançamento >= 2022) {
            System.out.println("Lançamento que os clientes estão curtindo");
        }else {
            System.out.println("Filme retrô que vale a pena assistir");
        }

        if (inlcudeNoPlano && tipoPlano.equals("plus")) {
            System.out.println("Filme liberado");
        } else {
            System.out.println("Deve pagar a locação");
        }
    }

}
