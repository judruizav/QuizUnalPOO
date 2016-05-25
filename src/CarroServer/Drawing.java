
package CarroServer;

import CarroCliente.*;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author La Formula
 */

public class Drawing {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setTitle("Carro");
        frame.setSize(new Dimension(1400, 1200));
        Tablero t= new Tablero();
        frame.add(t);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
