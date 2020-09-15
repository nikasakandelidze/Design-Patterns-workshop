## Producer Consumer Pattern
    One of the most popular design patterns involving concurrency
    
## General:
    Two seperate thead groups: 1)Consumers 2)Producer cooperate/communicate
    indirectly using third player, which is usually a blocking collection.
    
    Producer: Fills collection in a seperate thread, if collection is full producer is blocked
              till the collection becomes a bit empty.
    
    Consumer: Takes from colelction in a seperate thread, if colelction is empty consumer is blocked
              till someone doesn't put element in the collection.