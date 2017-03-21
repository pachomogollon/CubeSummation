package operations;

import persistence.Matrix;


public abstract class Operation {
    
    public abstract void buildObjectOperation(String[] operationValues);
    
    public abstract String executeOperation(Matrix matrix);

}
