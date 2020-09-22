package handlers;

import request.Request;
import request.RequestType;

/*
    This handler will handle only requests with request type  ADMIN_REQUEST
 */
public class AdminRequestHandler extends RequestHandler {

    public AdminRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.ADMIN_REQUEST) {
            /*
                Set request was handled flag so that later no more handlers will interrupt with it
             */
            request.setWasHandledFlag(true);
            System.out.println("Processing Admin request");
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
