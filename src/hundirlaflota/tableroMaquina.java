
package hundirlaflota;


public class tableroMaquina {
    int[] b=new int[2];
    
    public tableroMaquina(String[][] a){
        b[0]=(int)(Math.random()*10);
        b[1]=(int)(Math.random()*10);
        
        if(b[0]==0){
          b[0]=1;  
        } else if(b[0]>5){
            b[0]=5;
        }
        
        if(b[1]==0){
            b[1]=1;
        } else if(b[1]>7){
            b[1]=7;
        }
        
    }
    
    
    public int[] GetPosicionBarco(){
        return b;
    }
    
    
}
