# time-loop-cave

## Software engeneering Java course project

Used abstract classes (GameState, GameObject) and interfaces (Movable - I wish this is enough for the task).  
Also used a Collection (LinkedList) in Level1 and some enhanced for loops.

FOR THE THIRD TASK:
Lambda expressions are used in directing the bullet and iterating through game objects.
Exceptions are used in Level1 map reading from file.

FOR THE FOURTH TASK:  
Volatile keyword is used were the programs' threads may use the same variable and should know about the change ASAP.  
Those places are: in GameObject coordinate fields x and y, in StateHandler field running.  
Threads, wait, notify, synchronization, monitor were already used before, so I guess it already counts as a finished task.

HOW TO PLAY:  
Use arrows to move the player
Press space to shoot
