package algorithms.chap1.basis;

import edu.princeton.cs.algs4.*;

/**
 * Compare three integer,print equal if all of them is equal, else print not equal.
 * @version 1.0 2017-7-15
 * @author SHAN Haodong
 */
 
 
 public class TribleCompare
 {
 	public static void main(String[] args)
 	{
 		int a,b,c;
 		a=StdIn.readInt();
 		b=StdIn.readInt();
 		c=StdIn.readInt();
 		StdOut.println(Compare(a,b,c));
 	}
 	
 	static String Compare(int a,int b,int c)
 	{
 		if(a==b)
 		{
 			if(b==c) return("Equal!");
 			else return ("Not equal!");
 		}else return ("Not equal!");
 	}
}