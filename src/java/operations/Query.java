package operations;

import persistence.Matrix;

public class Query extends Operation{
    
    private int initialCoordinateX;
    private int initialCoordinateY;
    private int initialCoordinateZ;
    private int lastCoordinateX;
    private int lastCoordinateY;
    private int lastCoordinateZ;
    
    @Override
    public void buildObjectOperation(String[] operationValues) {
        
            this.initialCoordinateX = Integer.parseInt(operationValues[1]);
            this.initialCoordinateY = Integer.parseInt(operationValues[2]);
            this.initialCoordinateZ = Integer.parseInt(operationValues[3]);
            this.lastCoordinateX = Integer.parseInt(operationValues[4]);
            this.lastCoordinateY = Integer.parseInt(operationValues[5]);
            this.lastCoordinateZ = Integer.parseInt(operationValues[6]);
            
    }

    @Override
    public String executeOperation(Matrix matrix) {
        
        int sum = matrix.query(this.initialCoordinateX,
                this.initialCoordinateY,
                this.initialCoordinateZ, 
                this.lastCoordinateX, 
                this.lastCoordinateY, 
                this.lastCoordinateZ
        );
        
        return String.valueOf(sum);
        
    }
    
}
