import java.util.Scanner;
import java.util.regex.*;
public class SafeInput {
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); //  prmopt for input
            retString = pipe.nextLine();//read input
        }while(retString.length() == 0);//keep prompting user till correct
        return retString;//return input
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt;
        while(true)
        {
            try
            {
                System.out.print("\n" +prompt + ": "); // //input
                retInt = Integer.parseInt(pipe.nextLine());//read input
                break;
            }
            catch (Exception e) {//ignore exception keep loopng
            }
        }
        return retInt;///return as integer
    }
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble;//return as double
        while(true)
        {
            try
            {
                System.out.print("\n" +prompt + ": "); // show prompt add space
                retDouble = Double.parseDouble(pipe.nextLine());
                break;
            }
            catch (Exception e) {

            }
        }
        return retDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt;
        do
        {
            retInt=getInt(pipe, prompt);
        }while(retInt<low || retInt>high);
        return retInt;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String str;
        while(true)
        {
            str=getNonZeroLenString(pipe, prompt);
            if(str.equalsIgnoreCase("y")||str.equalsIgnoreCase("Y"))
                break;
        }
        return str.equalsIgnoreCase("y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String str="";
// Compile the ReGex
        Pattern p = Pattern.compile(regEx);//complie regular experssion patter
        Matcher m;
        do
        {
            str=getNonZeroLenString(pipe, prompt);//get non empty string input
            m= p.matcher(str);//create matcher object from pattern
        }while(!m.matches());
        return str;
    }
    {
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = 0;
        do {
            System.out.print("\n" + prompt + ": ");
            retDouble = pipe.nextDouble();//double
        } while (retDouble <= low || retDouble >= high);//keep prompting until correct
        return retDouble;//return
    }
    public static void prettyHeader(String msg) {
        int limit = 60;
        int msgLen = msg.length();
        int diff = 60 - msgLen;
        int mid = diff / 2;
        char[] msgArr = msg.toCharArray();
        while (limit > 0) {
            for (int i = 0; i < mid; i++) {
                System.out.print("*");
                limit--;
            }
            for (char c : msgArr) {
                System.out.print(c);
                limit--;
            }
            while (limit > 0) {
                System.out.print("*");
                limit--;
            }
        }
    }

    public boolean getYNComfirm(Scanner scanner, String s) {
        return false;
    }
}