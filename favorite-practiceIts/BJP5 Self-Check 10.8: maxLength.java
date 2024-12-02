/*
BJP5 Self-Check 10.8: maxLength
Language/Type: Java ArrayList Collections
Author:Marty Stepp (on 2019/09/19)

Write a method maxLength that takes an ArrayList of Strings as a parameter and that returns the length of the longest string in the list.
If your method is passed an empty list, it should return 0.

Type your solution here:
*/

public static int maxLength(ArrayList<String> arr){
    if(arr.size()==0)
        return 0;
    int length=arr.get(0).length();
    for(int i=0;i<arr.size();i++){
        if(arr.get(i).length()>length)
            length=arr.get(i).length();
    }
    return length;
}
