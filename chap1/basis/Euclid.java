package algorithms.chap1.basis;
import java.util.*;
import edu.princeton.cs.algs4.*;

/**
 * 展示欧几里得算法求两个随机整数的最大公约数
 * @version 1.0 2017-7-
 * @author SHAN Haodong
 */
 
public class Euclid
{
	public static void main(String[] args)
	{
		/**
		 * @param a 100以内的一个随机整数
		 * @param b 100以内的一个随机整数
		 */
		 for(int i=0;i<10;i++)
		 {
			int a=new Random().nextInt(100);
			int b=new Random().nextInt(100);
			System.out.println(a+" 和 "+b+" 的最大公约数为："+gcd(a,b));
		}
			StdDraw.setXscale(0,10000);
			StdDraw.setYscale(0,100);
		for(int j=0;j<10000;j++)
		{
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(j,Math.sqrt(j));
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.point(j,StdRandom.uniform(0,100));
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.point(j,j*1.0/100);
		}
	}
	static int gcd(int p,int q)
	{
		if(q==0) return p;
		return gcd(q,p%q);
	}
}
