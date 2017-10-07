/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author osmir
 */
public class Servidor {
    public static void main( String args[] ) {
        ServerSocket s = (ServerSocket)null;
        Socket s1;
      

        try {
            s = new ServerSocket( 4322,300 );
        } catch( IOException e ) {
            System.out.println( e );
        }

        while( true ) {
            try {

                s1 = s.accept();
                
                ThreadServidor st = new ThreadServidor(s1);
                st.start();
            } catch( IOException e ) {
                System.out.println( e );
                }
            }
        }
}
