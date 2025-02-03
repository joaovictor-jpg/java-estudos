import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoCandidatos();
    }

    static void selecaoCandidatos() {
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIEL", "JORGE" };

        int candidatoSelecionador = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatoSelecionador < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato: " + candidato + ", solicitou este valor de salário " + salarioPretendido);

            if (analisarCandidato(salarioPretendido, salarioBase)) {
                System.out.println("O candidato: " + candidato + ", foi selecionado para a vaga");
                candidatoSelecionador++;
            } else {
                System.out.println("O candidato: " + candidato + ", não foi selecionado para a vaga");
            }

            candidatoAtual++;
        }

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean analisarCandidato(double salarioPretendido, double salarioBase) {
        if (salarioBase >= salarioPretendido) {
            return true;
        } else {
            return false;
        }
    }
}
