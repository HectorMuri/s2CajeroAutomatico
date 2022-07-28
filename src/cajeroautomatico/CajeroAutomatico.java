/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajeroautomatico;

/**
 *
 * @author m_mur
 */

import java.util.Scanner;

public class CajeroAutomatico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Scanner entrada= new Scanner(System.in);
      //Inicializar el objeto scanner con su constructor (pasamos el system input)
      
      int dineroSolicitado=0;
      final int BILLETES[]= {500,200,100,50,20,5,2,1};
      int billetesEntregados[]= new int[BILLETES.length];
      int dineroEntregado=0,dineroRestante=0;
      
        System.out.println("Ingrese la cantidad de dinero que necesita retirar: ");
        dineroSolicitado=entrada.nextInt();
        
        dineroRestante=dineroSolicitado;
        for (int x = 0; x < BILLETES.length; x++) {
            if (dineroRestante>=BILLETES[x]) {
               billetesEntregados[x]= dineroRestante/BILLETES[x];     //Conocer cuantos billetes tengo en la denominacion
               dineroEntregado=billetesEntregados[x]*BILLETES[x];     //Dinero entregando con estos billetes
               dineroRestante-=dineroEntregado;                       //Restar esa cifra para saber cuanto me falta pagar
           
            }else{ billetesEntregados[x]=0;
        }
            System.out.println("Billetes de "+BILLETES[x]+" entregados: " + billetesEntregados[x] + " Dinero Entregado: " + dineroEntregado + " Dinero Restante: " + dineroRestante);
        
        
    }
    
}
}
