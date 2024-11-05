/*
Write a method called countInRange that accepts an array of integers, a minimum value, and a maximum value as parameters and returns the count of how many elements from the array fall between the minimum and maximum (inclusive).

For example, in the array {14, 1, 22, 17, 36, 7, -43, 5}, there are four elements whose values fall between 4 and 17.

*/

public static int countInRange(int [] arr, int min, int max){
    int count=0;
    for(int i=0; i<arr.length; i++){
     if(arr[i]<=max&&arr[i]>=min)
         count++;
    }
    return count;
}
