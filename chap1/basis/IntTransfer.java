package algorithms.chap1.basis;

import edu.princeton.cs.algs4.*;

/**
 * Transfer the int into binary format and string
 * @version 1.0 2017-7-15
 * @author SHAN Haodong
 */
public class IntTransfer
{
	static int tem;
	public static void main(String[] args)
	{
		int a;
		StdOut.println("Type a int:");
		a=StdIn.readInt();
		StdOut.println(IntTransferBinary(a));
	}
	static String IntTransferBinary(int N)
	{
		String s="";
		for(int n=N;n>0;n/=2)
		{
			s=(n%2)+s;
		}
		return s;
	}
}
	
		