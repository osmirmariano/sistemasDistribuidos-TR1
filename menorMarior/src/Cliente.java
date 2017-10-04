
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author osmir
 */
public class Cliente {
    public static void main( String args[] ) throws IOException {
        int porta, num1 = 0, num2 = 0, num3 = 0;
        String ip;
        Socket so;
        DataInputStream soEntrada;
        DataOutputStream soSaida;
        
        Scanner n1 = new Scanner(System.in);
        Scanner n2 = new Scanner(System.in);
        Scanner n3 = new Scanner(System.in);
        Scanner entrada1 = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);
        
        System.out.println("Informe a porta: ");
        porta = entrada1.nextInt();
        System.out.println("Informe o IP: ");
        ip = entrada2.nextLine();
        
        try{
           so = new Socket();
           InetSocketAddress endereco = new InetSocketAddress(ip, porta);
           so.connect(endereco,1000);  
           soSaida = new DataOutputStream(so.getOutputStream());
           
           System.out.println("Informe o 1º número: ");
           num1 = n1.nextInt();
           System.out.println("Informe o 2º número: ");
           num1 = n2.nextInt();
           System.out.println("Informe o 3º número: ");
           num1 = n3.nextInt();
           
           //soSaida.write(num1, num2, num3);
        }
        catch(IOException e){
            
        }
    }
   
}
