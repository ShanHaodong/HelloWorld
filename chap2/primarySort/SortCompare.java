package algorithms.chap2.primarySort;
import edu.princeton.cs.algs4.*;
//import algorithms.chap1.analysis.Stopwatch;
/*
 *@author SHAN Haodong
 *@version 1.0 2017-8-11
 *@details compare the InsertionSort and SelectionSort
 *@ use java algorithms/chap2/primarySort Insertion Selection 100 1000
 */
public class SortCompare
{
	public static void main(String[] args)
	{
		String alg1=args[0];
		String alg2=args[1];
		int N=Integer.parseInt(args[2]);
		int T=Integer.parseInt(args[3]);
		double t1=timeRandomInput(alg1,N,T);
		double t2=timeRandomInput(alg2,N,T);
		StdOut.printf("For %d random Doubles\n	%s is",N,alg1);
		StdOut.printf(" %.1f times faster than %s\n",t2/t1,alg2);
	}
	
	//统计用alg方法对N个长度为T的Double数组进行排序，返回排序所用的时间
	public static double timeRandomInput(String alg,int N,int T)
	{
		double total=0.0;
		Double[] a=new Double[T];
		for(int t=0;t<N;t++)
		{
			for(int i=0;i<T;i++)
				a[i]=StdRandom.uniform();
			total+=time(alg,a);
		}
		return total;
	}
	
	//返回使用alg方法对Double数组a排序所用的时间
	public static double time(String alg,Double[] a)
	{
		Stopwatch timer=new Stopwatch();
		if(alg.equals("Insertion")) Insertion.sort(a);
		else if(alg.equals("Selection")) Selection.sort(a);
		else if(alg.equals("Shell")) Shell.sort(a);
		else if(alg.equals("Merge")) Merge.sort(a);
		else if(alg.equals("MergeBU")) MergeBU.sort(a);
		else if(alg.equals("Quick")) Quick.sort(a);
		else if(alg.equals("Heap")) Heap.sort(a);
		else {throw new RuntimeException("No sort function find!");}
		return timer.elapsedTime();
	}
}