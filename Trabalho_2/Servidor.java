
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main( String args[] ) {
        ServerSocket servico = (ServerSocket)null;
        Socket socket;
        DataOutputStream escrita;
       
        try {
            servico = new ServerSocket(4321);
        } 
        catch( IOException e ) {
            System.out.println(e);
        }

        while(true) {
            try {
                socket = servico.accept();
                ThreadServidor serviceThread = new ThreadServidor(socket);
                serviceThread.start();
                
            } 
            catch( IOException e ) {
                System.out.println( e );
            }
        }
    }
}