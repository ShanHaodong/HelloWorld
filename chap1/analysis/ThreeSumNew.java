package algorithms.chap1.analysis;
import edu.princeton.cs.algs4.*;
/*
 *@author SHAN Haodong
 *@version 1.0 2017-8-9
 *@test 1.4.38
 *
 */
public class ThreeSumNew
{
	public static void main(String[] args)
	{
		
	}
	
	public static int count(int[] a)
	{
		int N=a.length;
		int cnt=0;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				for(int k=0;k<N;k++)
					if(i<j&&j<k)
						if(a[i]+a[j]+a[k]==0) cnt++;
		return cnt;
	}
}