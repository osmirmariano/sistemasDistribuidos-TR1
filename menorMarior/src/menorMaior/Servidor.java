package menorMaior;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author osmir
 */
import java.net.*;
import java.io.*;

class Servidor {
    public static void main( String args[] ) throws IOException {
        ServerSocket servico = (ServerSocket)null;
        Socket socket;
      
        DataOutputStream escrita;
        
        try {
            servico = new ServerSocket(4321);
        } catch( IOException e ) {
            System.out.println( e );
        }

        while(true) {
            try {
                socket = servico.accept();
                ThreadServidor st = new ThreadServidor(socket);
                st.start();
            } 
            catch( IOException e ){
                System.out.println( e );
            }
        }
    }
}