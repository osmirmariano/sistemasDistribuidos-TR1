/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadrilatero;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author osmir
 */
public class Quadrilatero implements Serializable {

    String tipoQdrilatero;
    int  lado1, lado2, lado3, lado4;
   

        public Quadrilatero() {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.lado4 = lado4;
        this.tipoQdrilatero = tipoQdrilatero;
                
    }

    public void lerdados() {
         Scanner e = new Scanner(System.in);
        lado1 = e.nextInt();
        lado2 = e.nextInt();
        lado3 = e.nextInt();
        lado4 = e.nextInt();
        
    }
    public String indicatipoquadrilatero(){
        if(lado1 == lado2  && lado2==lado3 && lado3==lado4 && lado4==lado1 ){
               tipoQdrilatero = "Quadrado";
            
        }else
        if(lado1==lado3 || lado2==lado4){
            tipoQdrilatero = "Retangulo";
            
        }else{
            tipoQdrilatero = "quadrilatero";
        }
        return tipoQdrilatero;
    }
    public void mostradados(){
     
     System.out.println("Dados do Objeto:");
     System.out.println("LADO 1 = " + lado1);
     System.out.println("LADO 2 = " + lado2);
     System.out.println("LADO 3 = " + lado3);
     System.out.println("LADO 4 = " + lado4);
     System.out.println("Tipo   = " + indicatipoquadrilatero());
     
     
    } 
    
 
}