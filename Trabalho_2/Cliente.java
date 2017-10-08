import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Scanner valor = new Scanner(System.in);
        Socket socket;
        String ip;
        int porta;

        try {
            System.out.println("Por favor, forneça o endereço de IP: ");
            ip = valor.next();
            System.out.println("Por favor, forneça o número da Porta: ");
            porta = valor.nextInt();

            socket = new Socket();
            //Vinculando o endereço ao socket e realizando a conexão
            InetSocketAddress endereco = new InetSocketAddress(ip, porta);
            socket.connect(endereco, 1000);

            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            Quadrilatero dados = (Quadrilatero) entrada.readObject();

            dados.lerDados();
            dados.mostraDados();
            socket.close();

        } 
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
