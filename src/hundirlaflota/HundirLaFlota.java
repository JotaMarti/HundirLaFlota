
package hundirlaflota;

import java.util.Scanner;



public class HundirLaFlota {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int[] movimiento=new int[2];
       final int[] tablero={5,7};
       System.out.println("Bienvenido al juego **HUNDIR LA FLOTA**");
       System.out.println("INICIO DEL JUEGO");
       
       tableroJugador tablero1=new tableroJugador(tablero);
       
       tablero1.dibujaTablero();
       System.out.println();
       
       System.out.println("Introduce fila");
       movimiento[0]=Integer.parseInt(sc.nextLine());
       
       System.out.println("Introduce columna");
       movimiento[1]=Integer.parseInt(sc.nextLine());
       
       tablero1.realizaMovimiento(movimiento);
       
       tablero1.dibujaTablero();
       System.out.println();
    }
    
}
