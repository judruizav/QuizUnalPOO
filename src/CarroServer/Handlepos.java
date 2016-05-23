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
    private Socket socket;
    private int x;
    private int y;
    private ServerSocket serverSocket;
    private Carro carro;

    public Handlepos(Socket socket, ServerSocket serverSocket, Carro carro) {
        this.socket = socket;
        this.serverSocket = serverSocket;
        this.carro = carro;
    }
 
    @Override
    public void run() {
        try {
            this.socket=this.serverSocket.accept();
            DataInputStream is= new DataInputStream(this.socket.getInputStream());
            while(true){
              this.x= is.readInt();
              this.y= is.readInt();
              this.carro.setX(this.x);
              this.carro.setY(this.y);
            }
        } catch (IOException ex) {
          System.out.println(ex.getLocalizedMessage());
        }
        
        
    }
    
}
