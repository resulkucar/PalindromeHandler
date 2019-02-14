import java.util.*;
import java.lang.*;

public class TextHandler {

    public static void main(String[] args) {

        System.out.println("Please enter any text:");
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        String text = in.nextLine();
        while (true)
        {
            System.out.println("\n-----------------------");
            System.out.println("1. Is Palindrome");
            System.out.println("2. Find all palindromes");
            System.out.println("3. Search a text");
            System.out.println("4. Remove a text");
            System.out.println("5. Add a text");
            System.out.println("6. Reverse the text");
            System.out.println("7. Reverse each word");
            System.out.println("8. Print the text");
            System.out.println("-----------------------");
            System.out.println("9. Change the input text");
            System.out.println("10. Quit the program");
            System.out.println("\nPlease enter your choice number");
            int choice = in.nextInt();

            if (choice == 1) {
                boolean a = palindrome(text);
                if (a == true) {
                    System.out.println(text + " is a palindrome");
                }
                else{
                    System.out.println(text + " is NOT a palindrome");
                }
            }
            if (choice == 2) {
                System.out.print("Result: ");
                String pal = findAllPalindromes(text);
                pal = pal.replaceAll(", $", "");
                System.out.println(pal);
            }
            if (choice == 3)
            {
                System.out.println("What would you like to search? ");
                String search = in.next();
                System.out.print("' "+search+" ' found at locations: ");
                String completedSearch =searchText(text,search);
                completedSearch = completedSearch.replaceAll(", $", "");
                System.out.print( completedSearch );
            }
            if (choice == 4)
            {
                System.out.print("What would you like to remove? ");
                String remove = in.next();
                String removed = removeText(text,remove);
                removed= removed.replaceAll(", $", "");
                System.out.print("Result: " + removed);
            }
            if (choice == 5)
            {
                System.out.println("What would you like to add?");
                String value = in2.nextLine();
                System.out.println("Where would you like to add "+value+" ?");
                int index = in.nextInt();
                String ans = addText(index, value, text);
                System.out.println("Result: " + ans);

            }
            if(choice == 6)
            {
                System.out.print("Result: " );
                reverseText(text);
            }
            if(choice == 7)
            {
                reverseEachWord(text);
            }
            if(choice == 8)
            {
                printText(text);
            }
            if(choice == 9)
            {
                System.out.println("Please enter your new text:");
                text = in2.nextLine();
                System.out.println("Your text was updated!");

            }
            if(choice == 10){
                System.out.println("*******************************************\n" +
                        "\t        BYE BYE!\n" +
                        "*******************************************");
                System.exit(0);

            }
        }
    }
    public static boolean palindrome( String x)
    {
        boolean c = true;
        int a = 0;
        int b = x.length() - 1;
        while(b > a){
            if(x.charAt(b) != x.charAt(a)){
                c = false;
                break;
            }else{
                a++;
                b--;
            }
        }
        return c;
    }

    public static String findAllPalindromes(String x) {

        if(x==null || x.length() <2){
            return null;
        }
        boolean t = false;
        String z= " ";
        for(int i=0;i<x.length()-1;i++){
            for(int b=i+1;b<x.length();b++) {
                String pal = x.substring(i, b + 1) + ", ";
                if (palindrome(x.substring(i, b + 1))) {
                    z= z + pal;
                    t = true;
                }
            }
        }
        if(t==true) {
            return z;
        }else
            z= "No palindromes found";
        return z;
    }

    public static String searchText ( String x, String y) {

        int input = x.length();
        int search = y.length();
        boolean found = false;
        String z=" ";
        for (int i = 0; i < input; i++) {
            if (i + search < input) {
                if (x.substring(i, i + search).equalsIgnoreCase(y)) {
                    String a =i + ", ";
                    z= z + a;
                    found = true;
                }
            }
        }
        if(found == true)
        {
            return z;
        }else {
            z = "Null \n Search term not found";
            return z;
        }
    }
    public static String removeText (String x, String y)
    {
        int input = x.length();
        int search = y.length();
        boolean found = false;
        String removed = " ";
        for (int i = 0; i < input; i++) {
            if (i + search < input) {
                if (x.substring(i, i + search).equalsIgnoreCase(y)) {
                    removed= x.replace(y,"");
                    found = true;
                }
            }
        }
        if(found == true)
        {
            return removed;
        }else{
            removed = y+" was not found";
            return removed;
        }
    }
    public static String addText(int index,String value, String x)
    {
        String a = x.substring(0,index);
        String b = x.substring(index, x.length());
        String c = a + value + " "+ b;
        return c;

    }
    public static void reverseText (String x)
    {
        String rev = "";
        for(int i = x.length()-1;i>=0;i--)
        {
            rev=rev + x.charAt(i);
        }
        System.out.println(rev);
    }
    public static void reverseEachWord(String x)
    {
        String[] text = x.split(" ");
        String revText = "";
        for(int i=0;i<text.length; i++)
        {
            String eachWord = text[i];
            String reversedWords = "";
            for(int a = eachWord.length()-1;a>=0;a--)
            {
                reversedWords = reversedWords + eachWord.charAt(a);
            }
            revText= revText + reversedWords+" ";
        }
        printText(revText);
    }
    public static void printText(String x)
    {
        System.out.println(x);
    }
}
