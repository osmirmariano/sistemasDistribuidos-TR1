/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadrilatero;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author osmir
 */
public class Cliente {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
       
        Socket s;
       

        try {

            s = new Socket();

            InetSocketAddress endereco = new InetSocketAddress("localhost", 4321);
            s.connect(endereco, 1000);

            ObjectInputStream entrada = new ObjectInputStream(s.getInputStream());
            Quadrilatero alo = (Quadrilatero) entrada.readObject();
            alo.lerdados();
            alo.mostradados();
            
            
            s.close();
                                               
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
