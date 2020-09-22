package handlers;

import request.Request;

import java.util.ArrayList;
import java.util.List;

/*
    This is the handler dispatcher, it is the main/starting handler
    user sends request to and it decides to which chain to pass the request.
 */
public class RequestHandlerDispatcher extends RequestHandler {
    private List<RequestHandler> listOfChains = new ArrayList<>();


    public RequestHandlerDispatcher(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if(listOfChains.isEmpty()){
            System.out.println("No Chains to handle request");
        }
        /*
            Pass request to handle to all of the chains present.
            Here could be a logic to filter out only some of the chains present.
         */
        listOfChains.forEach(e->e.handleRequest(request));
    }

    public void addChainToList(RequestHandler requestHandler){
        listOfChains.add(requestHandler);
    }
}
