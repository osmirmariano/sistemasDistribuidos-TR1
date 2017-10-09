import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadServidor extends Thread{ 
    public Socket socket;
     
    public ThreadServidor(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run(){
        try { 
              //Para enviar objeto 
              ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
              Quadrilatero dados = new Quadrilatero();

              dados.indicaTipoQuadrilatero();
              saida.writeObject(dados);
              saida.flush();
              socket.close();
        } 
        catch (Exception e) {
            System.out.print("Erro = "+e);
        }
    }
    
}
