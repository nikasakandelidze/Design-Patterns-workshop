package handlers;

import request.Request;
import request.RequestType;

/*
    This handler will handle only requests with request type  BASIC_USER_REQUEST
 */
public class BasicUserRequestHandler extends RequestHandler {
    public BasicUserRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.BASIC_USER_REQUEST) {
            /*
                Set request was handled flag so that later no more handlers will interrupt with it
             */
            request.setWasHandledFlag(true);
            System.out.println("Processing basic user's request");
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
