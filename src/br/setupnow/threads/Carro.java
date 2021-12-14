package br.setupnow.threads;

import java.awt.*;

public class Carro extends Thread {
    
    // Carro - thread
    private int id;
    
    // Posição do carro na corrida
    private int posicao = 0; 
    
    // Cor do carro
    private Color cor;
    
    // Nº de threads
    private static int numCarros = 0;;
    
    // Parte visual
    private Panel canvas;
    
    // Nº de iterações
    private static int N = 1000; 

    public Carro(Panel p, Color c) {
        id = numCarros++;
        canvas = p;
        cor = c;
    }

    public void desenhaCarro() {
        
        Graphics g = canvas.getGraphics();
        Dimension d = canvas.getSize();
        
        int larg = d.height;
        int x = posicao * d.width / N;

        g.setColor(cor);
        g.fillOval(x, larg / 2 - 10, 40, 20);
        g.setColor(Color.white);
        g.drawString(String.valueOf(id), x + 20, larg / 2 + 6);
        g.setColor(Color.black);

        g.fillOval(x + 10, larg / 2 - 10, 6, 4);
        g.fillOval(x + 10, larg / 2 + 6, 6, 4);
        g.fillOval(x + 24, larg / 2 - 10, 6, 4);
        g.fillOval(x + 24, larg / 2 + 6, 6, 4);
    }

    public void apagaCarro() {
        
        Graphics g = canvas.getGraphics();
        Dimension d = canvas.getSize();
        Color fundo = canvas.getBackground();
        int larg = d.height;
        int x = posicao * d.width / N;

        g.setColor(fundo);
        g.fillOval(x, larg / 2 - 20, 6, 40);
        g.setColor(Color.black);
        g.drawLine(x, larg / 2, d.width, larg / 2);
    }

    public void mover() {
        
        apagaCarro();
        posicao++;
        desenhaCarro();
    }

    public void run() {
        
        desenhaCarro();
        while (posicao < N) {
            
            try {
                
                Thread.sleep(10);
                // Move os carros de forma aleatória
                int j = (int) (10 * Math.random());
                for (int i = 1; i < j; i++) {
                    mover();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Chegada...:" + id);
    }
}