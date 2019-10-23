package hundirlaflota;

import java.util.Scanner;

public class HundirLaFlota {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] movimiento = new int[2];
        final int[] tablero = {50,50};
        int movimientos = 0;
        int numeroMovimientos;
        String[][] tableroJugador;
        int[][] tableroMaquina;
        Boolean ganado=false;

        System.out.println("Bienvenido al juego **HUNDIR LA FLOTA**");
        System.out.println("INICIO DEL JUEGO");
        
        while ((tablero[0]<4 | tablero[0]>20) | (tablero[1]<4 | tablero[1]>20)) {
            System.out.println("Introduce una medida de tablero de entre 4x4 a 20x20");
            try {
                System.out.println("Introduce el numero de filas");
                tablero[0] = Integer.parseInt(sc.nextLine());
                System.out.println("Introduce el numero de columnas");
                tablero[1] = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Introduce una medida de tablero de entre 4x4 a 20x20");
            }
        }
        numeroMovimientos=((tablero[0] * tablero[1]) - 10);
        
             
        tableroJugador=new String[tablero[0]+1][tablero[1]+1];
        tableroJugador[0][0]="         ";
        
        // Inserto los numeros de las columnas
        for(int j=1;j<tableroJugador[1].length;j++){
            if(j>=10){
                tableroJugador[0][j]=Integer.toString(j)+"     ";
            } else {
                tableroJugador[0][j]=Integer.toString(j)+"      ";
            }
            
        } 
        
        // Inserto los numeros de las filas
        for(int i=1;i<tableroJugador.length;i++){
            if(i>=10){
                tableroJugador[i][0]=Integer.toString(i) + "  ";
            } else {
                tableroJugador[i][0]=Integer.toString(i) + "   ";
            }
              
        }
        
        // Llena el tablero
        for(int i=1;i<tableroJugador.length;i++){
           for(int j=1;j<tableroJugador[1].length;j++){
               tableroJugador[i][j]="[     ]";
           } 
        }
        
        prueba
        
        
                
        
        
        
        
        //tengo que fabricar el tablero de la maquina
        tableroMaquina tablero2 = new tableroMaquina(tablero);
        tablero1.setPosicionBarco(tablero2.GetPosicionBarco());

        while (tablero1.GetGanado() == false & movimientos < numeroMovimientos) {
            tablero1.dibujaTablero();
            System.out.println();
            System.out.println();
            if (movimientos == 1) {
                System.out.println("AGUA!!! Llevas " + movimientos + " movimiento realizado y te quedan " + (numeroMovimientos - movimientos) + " movimientos para finalizar el juego!!!");
            } else if (movimientos > 1) {
                System.out.println("AGUA!!! Llevas " + movimientos + " movimientos realizados y te quedan " + (numeroMovimientos - movimientos) + " movimientos para finalizar el juego!!!");
            }

            do {
                movimiento[0] = (tablero[0] + 100);
                while (movimiento[0] > tablero[0] | movimiento[0] <= 0) {
                    try {
                        System.out.println();
                        System.out.println("Introduce fila");
                        movimiento[0] = Integer.parseInt(sc.nextLine());

                    } catch (Exception e) {
                        System.out.println("Por favor introduce un numero del 1 al " + tablero[0]);
                    }
                }

                movimiento[1] = (tablero[1] + 100);
                while (movimiento[1] > tablero[1] | movimiento[1] <= 0) {
                    try {
                        System.out.println("Introduce columna");
                        movimiento[1] = Integer.parseInt(sc.nextLine());

                    } catch (Exception e) {
                        System.out.println("Por favor introduce un numero del 1 al " + tablero[1]);
                    }
                }
                if (tablero1.GetArray()[movimiento[0]][movimiento[1]] == "[AGUA ]") {
                    System.out.println();
                    System.out.println("Cordenas ya introducidas anteriormente, por favor inseterte unas nuevas cordenadas.");
                }
            } while (tablero1.GetArray()[movimiento[0]][movimiento[1]] == "[AGUA ]");

            tablero1.realizaMovimiento(movimiento);
            movimientos++;
        }

        tablero1.dibujaTableroPerdedor();

        System.out.println();
        System.out.println();

        if (tablero1.GetGanado() == false) {
            System.out.println("No has encontrado el barco en: " + movimientos + " movimiento/s!, el barco estaba en la fila: " + tablero2.GetPosicionBarco()[0] + " y en la columna: " + tablero2.GetPosicionBarco()[1]);
        } else {
            System.out.println("Enhorabuena!!!, has encontrado el barco en " + movimientos + " movimiento/s!!");
        }

        System.out.println();
    }

}
