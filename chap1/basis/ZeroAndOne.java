package algorithms.chap1.basis;

import edu.princeton.cs.algs4.*;

public class ZeroAndOne
{
	public static void main(String[] args)
	{
		double x,y;
		StdOut.println("Type two doubles:");
		x=StdIn.readDouble();
		y=StdIn.readDouble();
		/*System.out.println('b');
		System.out.println('b'+'c');
		System.out.println('a'+4);*/
		StdOut.println(Excute(x,y));
	}
	
	static boolean Excute(double x,double y)
	{
		if(x>0&&x<1&&y>0&&y<1) return true;
		else return false;
	}
}

