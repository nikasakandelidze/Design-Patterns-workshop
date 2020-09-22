import handlers.AdminRequestHandler;
import handlers.BasicUserRequestHandler;
import handlers.LoggedInRequestHandler;
import handlers.RequestHandler;
import handlers.RequestHandlerDispatcher;
import request.Request;
import request.RequestType;

public class Main {
    public static void main(String[] args) {
        /*
            Initialise requests
         */
        Request request_admin = new Request(RequestType.ADMIN_REQUEST);
        Request request_basic = new Request(RequestType.BASIC_USER_REQUEST);
        Request request_loggedIn = new Request(RequestType.LOGGED_IN_USER_REQUEST);

        RequestHandler dispatcher = new RequestHandlerDispatcher(
                new AdminRequestHandler(new BasicUserRequestHandler(new LoggedInRequestHandler(null))));

    }
}
