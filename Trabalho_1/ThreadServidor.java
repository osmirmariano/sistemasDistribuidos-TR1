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
            
            numeros = new int[3];
            numeros[0] = receber.readInt();
            //Tratando número negativo
            if (numeros[0] < 0) {
                System.err.println("\nAtenção o número é negativo. O programa irá encerrar.\n");
                System.exit(0);
            }
            
            int maior = numeros[0];
            int menor = numeros[0];
            int x;

            //Realizando verificação do maior e menor
            for (x = 1; x <= 2; x++) {
                numeros[x] = receber.readInt();
                if (numeros[x] > maior) {
                    maior = numeros[x];
                } 
                else{
                    if (numeros[x] < menor) {
                        menor = numeros[x];
                    }
                } 
            }

            enviar.writeInt(maior);
            enviar.writeInt(menor);
            socket.close();
        } 
        catch (IOException e) {
            System.out.print("Erro " + e);
        }
    }

}