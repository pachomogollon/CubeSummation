package logic;

import persistence.Matrix;
import java.util.ArrayList;


public class Logic {

    Matrix matrix = null;

    public ArrayList<String> processOperations(int matrixSize, int operationsNumber, ArrayList<String> operations) {

        this.matrix = new Matrix();

        ArrayList<String> answers = new ArrayList<>();
        String[] operationValues = null;
        String instantiateClassName;
        String PackageName ="operations.";
        
        for (String operacion : operations) {
            operationValues = operacion.split(" ");
            instantiateClassName = operationValues[0];
            instantiateClassName = instantiateClassName.substring(0, 1).toUpperCase() + instantiateClassName.substring(1).toLowerCase();
            
            try {
                Object obj =  Class.forName(PackageName+instantiateClassName).newInstance();
                obj.getClass().getDeclaredMethod("buildObjectOperation",String[].class).invoke(obj, (Object) operationValues);
                answers.add((String) obj.getClass().getDeclaredMethod("executeOperation",Matrix.class).invoke(obj, this.matrix ) );
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return answers;
    }

}
