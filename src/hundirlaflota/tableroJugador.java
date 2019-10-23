
package hundirlaflota;


public class tableroJugador {
    
    private final int[] tableroSize;
    private int[] posicionBarco;
   
    
    //Construyo el tablero
    public tableroJugador(int[] a){
        //Booleano para controlar si el jugador ha ganano
        
        //Variable con el tamaño del tablero que le hemos pasado al constructor
        
        //Construyo el tablero con las dimensiones pasadas al constructor
        
        
        // Espacio en blanco en [0][0]
        
        
        
        
        
    }
    //Metodo para dibujar el tablero
    public void dibujaTablero(){
        for(int i=0;i<miTablero.length;i++){
           System.out.println();
           for(int j=0;j<miTablero[1].length;j++){
               System.out.print(miTablero[i][j]);
               System.out.print(" ");
           }
        }
    }
    //Metodo para dibujar el tablero cuando pierdes
    public void dibujaTableroPerdedor(){
        miTablero[posicionBarco[0]][posicionBarco[1]]="[BARCO]";
        for(int i=0;i<miTablero.length;i++){
           System.out.println();
           for(int j=0;j<miTablero[1].length;j++){
               System.out.print(miTablero[i][j]);
               System.out.print(" ");
           }
        }
    }
    //Metodo para realizar los movimientos, recibe un array con los movimientos
    public void realizaMovimiento(int[] a){
        
        if(a[0]==posicionBarco[0]&& a[1]==posicionBarco[1]){
            for(int i=1;i<miTablero.length;i++){
                for(int j=1;j<miTablero[1].length;j++){
                    miTablero[i][j]="[AGUA ]";
                } 
            }
            miTablero[a[0]][a[1]]="[BARCO]";
            ganado=true;
        } else {
            miTablero[a[0]][a[1]]="[AGUA ]";
        }
        
        
    }
    
    //Metodo que recibe la posicion del barco del tablero de la maaquina y lo setea en esta clase
    public void setPosicionBarco(int[] b){
        posicionBarco=b;
    }
    //Metodo para devolver el booleano sobre si el jugador ha ganado o no
    public boolean GetGanado(){
        return ganado;
    }
    
    //Metodo para enviar el array de esta clase, lo uso para pasarselo al tablero de la maquina
    public String[][] GetArray(){
        return miTablero;
    }
    
    
    
    
    
    
    
    
    
    
    
}
