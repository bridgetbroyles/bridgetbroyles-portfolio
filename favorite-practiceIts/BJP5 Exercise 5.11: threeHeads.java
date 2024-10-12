/*
Write a method named threeHeads that repeatedly flips a coin until three heads in a row are seen. You should use a Random object to give an equal chance to a head or a tail appearing. Each time the coin is flipped, what is seen is displayed (H for heads, T for tails). When 3 heads in a row are flipped a congratulatory message is printed. Here are possible outputs of two calls to threeHeads:

T T T H T H H H
Three heads in a row!
(Because this problem uses random numbers, our test cases check only the general format of your output. You must still examine the output yourself to make sure the answer is correct.)

*/

public static void threeHeads(){
    Random rand=new Random();
    boolean threerow=false;
​
    int numH=0;
    while(!threerow){
    boolean coin= rand.nextBoolean();
    
    if(coin){
        System.out.print("T ");
        numH=0;
    }
    else{
        System.out.print("H ");
        numH++;
 
    }
    if(numH>=3)
        threerow=true;
    }
    System.out.println();
    System.out.print("Three heads in a row!");
}
 
4
 Indent
 Sound F/X
 Highlighting
