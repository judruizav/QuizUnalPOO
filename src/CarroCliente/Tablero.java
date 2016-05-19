/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarroCliente;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
/**
 *
 * @author Estudiante
 */
public class Tablero extends JPanel implements ActionListener, KeyListener{
    private Timer timer;
    private Carro carro1;
    private ArrayList<Moneda> coin;
    private int puntajeCarro1=0;
    public Tablero(){
      this.setFocusable(true);
      this.addKeyListener(this);
      this.carro1= new Carro(100,200,puntajeCarro1);
      this.coin= new ArrayList<Moneda>();
      this.coin.add(new Moneda(300,100));
      this.coin.add(new Moneda(150,500));
      this.coin.add(new Moneda(200,150));
      this.coin.add(new Moneda(350,300));
      this.coin.add(new Moneda(250,80));
      this.coin.add(new Moneda(500,400));
      this.coin.add(new Moneda(400,280));
      this.timer = new Timer(20,this);
      this.timer.start();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Calibri", Font.BOLD, 24));
        g.drawString("Puntaje jugador 1= " + puntajeCarro1, 0, 20);
        this.carro1.paintComponent(g);
        for(int i=0; i<this.coin.size(); i++){
          this.coin.get(i).paintComponent(g, this);    
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      this.carro1.actionPerformed(e);
      validarColisiones();
      repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        this.carro1.keyPressed(e);
        repaint();
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
