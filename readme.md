Steps in multithreading programming

1. think in terms of tasks
2. create sepearate class for tasks
3. extend classes with Thread;
4. Implement run() in the class


Implementing using runnable

1. why 2 ways:
    1. in java we can extend only 1 thread and implement infinite 
    interfaces
       
Responsibilities :
1. create the thread(task);
2. start the thread(task);


In Production environment we dint use any of above methods We use following methods
we split the responsibilities into making tasks and maintaining running tasks

thats where executorService comes in