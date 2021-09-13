package handlers;

import request.Request;

/*
    This is the base class of request handlers.
 */
public abstract class RequestHandler {
    /*
        Since it should be a chain of handlers,
        each handler has pointer to another/next handler in chain.
     */
    protected RequestHandler nextHandler;


    public RequestHandler(RequestHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    /*
        Abstract handleRequest method, each specific type of RequestHandler
        should implement concrete handler behaviour.
     */
    public abstract void handleRequest(Request request);

}
