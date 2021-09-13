import Adapter.SpecialRequestToGeneralRequestAdapter;
import GeneralRequest.GeneralRequest;
import GeneralRequest.*;
import SpecialRequests.*;

public class Main {
    //We have SpecialRequest and GeneralRequest
    //Client needs GeneralRequest but only has SpecialRequest object.
    //So client uses SpecialRequestToGeneralRequest adapter to use SpecialRequest in place of GeneralRequest
    public static void main(String[] args) {
        SpecialRequest specialRequest = new HttpSpecialRequest();
        SpecialRequestToGeneralRequestAdapter adapter = new SpecialRequestToGeneralRequestAdapter(specialRequest);
        processGeneralRequest(adapter);
    }

    private static void processGeneralRequest(GeneralRequest generalRequest){
        generalRequest.sendRequest();
    }
}
