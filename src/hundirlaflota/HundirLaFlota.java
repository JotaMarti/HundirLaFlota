
package hundirlaflota;

import java.util.Scanner;



public class HundirLaFlota {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int[] movimiento=new int[2];
       final int[] tablero={5,7};
       int movimientos=0;
       
       System.out.println("Bienvenido al juego **HUNDIR LA FLOTA**");
       System.out.println("INICIO DEL JUEGO");
       tableroJugador tablero1=new tableroJugador(tablero);
       tableroMaquina tablero2=new tableroMaquina(tablero1.GetArray());
       tablero1.setPosicionBarco(tablero2.GetPosicionBarco());
       System.out.println(tablero2.GetPosicionBarco()[0]);
       System.out.println(tablero2.GetPosicionBarco()[1]);
       
    while(movimientos<3){
        tablero1.dibujaTablero();
        System.out.println();
        
        
        System.out.println("Introduce fila");
        movimiento[0]=Integer.parseInt(sc.nextLine());
       
        System.out.println("Introduce columna");
        movimiento[1]=Integer.parseInt(sc.nextLine());
       
        tablero1.realizaMovimiento(movimiento);
        movimientos++;
    }
       
    System.out.println("Lo has hecho en: " + movimientos + " movimientos!");
    System.out.println();
    }
    
}
