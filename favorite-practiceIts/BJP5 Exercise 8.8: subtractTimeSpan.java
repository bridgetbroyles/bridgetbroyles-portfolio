/*
Add the following method to the TimeSpan class:

public void subtract(TimeSpan span)
Subtracts the given amount of time from this time span. (You do not need to worry about the case of a negative result.)

Recall the TimeSpan code from this chapter:

public class TimeSpan {
    private int hours;
    private int minutes;
    
    public void add(int hours, int minutes) { ... }
    public int getHours() { ... }
    public int getMinutes() { ... }
    public String toString() { ... }
​
    // // your code goes here
    
}
*/
public void subtract(TimeSpan span) {
        int min1 = this.hours * 60 + this.minutes;
        int min2 = span.hours * 60 + span.minutes;
        int diff = min1 - min2;
    
        this.hours = diff / 60;
        this.minutes = diff % 60;
    }
