
package CarroCliente;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author La Formula
 */

public class Drawing {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Carro");
        frame.setSize(new Dimension(1400,735));
        frame.add(new Tablero());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
