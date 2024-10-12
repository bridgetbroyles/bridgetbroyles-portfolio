/*
Write a method called randomLines that prints between 5 and 10 random strings of letters (between "a" and "z"), one per line. Each string should have random length of up to 80 characters.

rlcuhubm
ilons
ahidbxonunonheuxudxrcgdp
xmkmkmmmmwmwqjbaeeeerceheelciheihcreidercdeehiuhhhn
hdcrphdidcrydxgtkdhoendgcidgxfidgfufdgfuuuuuu
(Because this problem uses random numbers, our test cases check only the general format of your output. You must still examine the output yourself to make sure the answer is correct.)

*/

public static void randomLines() {
    int a = (int)(Math.random() * 25 + 97); 
    int rows = (int)(Math.random() * 5 + 5); 
    int eighty = (int)(Math.random() * 81);
    
   for(int j=0; j<=rows; j++){
    for (int i = 0; i <= eighty; i++) {
        System.out.print((char) a);
        a = (int)(Math.random() * 25 + 97);
        eighty = (int)(Math.random() * 81);
    }
        System.out.println(); 
   }
  
}
