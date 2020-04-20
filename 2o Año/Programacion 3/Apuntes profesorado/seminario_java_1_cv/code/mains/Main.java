package mains;

import modelo.m2.OtraClase;
import modelo.MiClase;

/**
 * Clase de ejemplo: documentamos brevemente el cometido 
 * de la clase
 * @author drizo
 * @version 1.8.2011
 */ 
public class Main {
 
  /**
  * Esto es un campo que vale para ...
  */
  private int x;
  
  private int y; // esto no sale en el javadoc

  /**
   * hace tal operacion....
   * @param ax Es el radio de ...
   * @param ab Si es cierto pasa ...
   */
   public void metodo(int ax, boolean ab) {
     // ...
   }
  
    /**
    * Getter.
    * @return un valor siempre mayor que cero...
    */
    public double getX() {
        return x;
    }
  
  /**
   * Programa principal
   * @param args argumentos de la linea de ordenes
   */   
  public static void main(String args[]) {
      System.out.println("En main.");
      MiClase.llamame();
      OtraClase.llamame();
  }
}
