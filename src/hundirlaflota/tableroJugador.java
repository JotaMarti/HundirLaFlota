
package hundirlaflota;


public class tableroJugador {
    
    int[] tableroSize;
    String[][] miTablero;
    int[] posicionBarco;
    Boolean ganado=false;
    
    
    public tableroJugador(int[] a){
        tableroSize=a;
        miTablero=new String[tableroSize[0]+1][tableroSize[1]+1];
        
        // Espacio en blanco en [0][0]
        miTablero[0][0]="      ";
        
        // Inserto los numeros de las columnas
        for(int j=1;j<miTablero[1].length;j++){
            miTablero[0][j]=Integer.toString(j)+"      ";
        } 
        
        // Inserto los numeros de las filas
        for(int i=1;i<miTablero.length;i++){
            miTablero[i][0]=Integer.toString(i);  
        }
        
        // Llena el tablero
        for(int i=1;i<miTablero.length;i++){
           for(int j=1;j<miTablero[1].length;j++){
               miTablero[i][j]="[     ]";
           } 
        }
        
        
    }
    
    public void dibujaTablero(){
        for(int i=0;i<miTablero.length;i++){
           System.out.println();
           for(int j=0;j<miTablero[1].length;j++){
               System.out.print(miTablero[i][j]);
               System.out.print(" ");
           }
        
       }
    }
    
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
    
    public void setPosicionBarco(int[] b){
        posicionBarco=b;
    }
    
    public boolean GetGanado(){
        return ganado;
    }
    
    
    public String[][] GetArray(){
        return this.miTablero;
    }
    
    
    
    
    
    
    
    
    
    
    
}
