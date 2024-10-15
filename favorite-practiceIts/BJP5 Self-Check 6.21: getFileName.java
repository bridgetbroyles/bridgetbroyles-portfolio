/*
  Write a method named getFileName that repeatedly prompts the user for a file name until the user types the name of a file that exists on the system. Once you get a good file name, return that file name as a String. Here is a sample dialogue from one call to your method, assuming that the file good.txt does exist and the others do not:

Type a file name: bad.txt
Type a file name: not_here.txt
Type a file name: good.txt
*/

public static String getFileName() {

    Scanner console = new Scanner(System.in);
    System.out.print("Type a file name: ");
    String name= console.next();
    File f=new File(name);

    
    while(!f.canRead()){
        System.out.print("Type a file name: ");
        name= console.next();
        f=new File(name);

    }
    
    return name;
    
}
