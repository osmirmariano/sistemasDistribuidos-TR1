
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
        DataInputStream receber;
        DataOutputStream enviar;
        
        try {
            System.out.println("Por favor, forneça o endereço de IP: ");
            ip = valor.next();
            System.out.println("Por favor, forneça o número da Porta: ");
            porta = valor.nextInt();
            
            socket = new Socket();
            //Vinculando o endereço ao socket e realizando a conexão
            InetSocketAddress endereco = new InetSocketAddress(ip, porta);
            socket.connect(endereco, 1000);//Teste de tempo caso não seja estabelecida a conexão

            receber = new DataInputStream(socket.getInputStream());
            enviar = new DataOutputStream(socket.getOutputStream());
            
            

            socket.close();
        } 
        catch (IOException e) {
            System.out.println(e);
        }
    }
}

