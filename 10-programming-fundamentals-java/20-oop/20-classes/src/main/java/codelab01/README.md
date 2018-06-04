# Time Exercise

- Write a definition for a class named Time which consists of 3 instance variables (state)
    - hour (int)
    - minute (int)
    - second (double)
- Pay attention to proper encapsulation!
    
- Time should have 3 constructors
    - One without any arguments which sets the instance variables to the following values:
        - hour to 13
        - minute to 30
        - seconds to 0.0   
    - One with 2 arguments, hour and minute, which should be assigned to the instance variables hour and minute
    - One with 3 arguments, hour, minute and second, which should be assigned to the instance variables hour, minute and second
    
- Time should override the toString method, 
if called, it should return the following String: "The time is hh:mm:ss.ss"

- Time should provide an equals method which takes a Object object as argument (which you'll have to convert to a Time object)
and returns a boolean (indicating if both Time objects are equal). 
A Time object is equal to another if their hour, minute and second values are the same.
(tip: do on search on overriding the equals method)

- Define a constant, TEA_TIME_HOUR, which you set to 16.

- Provide a getter method for hour and one for minute.

- Create a class method (highestHour) which takes two Time objects as arguments and returns the Time object 
with the highest hour.

- Create a TimeRunner class in which you create some Time objects and use all the methods and constructors you created.
Print the results, then run the TimeRunner and inspect the results. Does it all look like expected?

- If done, let someone evaluate your implementation.
    