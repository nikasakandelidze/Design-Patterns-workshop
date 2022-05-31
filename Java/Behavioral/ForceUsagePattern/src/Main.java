public class Main {
    public static void main(String[] args) {
        /*
            The whole idea of this pattern is that Messaging service constrains the usage
            of class. The only possible way for the client of the Messaging Service to actually send
            a message is to use send() method which uses consumer of one time instance of MessagingService
         */
        MessagingService.send(service->{
            service.from("nika")
                    .to("dato")
                    .message("Give me 10 laris brudha");
        });
    }
}
