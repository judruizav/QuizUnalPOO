
package CarroServer;

import CarroCliente.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author La Formula
 */
public class Carro extends JPanel implements KeyListener{
    private int x;
    private int y;
    private int puntaje;
    
    public Carro(int x, int y, int puntaje){
       this.x= x;
       this.y= y;
       this.puntaje=puntaje;
    }    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(20+x, 110+y, 50, 50);
        g.fillOval(100+x, 110+y, 50, 50);
        g.setColor(Color.BLUE);
        g.fillRect(10+x, 60+y, 150, 50);
        Polygon  poligono = new Polygon();
        poligono.addPoint(30+x,60+y);
        poligono.addPoint(60+x,30+y);
        poligono.addPoint(110+x,30+y);
        poligono.addPoint(140+x,60+y);
        g.drawPolygon(poligono);
        g.setColor(Color.BLACK);
        g.fillPolygon(poligono);
        g.setColor(Color.lightGray);
        g.drawRect(10+x, 30+y, 150, 130);    
    }
    

    @Override
    public void keyTyped(KeyEvent e){
        
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN: y += 30; break;
            case KeyEvent.VK_UP: y -= 30; break;
            case KeyEvent.VK_LEFT: x -= 30; break;
            case KeyEvent.VK_RIGHT: x += 30; break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e){
        
    }
    
    public void mover(){
        x+=5;
    } 
    
    public Rectangle obtenerRectangulo(){
        return new Rectangle(10+x, 30+y, 150, 120);    
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
}
