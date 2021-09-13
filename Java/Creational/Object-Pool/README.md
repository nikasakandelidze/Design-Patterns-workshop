## Object Pool Design Pattern
    When creation of arbitrary object is very expensive instead of creating instances on evey use case
    initialise Object Pool of this objects and if instance is available take it from pool if not {some logic, maybe wait or maybe creation}

## Pros
       Common solution to whenever you want to see object pool statistics, how many objects are in use and how many are available
    
## Common use cases
    ExecutorService - in java is a pool of Threads since large amount of thread creation is an expensive operation
    JDBC connection pools - in java is a pool of JDBC connection to database, these connections are expensive to create 
    
