package ws;

import logic.Logic;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;


@Path("CubeResource")
public class CubeResource {

    @Context
    private UriInfo context;

    public CubeResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)

    public String processOperations(String operationsSubmitted) throws JSONException {

        RequestOperationCube requestOperationCube = new RequestOperationCube(operationsSubmitted);
        
        Logic logic = new Logic();
        ArrayList<String> answers = logic.processOperations(requestOperationCube.getMatrixSize(), 
                                                                  requestOperationCube.getOperationsNumber()
                                                                  , requestOperationCube.getOperations());
        
        ResponseOperationCube responseOperationCube = new ResponseOperationCube(answers);
        return responseOperationCube.getAnswer().toString();

    }
    
}
