import java.util.function.Consumer;

public class MessagingService {
    private String from;
    private String to;
    private String message;
    private MessagingService(){}
    public MessagingService from(String from){
        this.from = from;
        return this;
    }

    public MessagingService to(String to){
        this.to = to;
        return this;
    }

    public MessagingService message(String message){
        this.message = message;
        return this;
    }

    private void push(){
        System.out.printf("Pushing message to address: %s, %s, %s%n", this.from, this.to, this.message);
    }

    /*
         Enforcing client of this API to use one time sends without being able to create instance
         on their side and leave them as stateful objects for future reuses and further bugs.
     */
    public static void send(Consumer<MessagingService> sender){
        var service = new MessagingService();
        sender.accept(service);
        service.push();
    }
}
