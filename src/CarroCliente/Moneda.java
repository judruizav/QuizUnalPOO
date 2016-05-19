/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarroCliente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;

/**
 *
 * @author Julian
 */
public class Moneda extends JPanel{
    private int x;
    private int y;
    private Image sprite;
    
    public Moneda(int x, int y){
      this.x=x;
      this.y=y;
      this.sprite= cargarImagen("coin6.png");
    }
    
    public Image cargarImagen(String nombre){
      ImageIcon image= new ImageIcon(nombre);    
      Image coin = image.getImage();
      return coin;
    }
    
    public void paintComponent(Graphics g, JPanel panel){
      g.drawImage(sprite, x, y, 32, 32, panel);
      g.setColor(Color.lightGray);
      g.drawRect(x, y, 32, 32);
    }
    
    public Rectangle getRectangle(){
      Rectangle r= new Rectangle(x, y, 32, 32);      
      return r;
    }

        
}
