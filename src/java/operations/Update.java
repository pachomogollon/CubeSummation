
package operations;

import persistence.Matrix;

public class Update extends Operation {

    private int coordinateX;
    private int coordinateY;
    private int coordinateZ;
    private int value;

    @Override
    public void buildObjectOperation(String[] operationValues) {

        this.coordinateX = Integer.parseInt(operationValues[1]);
        this.coordinateY = Integer.parseInt(operationValues[2]);
        this.coordinateZ = Integer.parseInt(operationValues[3]);
        this.value = Integer.parseInt(operationValues[4]);
        
    }

    @Override
    public String executeOperation(Matrix matrix) {
                
        matrix.update(this.coordinateX, this.coordinateY, this.coordinateZ, this.value);
        
        return "update";
    }

}
