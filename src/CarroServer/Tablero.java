
package CarroServer;

import CarroCliente.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author La Formula
 */

public class Tablero extends JPanel implements ActionListener, KeyListener{
    private Timer timer;
    private ServerSocket serverSocket;
    private Carro carro1;
    private Carro carro2;
    private ArrayList<Moneda> coin;
    private int puntajeCarro1=0;
    private int puntajeCarro2=0;
    
    public Tablero(){
        this.setFocusable(true);
        try {
            serverSocket= new ServerSocket(8000);
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.addKeyListener(this);
        this.carro1= new Carro(50,50,puntajeCarro1);
        this.carro2= new Carro(1050,50,puntajeCarro2);
        this.coin= new ArrayList<Moneda>();
        this.coin.add(new Moneda(450,150));
        this.coin.add(new Moneda(500,150));
        this.coin.add(new Moneda(550,150));
        this.coin.add(new Moneda(600,150));
        this.coin.add(new Moneda(650,150));
        this.coin.add(new Moneda(700,150));
        this.coin.add(new Moneda(750,150));
        this.coin.add(new Moneda(800,150));
        this.coin.add(new Moneda(850,150));
        this.coin.add(new Moneda(450,200));
        this.coin.add(new Moneda(450,250));
        this.coin.add(new Moneda(450,300));
        this.coin.add(new Moneda(450,350));
        this.coin.add(new Moneda(500,350));
        this.coin.add(new Moneda(550,350));
        this.coin.add(new Moneda(600,350));
        this.coin.add(new Moneda(650,350));
        this.coin.add(new Moneda(700,350));
        this.coin.add(new Moneda(750,350));
        this.coin.add(new Moneda(800,350));
        this.coin.add(new Moneda(850,350));
        this.coin.add(new Moneda(850,400));
        this.coin.add(new Moneda(850,450));
        this.coin.add(new Moneda(850,500));
        this.coin.add(new Moneda(850,550));
        this.coin.add(new Moneda(800,550));
        this.coin.add(new Moneda(750,550));
        this.coin.add(new Moneda(700,550));
        this.coin.add(new Moneda(650,550));
        this.coin.add(new Moneda(600,550));
        this.coin.add(new Moneda(550,550));
        this.coin.add(new Moneda(500,550));
        this.coin.add(new Moneda(450,550));
        this.timer = new Timer(20,this);
        this.timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
        g.drawString("Puntaje jugador 1= " + puntajeCarro1, 0, 20);
        g.drawString("Puntaje jugador 2= " + puntajeCarro2, 0, 40);
        this.carro2.paintComponent(g);
        this.carro1.paintComponent(g);
        for(int i=0; i<this.coin.size(); i++){
            this.coin.get(i).paintComponent(g, this);    
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        validarColisiones();
        Thread moverCarro1= new Thread(new Handlepos(this.serverSocket, this.carro1));
        //Thread moverCarro2= new Thread(new Handlepos(this.serverSocket, this.carro2));
        moverCarro1.start();
        //moverCarro2.start(); 
        repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        this.carro1.keyPressed(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        this.carro1.keyReleased(e);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        this.carro1.keyTyped(e);
    }
    
    public void validarColisiones(){
        Rectangle r1= this.carro1.obtenerRectangulo();
        for(int i=0; i<this.coin.size(); i++){
            Rectangle r2= this.coin.get(i).getRectangle();
            if(r1.intersects(r2)){
                this.coin.remove(i);
                puntajeCarro1++;
            }
        }
    }
    

     

}
