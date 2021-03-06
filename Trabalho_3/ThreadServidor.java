
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ThreadServidor extends Thread {
    
    public Socket socket;
    String nomeProd;
    int qtdadeprodu;
    String p;
    int qd, i, flag = 2001;
    int aux, contador = 1;
    DataOutputStream s1out;
    Scanner entrada = new Scanner(System.in);
    
    public ThreadServidor(Socket socket) {
        super();
        this.socket = socket;
    }
    
    public void run() {
        try {
            s1out = new DataOutputStream(socket.getOutputStream());
            DataInputStream sIN = new DataInputStream(socket.getInputStream());
            String[] produtos = new String[30];
            int[] quantidade = new int[30];
            nomeProd = sIN.readUTF();
            qtdadeprodu = sIN.readInt();
             
            if (nomeProd.equalsIgnoreCase("terminar")) {
                System.err.println("Finalizado servidor");
                System.exit(0);
             }
             
            produtos[0] = "Teste";
            quantidade[0] = 2;
            
            for (i = 0; i < produtos[i].length(); i++) {
                if (produtos[i].equalsIgnoreCase(nomeProd)) {
                    if (qtdadeprodu > 0) {
                        quantidade[i] = quantidade[i] + qtdadeprodu;
                        s1out.writeInt(quantidade[i]);
                        break;
                    } 
                    else if (qtdadeprodu < 0) {
                        aux = quantidade[i] + qtdadeprodu;
                    //    System.out.println("valor do aux " + aux);
                        if (aux < 0) {
                            s1out.writeInt(aux);
                            s1out.writeUTF("não é possível fazer a saída de estoque – quantidade menor que o valor desejado");
                          //  System.out.println("Quantidade Indisponivel ");
                            break;
                        } 
                        else if (aux >= 0) {
                            quantidade[i] = aux;
                            s1out.writeInt(quantidade[i]);
                            break;
                        }
                    }
                } 
                else if (!produtos[i].equalsIgnoreCase(nomeProd) && qtdadeprodu > 0) {
                    System.out.println("Digite o nome do produto que deseja cadastrar:");
                    p = entrada.next();
                    System.out.println("Digite a quatidade:");
                    qd = entrada.nextInt();
                    
                    produtos[i + 1] = p;
                    quantidade[i + 1] = qd;
                    System.out.println("produto inserido");
                    s1out.writeInt(flag);
                    s1out.writeUTF("produto inserido com sucesso");
                    
                    contador++;
                    break;
                } 
                else {
                    System.out.println("produto inexsitente");   
                }
            }
            
            for (i = 0; i < qtdadeprodu; i++) {
                System.out.print("produto " + produtos[i] + " Quantidade " + quantidade[i]);
                System.out.println("\n-------------------------------");
            }
            socket.close();
        } 
        catch (Exception e) {
            System.out.print("Erro = " + e);
        }
    }
}
