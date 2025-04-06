package br.com.alura.numerosParalelos;

public class AppImpressora {

    public static void main(String[] args) throws InterruptedException {
//        Impressora impressora1 = new Impressora(1);
//        Impressora impressora2 = new Impressora(2);
//
//        Thread thread1 = new Thread(impressora1);
//        Thread thread2 = new Thread(impressora2);
//
//        thread1.setPriority(10);
//        thread2.setPriority(1);
//
//        thread1.start();
//        thread2.start();

        var tarefa = new RealizaTarefa();
        var thread1 = new Thread(tarefa);
        System.out.println(thread1.isAlive());
        thread1.start();
        thread1.join();
        System.out.println(thread1.isAlive());
    }
}
