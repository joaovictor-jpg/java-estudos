public class Autodromo {
    public static void main(String[] args) throws Exception {
        Carro jeep = new Carro();
        Moto z400 = new Moto();
        jeep.ligar();
        z400.ligar();

        jeep.setChassi("123456");
        z400.setChassi("987654");

    }
}
