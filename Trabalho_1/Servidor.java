
import java.net.*;
import java.io.*;

class Servidor{
    public static void main( String args[] ) {
        //Declaração das variáveis
        ServerSocket servico = (ServerSocket)null;
        Socket socket;
        DataOutputStream escrita;
        
        try {
            //Criar o ServerSocket, espear a conexão na porta 4321
            servico = new ServerSocket(4321);
        } 
        catch( IOException e ) {
            //Exceção
            System.out.println( e );
        }

        while(true) {
            try {
                //Criando objeto socket para tratar a conexão com o cliente, assim
                //que o pedido chegar da conexão ao servidor
                socket = servico.accept();
                //Criação do objeto do servidor Thread para execução
                ThreadServidor serviceThread = new ThreadServidor(socket);
                serviceThread.start();
            } 
            catch( IOException e ){
                System.out.println( e );
            }
        }
    }
}