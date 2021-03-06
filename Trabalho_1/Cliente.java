
import java.net.*;
import java.io.*;
import java.util.Scanner;

class Cliente {
    public static void main( String args[] ) throws IOException {
        //Declaração das variáveis 
        Scanner valor = new Scanner(System.in);
        int numero, maior, menor, porta, x;
        String ip;
        Socket socket;
        DataInputStream receber;
        DataOutputStream enviar;
        
        try {
            //Inserção das informações dos dados IP e PORTA
            System.out.println("Por favor, forneça o endereço de IP: ");
            ip = valor.next();
            System.out.println("Por favor, forneça o número da Porta: ");
            porta = valor.nextInt();
            
            socket = new Socket();
            //Vinculando o endereço ao socket e realizando a conexão
            InetSocketAddress endereco = new InetSocketAddress(ip, porta);
            socket.connect(endereco, 1000);//Teste de tempo caso não seja estabelecida a conexão
            //Enviar e receber (servidor e cliente)
            receber = new DataInputStream(socket.getInputStream());
            enviar = new DataOutputStream(socket.getOutputStream());
            
            for(x = 0; x < 3; x++){
                System.out.println("Informe o "+(x+1)+"º número: ");
                numero = valor.nextInt();
                enviar.writeInt(numero);//Enviando os valores para o servidor
            }
            //Variáveis recebendo
            maior = receber.readInt();
            menor = receber.readInt();

            //Mostrando os resultados
            System.out.println("---------------------------------------");
            System.out.println("RESULTADO DO PROCESSAMENTO");
            System.out.println("---------------------------------------");
            System.out.println("O maior valor informado foi: "+maior);
            System.out.println("O menor valor informado foi: "+menor);
            System.out.println("---------------------------------------");

            socket.close();
        } 
        catch (IOException e) {
            System.out.println(e);
        }
    }
}

