/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
String s = "Dear Customer, you have made a purchase for Rs.25.00 on 10-Oct-2016 11:19:58 using ICICI BANK MULTIWALLET PREPAID Card XX2447 at V GOVINDA RAJU onLINE. Available balance is Rs.1,445.00.";
        StringTokenizer t = new StringTokenizer(s, "on");    

String Shop = s.substring(s.indexOf(" at")+4, s.indexOf("Avail")-1);//extract number
   System.out.println("Shop :: "+Shop); 

 while (t.hasMoreTokens()){
        String b = t.nextToken().trim();
        System.out.println("Tokens :: "+b);
        if(b.contains("Rs"))
        {
           System.out.println("Condition :: "+b); 
            
        }
        else if(b.contains("usi"))
        {
            System.out.println("Condition 2:: "+b); 
        }
        else
        ;
 }

	}
}
