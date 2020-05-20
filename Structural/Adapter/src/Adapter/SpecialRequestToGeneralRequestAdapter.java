package Adapter;

import GeneralRequest.GeneralRequest;
import SpecialRequests.SpecialRequest;

//Adapts Special request to GeneralRequest
public class SpecialRequestToGeneralRequestAdapter implements GeneralRequest {
    private SpecialRequest specialRequest;

    public SpecialRequestToGeneralRequestAdapter(SpecialRequest specialRequest){
        this.specialRequest = specialRequest;
    }
    @Override
    public void sendRequest() {
        specialRequest.sendSpecialRequest();
    }
}
