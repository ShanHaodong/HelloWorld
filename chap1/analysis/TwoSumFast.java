package algorithms.chap1.analysis;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;
/*
 *@version 1.0 2017-8-8
 *@author SHAN Haodong
 *@class 1.4
 *@use java analysis/TwoSumFast 1000000
 */
 
public class TwoSumFast
{
	public static int count(int[]a)
	{
		int N=a.length;
		int cnt=0;
		Arrays.sort(a);
		for(int i=0;i<N;i++)
		{
			if(BinarySearch.rank(-a[i],a)>i) cnt++;
		}
		return cnt;
	}
	public static void main(String[] args)
	{
		int N=Integer.parseInt(args[0]);
		int[] a=new int[N];
		for(int i=0;i<N;i++)
		{
			a[i]=StdRandom.uniform(-1000000,1000000);
		}
		Stopwatch timer=new Stopwatch();
		int cnt=TwoSumFast.count(a);
		double time=timer.elapsedTime();
		StdOut.println(cnt+" triples "+time+" seconds");
	}
}