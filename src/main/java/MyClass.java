public class MyClass {

    public static void main(String[] args) {


  String ssn = "k23456789";

  boolean s = ssn.replaceAll("[^0-9]","").length()==9;

        System.out.println(s);






    }
}
