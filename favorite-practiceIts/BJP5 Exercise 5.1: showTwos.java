/*
Write a method named showTwos that shows the factors of 2 in a given integer. For example, the following calls:

showTwos(7);
showTwos(18);
showTwos(68);
showTwos(120);
should produce this output:

7 = 7
18 = 2 * 9
68 = 2 * 2 * 17
120 = 2 * 2 * 2 * 15
*/

public static void showTwos(int num){
    if(num%2==1)
        System.out.print(num +" = "+ num);
    else{
        System.out.print(num +" = ");
        while(num%2==0){
            System.out.print("2 * ");
            num=num/2;
        }
        System.out.print(num);
    }
}
