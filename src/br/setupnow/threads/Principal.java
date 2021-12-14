package br.setupnow.threads;

import java.awt.*;

public class Principal {

    private static Carro[] carros;
    private static Panel[] pista;
    private static int N = 10;

    public static void main(String[] args) {
        Janela frame = new Janela("Corrida com Concorrência");
        frame.setLayout(new GridLayout(N, 1));
        carros = new Carro[N];
        pista = new Panel[N];

        for (int i = 0; i < N; i++) {
            pista[i] = new Panel();
            frame.add(pista[i]);
        }

        frame.setVisible(true);

        //configura os carros:
        carros[0] = new Carro(pista[0], Color.red);
        carros[1] = new Carro(pista[1], Color.yellow);
        carros[2] = new Carro(pista[2], Color.blue);
        carros[3] = new Carro(pista[3], Color.magenta);
        carros[4] = new Carro(pista[4], Color.orange);
        carros[5] = new Carro(pista[5], Color.black);
        carros[6] = new Carro(pista[6], Color.green);
        carros[7] = new Carro(pista[7], Color.pink);
        carros[8] = new Carro(pista[8], Color.cyan);
        carros[9] = new Carro(pista[9], Color.gray);

        int j = (int) (10 * Math.random());
        carros[j].setPriority(1);

        for (int i = 0; i < N; i++) {
            carros[i].start();
        }
        
        System.out.println("\tCarro com maior prioridade: " + carros[j].getName());
    }
}