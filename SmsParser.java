/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		 String sms = "You have sent UGX10,000 to 08970000.\n" +
            "Reason:j.\n" +
            "Your balance is UGX120,000.\n" +
            "Thank you for using KKL MobileMoney.";

    /*String rec = "You have received UGX100,000 from 09006700. Reason:J.\n" +
            "Your balance is UGX170,000.";
    String air = "Airtime payment made for UGX5,000 to KKL(0909xxxx).\n" +
            "Your Balance is UGX10,000.\n" +
            "Thank you for using KKL MobileMoney.";
    */
    Map<String, String> data = parseSms(sms);
    
    for (Map.Entry<String, String> entry : data.entrySet()) {
    String key = entry.getKey().toString();
    String value = entry.getValue().toString();
    System.out.println("key, " + key + " value " + value);
}
    
    System.out.print("Hello there!!!!");
	}
	
	private static Map<String, String> parseSms(String s){
	    Map<String, String> ret = new HashMap<String, String>();
	    
	     s = s.replace("\n", "");
	     System.out.println("After replace :: "+s);
	    
    StringTokenizer t = new StringTokenizer(s, ".");
    while (t.hasMoreTokens()){
        String b = t.nextToken().trim();
         System.out.println("Tokens :: "+b);
        if (b.startsWith("You have sent") ||  (b.startsWith("Airtime") || (b.startsWith("You have received")))){
            String type = getType(b);
            System.out.println("Type :: "+type);
            String parsed = parseAmount(b);
            System.out.println("Amount :: "+parsed);
            String number = parseNumber(b);
            System.out.println("number :: "+number);
            ret.put("amount", parsed);
            ret.put("number", number);
            ret.put("type", type);
        }else if(b.startsWith("Your")){//balance
            String parsed = parseAmount(b);
            ret.put("balance", parsed);
        }else if (b.startsWith("Reason")){
            ret.put("reason", b.toString());
        }
    }
	    
	    return ret;
	    
	}
	
	private static String getType(String s){
    if (s.startsWith("You have sent"))//Use your constants
        return "Payment";
    else if (s.startsWith("Airtime"))
        return "Air time";
    else if (s.startsWith("You have received"))
        return "Deposit";

    return "Unknown";
}

private static String parseNumber(String s){
    String numberFragment = s.substring(s.lastIndexOf(' '), s.length());//extract number
    return numberFragment;
}

private static String parseAmount(String s){
    char[] arr = s.toCharArray();
    StringBuffer sb = new StringBuffer();
    boolean parsingNumber = false;
    for (char c: arr){
        System.out.println("char :: "+c+" bool"+parsingNumber);
        if (Character.isDigit(c))
            parsingNumber = true;
        if (Character.isLetter(c)  && c != ',' )
            parsingNumber = false;
        if (parsingNumber && c == ' ')//we have reached end of digit series
            break; //done
        if (parsingNumber)
            sb.append(c);
    }

    return sb.toString();
}

}


