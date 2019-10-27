package hundirlaflota;

import java.util.Scanner;

public class HundirLaFlota {

    public static void main(String[] args) {
        //Instanciamos un scanner
        Scanner sc = new Scanner(System.in);
        //Array para almacenar el ultimo movimiento del jugador
        int[] movimiento = new int[2];
        //Array para el tamaño del tablero
        int[] tablero = new int[2];
        //Variable donde guardaremos el numero de movimientos realizados por el jugador
        int movimientos = 0;
        //Variable donde guardare el numero de movimientos del que dispone el jugador
        int numeroMovimientos;
        //Array multidimensional para guardar el tablero del jugador
        String[][] tableroJugador;
        //Booleano para saber si el jugador ha ganado el juego
        Boolean ganado = false;
        //Array donde guardare la posicion del barco
        int[] posicionBarco = new int[2];
        //Array donde pondremos el tamaño minimo del tablero
        int[] tableroMinSize = {4, 4};
        //Array donde pondremos el tamaño maximo del tablero
        int[] tableroMaxSize = {20, 20};
        //Variable por si en algun momento queremos cambiar la regla de como calculamos los movimientos del jugador
        int ajusteMovimientos = 10;
        //Array con los posibles estados de las fichas del tablero
        String[] fichasTablero = {"[BARCO]", "[AGUA ]", "[     ]"};

        System.out.println("Bienvenido al juego **HUNDIR LA FLOTA**");


        /*Bucle para pedir al usuario la medida del tablero, lo he metido en un do while para no tener que iniciar la variable del tablero a algun numero
        y a parte he manejado las excepciones que puedan haber*/
        do {
            System.out.println("Introduce una medida de tablero de entre " + tableroMinSize[0] + "x" + tableroMinSize[1] + " a " + tableroMaxSize[0] + "x" + tableroMaxSize[1]);
            try {
                System.out.println("Introduce el numero de filas");
                tablero[0] = Integer.parseInt(sc.nextLine());
                System.out.println("Introduce el numero de columnas");
                tablero[1] = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Introduce una medida de tablero de entre " + tableroMinSize[0] + "x" + tableroMinSize[1] + " a " + tableroMaxSize[0] + "x" + tableroMaxSize[1]);
            }
        } while ((tablero[0] < tableroMinSize[0] | tablero[0] > tableroMaxSize[0]) | (tablero[1] < tableroMinSize[1] | tablero[1] > tableroMaxSize[1]));

        //Seteo el numero de movimientos en base al tablero
        numeroMovimientos = ((tablero[0] * tablero[1]) - ajusteMovimientos);

        //Seteo el tamaño del array del tablero del jugador y le añado un espacio en blanco en 0 0 para darle formato a la salida mas adelante    
        tableroJugador = new String[tablero[0] + 1][tablero[1] + 1];

        // Llena el tablero
        for (int fila = 0; fila < tableroJugador.length; fila++) {
            for (int columna = 0; columna < tableroJugador[1].length; columna++) {
                //Con esto insterto un espacio en blanco en 0,0 para dare formato a la tabla
                if (fila == 0 & columna == 0) {
                    tableroJugador[0][0] = "         ";
                }
                //Con este if inserto las fichas en blanco en la tabla
                if (fila > 0 & columna > 0) {
                    tableroJugador[fila][columna] = fichasTablero[2];
                }
                //Con este if pongo los numeros en las columnas, lo de tener dos posibilidades es para que quede bien con numeros de dos cifras
                if (columna >= 10) {
                    tableroJugador[0][columna] = Integer.toString(columna) + "     ";
                } else if (columna > 0) {
                    tableroJugador[0][columna] = Integer.toString(columna) + "      ";
                }
                //Con este if pongo los numeros en las filas
                if (fila >= 10) {
                    tableroJugador[fila][0] = Integer.toString(fila) + "  ";
                } else if (fila > 0) {
                    tableroJugador[fila][0] = Integer.toString(fila) + "   ";
                }

            }
        }

        /*Creamos tablero de la maquina (realmente genero un numero al azaar dependiendo del tamaño del tablero) los ifs es por si me sale en
        la posicion 0 que ocupan los numeros o me sale fuera de los limites, imagino que habra alguna forma mas facil de hacerlo.*/
        posicionBarco[0] = (int) (Math.random() * (tablero[0]+1));
        posicionBarco[1] = (int) (Math.random() * (tablero[1]+1));
        if (posicionBarco[0] == 0) {
            posicionBarco[0] = 1;
        } else if (posicionBarco[0] >= tablero[0]) {
            posicionBarco[0] = tablero[0];
        }

        if (posicionBarco[1] == 0) {
            posicionBarco[1] = 1;
        } else if (posicionBarco[1] >= tablero[1]) {
            posicionBarco[1] = tablero[1];
        }

        //Descomentar para ver la posicion del barco y poder probar el programa
        System.out.println(posicionBarco[0]);
        System.out.println(posicionBarco[1]);
         
        System.out.println("INICIO DEL JUEGO");
        //Bucle principal del programa, si ganamos o se nos acaban los movimientos se rompe
        while (ganado == false & movimientos <= numeroMovimientos) {
            //Bucle para dibujar el tablero en pantalla
            for (int fila = 0; fila < tableroJugador.length; fila++) {
                System.out.println();
                for (int columna = 0; columna < tableroJugador[1].length; columna++) {
                    System.out.print(tableroJugador[fila][columna]);
                    System.out.print(" ");
                }
            }
            //Dos espacios para dar formato
            System.out.println();
            System.out.println();
            //IF para cuando llevamos un movimiento que no lo ponga en plural
            if (movimientos == 1) {
                System.out.println("AGUA!!! Llevas " + movimientos + " movimiento realizado y te quedan " + (numeroMovimientos - movimientos) + " movimientos para finalizar el juego!!!");
            } else if (movimientos > 1) {
                System.out.println("AGUA!!! Llevas " + movimientos + " movimientos realizados y te quedan " + (numeroMovimientos - movimientos) + " movimientos para finalizar el juego!!!");
            }
            //Bucle do while para pedir otra vez las cordenadas si ya han sido introducidas
            do {
                /*Esto lo pongo para que el movimiento se quede dentro del rango y entre bien en el while, por lo demas es primero un try catch por si se ponen cosas raras
                y segundo es un while por si se ponen valores fuera de rango*/
                movimiento[0] = (tablero[0] + 1);
                while (movimiento[0] > tablero[0] | movimiento[0] <= 0) {
                    try {
                        System.out.println();
                        System.out.println("Introduce fila");
                        movimiento[0] = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Por favor introduce un numero del 1 al " + tablero[0]);
                    }
                }
                /*Esto lo pongo para que el movimiento se quede dentro del rango y entre bien en el while, por lo demas es primero un try catch por si se ponen cosas raras
                y segundo es un while por si se ponen valores fuera de rango*/
                movimiento[1] = (tablero[1] + 1);
                while (movimiento[1] > tablero[1] | movimiento[1] <= 0) {
                    try {
                        System.out.println("Introduce columna");
                        movimiento[1] = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Por favor introduce un numero del 1 al " + tablero[1]);
                    }
                }
                //Esto lo hago para en el caso que el movimiento ya esta realizado sacar un pequeño mensaje que alerte al jugador
                if (tableroJugador[movimiento[0]][movimiento[1]].equals(fichasTablero[1])) {
                    System.out.println();
                    System.out.println("Cordenas ya introducidas anteriormente, por favor inseterte unas nuevas cordenadas.");
                }
            } while (tableroJugador[movimiento[0]][movimiento[1]].equals(fichasTablero[1]));

            /*Comprueba si se ha acertado, si ha sido asi inserta todas las aguas en las casillas (menos los numeros de las tablas) y insterta el barco en la casilla correspondiente
            tambien cambia ganado a true, y si no se ha ganado simplemente se inserta en la casilla elegida el agua y se añade uno a los movimientos realizados por el jugador*/
            if (movimiento[0] == posicionBarco[0] && movimiento[1] == posicionBarco[1]) {
                for (int fila = 1; fila < tableroJugador.length; fila++) {
                    for (int columna = 1; columna < tableroJugador[1].length; columna++) {
                        tableroJugador[fila][columna] = fichasTablero[1];
                    }
                }
                tableroJugador[movimiento[0]][movimiento[1]] = fichasTablero[0];
                ganado = true;
            } else {
                tableroJugador[movimiento[0]][movimiento[1]] = fichasTablero[1];
            }
            movimientos++;
        }

        //Esto vuelve a imprimir el tablero, en caso de que hayas perdido veras donde estaba el barco
        tableroJugador[posicionBarco[0]][posicionBarco[1]] = fichasTablero[0];
        for (int fila = 0; fila < tableroJugador.length; fila++) {
            System.out.println();
            for (int columna = 0; columna < tableroJugador[1].length; columna++) {
                System.out.print(tableroJugador[fila][columna]);
                System.out.print(" ");
            }
        }
        //Saltos de linea para formatear
        System.out.println();
        System.out.println();

        //If para personalizar el mensaje en caso de que hayas ganado o no
        if (ganado == false) {
            System.out.println("No has encontrado el barco en: " + movimientos + " movimiento/s!, el barco estaba en la fila: " + posicionBarco[0] + " y en la columna: " + posicionBarco[1]);
        } else if (movimientos == 1) {
            System.out.println("Enhorabuena!!!, has encontrado el barco en " + movimientos + " movimiento, eres un crack!!");
        } else {
            System.out.println("Enhorabuena!!!, has encontrado el barco en " + movimientos + " movimientos!!");
        }
    }

}
