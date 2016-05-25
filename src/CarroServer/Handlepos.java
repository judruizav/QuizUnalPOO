/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarroServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian
 */
public class Handlepos implements Runnable{
    private int x;
    private int y;
    private ServerSocket serverSocket;
    private Carro carro;

    public Handlepos( ServerSocket serverSocket, Carro carro) {
        this.serverSocket = serverSocket;
        this.carro = carro;
    }
 
    @Override
    public void run() {
        try {
            Socket socket=this.serverSocket.accept();
            DataInputStream is= new DataInputStream(socket.getInputStream());
            while(true){
              System.out.println(this.carro.getX());
              System.out.println(getX());
              this.x= is.readInt();
              this.y= is.readInt();
              this.carro.setX(is.readInt());
              this.carro.setY(is.readInt());
            }
        } catch (IOException ex) {
          System.out.println(ex.getLocalizedMessage());
        }
        
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
