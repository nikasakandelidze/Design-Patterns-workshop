package request;

/*
    This entity represents the request user will send to chain of handlers.
 */
public  class Request {
    /*
        Each request has a request type(What was request sent for),
        specified by enums.
     */
    private final RequestType requestType;
    private boolean wasHandledFlag;

    public Request(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public boolean isWasHandledFlag() {
        return wasHandledFlag;
    }

    public void setWasHandledFlag(boolean wasHandledFlag) {
        this.wasHandledFlag = wasHandledFlag;
    }
}
