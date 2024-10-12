/*
Write a method named diceSum that prompts the user for a desired sum, then repeatedly rolls two six-sided dice until their sum is the desired sum. Here is the expected dialogue with the user:

Desired dice sum: 9
4 and 3 = 7
3 and 5 = 8
5 and 6 = 11
5 and 6 = 11
1 and 5 = 6
6 and 3 = 9
(Because this problem uses random numbers, our test cases check only the general format of your output. You must still examine the output yourself to make sure the answer is correct.)
*/
​
public static void diceSum(){
    Scanner console= new Scanner(System.in);
    System.out.print("Desired dice sum: ");
    int sum = console.nextInt();
    int num1=0;
    int num2=0;
    while(num1+num2!=sum){
        
    num1 = (int)(Math.random()*6+1);
    num2 = (int)(Math.random()*6+1);
        System.out.println(num1 +" and "+ num2 + " = " + (num1+num2));
    }
}
