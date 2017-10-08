import java.io.Serializable;
import java.util.Scanner;

public class Quadrilatero implements Serializable {
    //Atributos
    String tipoQdrilatero;
    int  lado1, lado2, lado3, lado4;

    //Construtor
    public Quadrilatero() {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.lado4 = lado4;
        this.tipoQdrilatero = tipoQdrilatero;         
    }

    //Método lerDados
    public void lerDados() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o valor do 1º lado");
        lado1 = entrada.nextInt();
        System.out.println("Informe o valor do 2º lado");
        lado2 = entrada.nextInt();
        System.out.println("Informe o valor do 3º lado");
        lado3 = entrada.nextInt();
        System.out.println("Informe o valor do 4º lado");
        lado4 = entrada.nextInt();
    }

    //Método indicaTipoQuadrilatero
    public String indicaTipoQuadrilatero(){
        if(lado1 == lado2  && lado2 == lado3 && lado3 == lado4 && lado4 == lado1){
            tipoQdrilatero = "Quadrado";    
        }
        else if(lado1==lado3 || lado2==lado4){
            tipoQdrilatero = "Retangulo";
        }
        else{
            tipoQdrilatero = "Quadrilatero";
        }
        return tipoQdrilatero;
    }

    //Método mostraDados
    public void mostraDados(){
        System.out.println("----------------------------------------");
        System.out.println("\tDADOS:");
        System.out.println("----------------------------------------");
        System.out.println("LADO 1: " + lado1);
        System.out.println("LADO 2: " + lado2);
        System.out.println("LADO 3: " + lado3);
        System.out.println("LADO 4: " + lado4);
        System.out.println("Tipo:  " + indicaTipoQuadrilatero());
    } 
}