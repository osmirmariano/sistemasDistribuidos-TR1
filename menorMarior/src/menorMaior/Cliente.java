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
import java.util.Scanner;

class Cliente {
    public static void main(String args[]) throws IOException {
        //Declaração das variáveis 
        Scanner valor = new Scanner(System.in);
        int numero, maior, menor, porta, x;
        String ip;
        Socket socket;
        DataInputStream leitura;
        DataOutputStream escrita;
        
        try {
            System.out.println("Por favor, forneça o endereço de IP: ");
            ip = valor.next();
            System.out.println("Por favor, forneça o número da Porta: ");
            porta = valor.nextInt();
            
            //System.out.println("IP = " + ip + " porta " + porta);
            socket = new Socket();
            
            //Vinculando o endereço ao socket e realizando a conexão
            InetSocketAddress endereco = new InetSocketAddress(ip, porta);
            socket.connect(endereco, 1000);

            leitura = new DataInputStream(socket.getInputStream());
            escrita = new DataOutputStream(socket.getOutputStream());
            
            
            for(x = 0; x < 3; x++){
                System.out.println("Informe o "+(x+1)+"º número: ");
                numero = valor.nextInt();
                escrita.writeInt(numero);
            }
            
            maior = leitura.readInt();
            menor = leitura.readInt();
            System.out.println("Maior = "+maior);
            System.out.println("Menor = "+menor);

            socket.close();
        } 
        catch (IOException e) {
            System.out.println(e);
        }
    }
}

