/*
Write a method named evenNumbers that accepts a Scanner as a parameter reading input from a file containing a series of integers, and report various statistics about the integers. You may assume that there is at least one integer in the file. Report the total number of numbers, the sum of the numbers, the count of even numbers and the percent of even numbers. For example, if a Scannerinput on file numbers.txt contains the following text:

5 7 2 8 9 10 12 98 7 14 20 22
then the call evenNumbers(input); should produce the following output:

12 numbers, sum = 214
8 evens (66.67%)
*/

public static void evenNumbers(Scanner console){
    int count=0;
    int evens=0;
    int sum=0;
    while(console.hasNext()){
        count++;
        int x=console.nextInt();
        sum+=x;
        if(x%2==0)
            evens++;
       
    }
    System.out.println(count+ " numbers, sum = "+ sum);
    System.out.printf("%d evens (%.2f%%)", evens, (100.0*evens/count));
}
