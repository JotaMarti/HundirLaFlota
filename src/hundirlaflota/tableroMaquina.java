
package hundirlaflota;


public class tableroMaquina {
    int[] b=new int[2];
    
    public tableroMaquina(int[] a){
        b[0]=(int)(Math.random()*a[0]);
        b[1]=(int)(Math.random()*a[1]);
        
        if(b[0]==0){
          b[0]=1;  
        } else if(b[0]>a[0]){
            b[0]=a[0];
        }
        
        if(b[1]==0){
            b[1]=1;
        } else if(b[1]>a[1]){
            b[1]=a[1];
        }
        
    }
    
    
    public int[] GetPosicionBarco(){
        return b;
    }
    
    
}
