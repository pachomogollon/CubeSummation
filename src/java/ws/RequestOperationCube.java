package ws;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestOperationCube {
private JSONObject operationsSubmittedJson;
private int matrixSize;
private int operationsNumber;
private ArrayList<String> operations;

    public RequestOperationCube(String operationsSubmitted) throws JSONException {
        
        this.operationsSubmittedJson = new JSONObject(operationsSubmitted);
        this.matrixSize = Integer.parseInt((String) this.operationsSubmittedJson.get("tamanoMatriz"));
        this.operationsNumber = Integer.parseInt((String) this.operationsSubmittedJson.get("numeroOperaciones"));
        
        this.operations = new ArrayList<>();
        
        for (int i = 1; i <= this.operationsNumber; i++) {
            this.operations.add((String) this.operationsSubmittedJson.get("operacion" + i));
        }
    }

    public JSONObject getOperationsSubmittedJson() {
        return operationsSubmittedJson;
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public int getOperationsNumber() {
        return operationsNumber;
    }

    public ArrayList<String> getOperations() {
        return operations;
    }
}
