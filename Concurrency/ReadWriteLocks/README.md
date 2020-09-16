## ReadWrite Locks
    Read Write problem is very common one in practice.
    Imagine you have several Reading threads, and several writing threads.
    Your code must satisfy next conditions: 
    
                1) Parallel reads can occur, Reader threads can read parallely.
                
                2) Whenever thread writes, no reads or other writes must occur
                
                3) Since in these kinds of problems, most of the time, readers ournumber writers
                    we want writers not to be bullied, so whenever a writer makes a request that he wants to write
                    all subsequent "queued" reads must backup and let writer to it's job.  