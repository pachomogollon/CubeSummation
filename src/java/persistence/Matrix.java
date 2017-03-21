package persistence;

import java.util.HashMap;

public class Matrix {
    
    private HashMap<String,Block> matrix = null;
    
    public Matrix(){
         this.matrix = new HashMap<>();
         
    }
    
    public void update(int coordinateX,int coordinateY,int coordinateZ ,int value){
    
        Block block = new Block(coordinateX,coordinateY,coordinateZ,value);
        
        this.matrix.put(String.valueOf(coordinateX)+String.valueOf(coordinateY)+String.valueOf(coordinateZ), block);
        
    }
    
    public int query(int initialCoordinateX,int initialCoordinateY,int initialCoordinateZ,int lastCoordinateX,int lastCoordinateY,int lastCoordinateZ){
        
        Block bloque ;
        int sum =0;
        for (int i = initialCoordinateX; i <= lastCoordinateX; i++) {
            
            for (int j = initialCoordinateY; j <= lastCoordinateY; j++) {
                
                for (int k = initialCoordinateZ; k <= lastCoordinateZ; k++) {
                    bloque = this.matrix.get(String.valueOf(i)+String.valueOf(j)+String.valueOf(k));
                    if(bloque!=null){
                        sum += bloque.getValue();
                    }
                    
                    
                }
                
            }
            
        }
        
        return sum;
    }
    
}
