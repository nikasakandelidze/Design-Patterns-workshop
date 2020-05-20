package SpecialRequests;

import SpecialRequests.SpecialRequest;

public class HttpSpecialRequest implements SpecialRequest {
    @Override
    public void sendSpecialRequest() {
        System.out.println("This is SpecialHttpRequest");
    }
}
