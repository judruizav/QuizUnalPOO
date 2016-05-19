/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarroCliente;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
/**
 *
 * @author Estudiante
 */
public class Drawing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Carro");
        frame.setSize(new Dimension(1000, 1000));
        frame.add(new Tablero());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
