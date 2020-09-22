package handlers;

import request.Request;
import request.RequestType;

/*
    This handler will handle only requests with request type LOGGED_IN_USER_REQUEST
 */
public class LoggedInRequestHandler extends RequestHandler {

    public LoggedInRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.LOGGED_IN_USER_REQUEST) {
            /*
                Set request was handled flag so that later no more handlers will interrupt with it
             */
            request.setWasHandledFlag(true);
            System.out.println("Processing logged in user's request");
        } else {
            /*
                Delegate handling request
             */
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}
