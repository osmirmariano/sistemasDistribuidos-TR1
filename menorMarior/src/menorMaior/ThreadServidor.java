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

public class ThreadServidor extends Thread {

    public Socket socket;
    String cadena = "Testando aplicação";

    DataOutputStream leitura;
    DataInputStream escrita;

    public ThreadServidor(Socket s1) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            leitura = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIN = new DataInputStream(socket.getInputStream());
            
            int[] m = new int[3];
            m[0] = sIN.readInt();
            
            if (m[0] < 0) {
                System.err.println("Atenção o número é negativo. O programa irá encerrar.");
                System.exit(0);
            }
            
            int maior = m[0];
            int menor = m[0];
            for (int i = 1; i <= 2; i++) {
                m[i] = sIN.readInt();
                if (m[i] > maior) {
                    maior = m[i];
                } else if (m[i] < menor) {
                    menor = m[i];
                }
            }
            leitura.writeInt(maior);
            leitura.writeInt(menor);

            socket.close();

        } catch (IOException e) {
            System.out.print("Erro = " + e);
        }
    }

}