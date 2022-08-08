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
import java.util.*;

public class CajeroAutomatico {
    static int dineroTotalCajero = 20000;
    static Stack<String>transacciones = new Stack<>();
    static int cantidadTransacciones = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int limiteRetiro = 15000;
      
      Scanner entrada= new Scanner(System.in); 
      int dineroSolicitado = 0;
      
      System.out.println("Ingrese la cantidad de dinero que necesita retirar: ");
      dineroSolicitado=entrada.nextInt();
      
        
        if (dineroSolicitado > limiteRetiro) {
            System.out.println("Por favor ingrese un numero menor a LPS. 15,000");
            main(null);
        } else {
            retirarDinero(dineroSolicitado);
        }  
    }
    
    public static void retirarDinero(int dineroRetirar) {
      
      final int BILLETES[]= {500,200,100,50,20,10,5,2,1};
      int billetesEntregados[]= new int[BILLETES.length];
      int dineroEntregado=0, dineroRestante=0;
      
      
      if (dineroRetirar <= dineroTotalCajero ) {
        dineroRestante=dineroRetirar;
        System.out.println("Desglose de Billetes a entregar: ");
        for (int x = 0; x < BILLETES.length; x++) {
            if (dineroRestante>=BILLETES[x]) {
               billetesEntregados[x]= dineroRestante/BILLETES[x];     //Conocer cuantos billetes tengo en la denominacion
               dineroEntregado=billetesEntregados[x]*BILLETES[x];     //Dinero entregando con estos billetes
               dineroRestante-=dineroEntregado;                       //Restar esa cifra para saber cuanto me falta pagar
           
            } else { 
                billetesEntregados[x]=0;
            }
        System.out.println("Billetes de "+BILLETES[x]+" entregados: " + billetesEntregados[x] + " Dinero Entregado: " + dineroEntregado + " Dinero Restante: " + dineroRestante);
      }
        cantidadTransacciones++;
        dineroTotalCajero=dineroTotalCajero - dineroEntregado;
        transacciones.push(("Usted ha retirado: " + dineroEntregado + " En su " + cantidadTransacciones + " intento"));
        System.out.println("Total en cajero: " + dineroTotalCajero);
          System.out.println("A. Desea imprimir transacciones? o B. Desea realizar otra transaccion?");
          Scanner decision = new Scanner(System.in);
          String decisionUsuario = decision.nextLine();
          if (decisionUsuario == "a") {
              main(null);
          } else {
              for (String i : transacciones) {
                  System.out.println(i);
              }
              main(null);
          }
    } else {
          System.out.println("El cajero no cuenta con los suficientes fondos para la transaccion, ¿desea recargar?");
          System.out.println("\n Ingrese si o no");
          Scanner respuesta= new Scanner(System.in);
          String respuestaUsuario = respuesta.nextLine();
           if (respuestaUsuario == "si" ){
               System.out.println("Cuanto quieres recargar?");
             Scanner cantidad= new Scanner(System.in); 
             dineroTotalCajero = dineroTotalCajero + cantidad.nextInt();
             main(null);
           }else{
               System.out.println("Por el momento el cajero cuenta con fondos insuficientes"); 
           }
      }
    }
    
}
