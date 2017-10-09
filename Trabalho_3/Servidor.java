
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main( String args[] ) {
        ServerSocket servico = (ServerSocket)null;
        Socket socket;

        try {
            servico = new ServerSocket(4321);
        } 
        catch(IOException e) {
            System.out.println(e);
        }
        while(true) {
            try {
                socket = servico.accept();
                ThreadServidor servidorThread = new ThreadServidor(socket);
                servidorThread.start();
            } 
            catch( IOException e ) {
                System.out.println( e );
            }
        }
    }
}
