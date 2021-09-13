package request;

public enum RequestType {
    LOGGED_IN_USER_REQUEST,  //only logged in users should be able to see cart
    BASIC_USER_REQUEST,   //anyone can see homepage
    ADMIN_REQUEST  //only admin should be able to see all users
}
