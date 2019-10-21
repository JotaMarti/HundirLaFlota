
package hundirlaflota;


public class tableroJugador {
    
    int[] tableroSize;
    String[][] miTablero;
    int movimientos=0;
    
    public tableroJugador(int[] a){
        tableroSize=a;
        miTablero=new String[tableroSize[0]+1][tableroSize[1]+1];
        
        miTablero[0][0]="      ";
        
        
        for(int j=1;j<miTablero[1].length;j++){
            miTablero[0][j]=Integer.toString(j)+"      ";
        } 
        
        
        for(int i=1;i<miTablero.length;i++){
           for(int j=0;j<miTablero[1].length;j++){
               miTablero[i][0]=Integer.toString(i);
           } 
        }
        
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
        miTablero[a[0]][a[1]]="[AGUA ]";
        movimientos++;
    }
    
    
    
    public String[][] GetArray(){
        return this.miTablero;
    }
    
    
    
    
    
    
    
    
    
    
    
}
