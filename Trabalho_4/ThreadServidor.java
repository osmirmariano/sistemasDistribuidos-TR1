import java.net.*;
import java.io.*;

public class ThreadServidor extends Thread {
    public Socket socket;
    DataOutputStream enviar;
    DataInputStream receber;
    int[] numeros;

    public ThreadServidor(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            enviar = new DataOutputStream(socket.getOutputStream());
            receber = new DataInputStream(socket.getInputStream());
            
            socket.close();
        } 
        catch (IOException e) {
            System.out.print("Erro " + e);
        }
    }

}