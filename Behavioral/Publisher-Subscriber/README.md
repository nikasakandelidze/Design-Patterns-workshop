## Publisher-Subscriber pattern
    Disclaimer: Rule number 1 of the Reactor club: don’t write your own Publisher.
    Even though the interface is simple, the set of rules about interactions between all these reactive streams interface is not. — Simon Baslé (Pivotal, Project Reactor).
   
 ## General 
    Reactive Streams is about asynchronous processing of stream, so there should be a Publisher and a Subscriber.
     The Publisher publishes the stream of data and the Subscriber consumes the data. 
     
     
![pubsub](pubsub.png)
