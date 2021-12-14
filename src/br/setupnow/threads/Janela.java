package br.setupnow.threads;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Janela extends Frame {
    public Janela(String titulo) {
        super(titulo);
        setSize(800, 600);
        addWindowListener(new Terminator());
    }
    
    class Terminator extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
