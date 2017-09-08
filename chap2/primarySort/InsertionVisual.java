package algorithms.chap2.primarySort;

import edu.princeton.cs.algs4.*;
/*
 *@version 1.0 2017-8-11
 *@author SHAN Haodong
 *@test 2.1.18
 */
public class InsertionVisual
{
	private static double MAX_VALUE=100.0;
	public static void sort(Double[] a)
	{
		int N=a.length;
		double yscale=MAX_VALUE*0.05;
		StdDraw.setXscale(0,a.length+1);
		StdDraw.setYscale(0,MAX_VALUE*1.1*N-MAX_VALUE);;
		for(int i=1;i<N;i++)
		{
			int j=1;
			for(j=i;j>0&&less(a[j],a[j-1]);j--)
				{
					StdDraw.setPenColor(StdDraw.RED);
				  StdDraw.filledRectangle(j,yscale+a[j]/2,0.25,a[j]/2.0);
					StdDraw.setPenColor(StdDraw.BLACK);
				  StdDraw.filledRectangle(j+1,yscale+a[j-1]/2,0.25,a[j-1]/2.0);
					exch(a,j,j-1);
					
				}
				if(j==i) 
				{
					StdDraw.setPenColor(StdDraw.RED);
				  StdDraw.filledRectangle(j+1,yscale+a[j]/2,0.25,a[j]/2.0);
				}
			paint(a,yscale,i,j);
			yscale+=MAX_VALUE*1.1;
		}
	}
	public static void paint(Double[] a,double yscale,int i,int j)
	{
		StdDraw.setPenColor(StdDraw.GRAY);
		for(int k=0;k<a.length;k++)
			if(k<j||k>i)
				StdDraw.filledRectangle(k+1,yscale+a[k]/2,0.25,a[k]/2.0);
	}
	
	/*
	 *@version 1.0 2017-8-15
	 *@author SHAN Haodong
	 *@test 2.1.17
	 */
	 /*
	public static void sort(Double[] a)
	{
		int N=a.length;
		double yscale=MAX_VALUE*1.1;
		StdDraw.setXscale(0,a.length+1);
		StdDraw.setYscale(0,yscale);;
		for(int i=1;i<N;i++)
		{
			int j=1;
			for(j=i;j>0&&less(a[j],a[j-1]);j--)
				{
					exch(a,j,j-1);
				}
			paint(a,yscale);
		}
	}
	public static void paint(Double[] a,double yscale)
	{
		StdDraw.clear(StdDraw.WHITE);
		for(int i=0;i<a.length;i++)
		StdDraw.filledRectangle(i+1,a[i]/2,0.25,a[i]/2.0);
	}*/
	private static boolean less(Double v,Double w)
	{
		return v.compareTo(w)<0;
	}
	private static void exch(Double[]a,int i,int j)
	{
		Double t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Double[] a)
	{
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	public static boolean isSorted(Double[] a)
	{
		for(int i=1;i<a.length;i++)
			if(less(a[i],a[i-1])) return false;
		return true;
	}
	public static void main(String[] args)
	{
		int N=Integer.parseInt(args[0]);
		Double[] a=new Double[N];
		for(int i=0;i<N;i++)
		{
			a[i]=StdRandom.uniform(0,MAX_VALUE);
		}
		sort(a);
		assert isSorted(a);
		show(a);
	}
}