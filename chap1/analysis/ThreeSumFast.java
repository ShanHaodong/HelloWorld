package algorithms.chap1.analysis;

import edu.princeton.cs.algs4.*;
import java.util.Arrays;
/*
 *@author SHAN Haodong
 *@version 1.0 2017-8-9
 *@
 */
public class ThreeSumFast
{
	public static void main(String[] args)
	{
		
	}
	public static int count(int[] a)
	{
		int N=a.length;
		int cnt=0;
		Arrays.sort(a);
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++)
				if(BinarySearch.rank(-a[i]-a[j],a)>j) cnt++; 
		return cnt;
	}
}