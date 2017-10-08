
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
     public static void main(String args[]) throws IOException {
        Scanner valor = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);

        int porta, quantProdutos, quantidade, opcao = 0;
        String ip, saida;
        Socket socket;
        DataInputStream leitura;
        DataOutputStream escrita;

        do{
            try {
                //Inserindo IP e PORTA
                System.out.println("-------------------DADOS PARA ACESSO----------------");
                System.out.println("Por favor, forneça o endereço de IP: ");
                ip = valor.next();
                System.out.println("Por favor, forneça o número da Porta: ");
                porta = valor.nextInt();
                System.out.println("----------------------------------------------------");

                //Criando objeto Socket
                socket = new Socket();
                //Associando o endereço de ip e porta ao servidor
                InetSocketAddress endereco = new InetSocketAddress(ip, porta);
                socket.connect(endereco, 1000);//Concetando 
                //Escrevendo para socket saida
                escrita = new DataOutputStream(socket.getOutputStream());
                leitura = new DataInputStream(socket.getInputStream());
                
                //Inserindo as informações do produto
                System.out.println("-----------------INFORMAÇÕES PRODUTO---------------");
                System.out.println("Digite o nome do produto:");
                String nome = entrada.next();
                System.out.println("Digite a quantidade do produto:");
                quantidade = entrada.nextInt();
                System.out.println("----------------------------------------------------");
                /*while(quantidade <= 0){
                    System.out.println("Valor para quantidade de produto inválido");
                    System.out.println("Digite a quantidade do produto:");
                    quantidade = entrada.nextInt();
                }*/

                escrita.writeUTF(nome);
                escrita.writeInt(quantidade);
                quantProdutos = leitura.readInt();
                //Tratamento para caso seja negatia
                
                if (quantProdutos < 0) {
                    saida = leitura.readUTF();
                    System.out.println(saida);
                } 
                //Condição para atualizar estoque
                else if (quantProdutos >= 0 && quantProdutos <= 2000) {
                    System.out.println("Estoque atualizado e quantidade de  produtos igual a " +quantProdutos);
                    }
                    //Condição para inserção de novo produto
                    else if(quantProdutos >= 2001){
                        saida = leitura.readUTF();
                        System.out.println(saida);
                    }
                socket.close();
            } 
            catch (IOException e) {
                System.out.println(e);
            }

            System.out.println("----------------DESEJA CONTINUAR-----------------");
            System.out.println(" 1 - SIM");
            System.out.println(" 0 - NÃO ");
            System.out.println("--------------------------------------------------");
            opcao = entrada.nextInt();

        }while(opcao != 0 );
    }
}
