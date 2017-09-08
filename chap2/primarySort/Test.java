package algorithms.chap2.primarySort;
import edu.princeton.cs.algs4.*;
public class Test
{
	public static void main(String[] args)
	{
		Double[] a=new Double[Integer.parseInt(args[0])];
		for(int i=0;i<a.length;i++)
			a[i]=a.length-i*1.0;
		/*for(int i=0;i<a.length;i++)
			a[i]=StdRandom.uniform(0.0,100.0);*/
		Stopwatch timer=new Stopwatch();
		Merge.sort(a);
		double time=timer.elapsedTime();
		assert Shell.isSorted(a);
		StdOut.println("Time cost:"+time);
	}
}