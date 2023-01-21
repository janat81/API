package get_requests;

import java.util.Scanner;

public class MyClass {

    public static void main(String[] args) {

       String r = "I like to study Java, learn Java, earn money, Java is easy";

       int java = r.lastIndexOf("Java");

        System.out.println(java);

        int unique = r.indexOf("Java");

        System.out.println(unique);

        if(r.indexOf("Java")==r.lastIndexOf("Java")){
            System.out.println("It is unique");

        }else{
            System.out.println("Not unique");
        }
          String t = r.indexOf("Java")==r.lastIndexOf("Java")? "Unique":"Not unique";

        System.out.println(t);
        }
    }

