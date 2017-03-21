package ws;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseOperationCube {
    private JSONObject answer;

    public ResponseOperationCube(ArrayList<String> answers)  throws JSONException{
        
        this.answer = new JSONObject();
        for (int i = 1; i <= answers.size(); i++) {
            answer.put("operacion" + i, answers.get(i - 1));
        }
    }

    public JSONObject getAnswer() {
        return answer;
    }
}
